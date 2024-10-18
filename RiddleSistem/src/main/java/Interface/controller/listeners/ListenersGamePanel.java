package Interface.controller.listeners;

import Interface.controller.ViewController;
import model.BinaryTree;
import model.ManagementPersistence;
import model.Node;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class ListenersGamePanel {
    private final ViewController viewController;
    private BinaryTree binaryTree;
    private Node currentNode;

    public ListenersGamePanel(ViewController viewController) {
        this.viewController = viewController;
        this.binaryTree = new ManagementPersistence().loadTree(); // Cargar el árbol binario desde JSON
        this.currentNode = binaryTree.getRoot(); // Inicializar con la raíz del árbol
        addListeners(); //Inicializar los listeners
        startGame(); // Mostrar la pregunta inicial del nodo raíz
    }

    // Añadir listeners a los botones "Si" y "No"
    private void addListeners() {
        viewController.getMainPanel().getGamePanel().getBotonSi().addActionListener(e -> {
            handleAnswer(true); // Manejar respuesta "Sí"
        });
        viewController.getMainPanel().getGamePanel().getBotonNo().addActionListener(e -> {
            handleAnswer(false); // Manejar respuesta "No"
        });
    }

    // Iniciar el juego mostrando la pregunta del nodo raíz
    private void startGame() {
        if (currentNode != null) {
            viewController.getMainPanel().getGamePanel().getQuestionLabel().setText(currentNode.getQuestion());
        } else {
            viewController.getMainPanel().getGamePanel().getQuestionLabel().setText("Error: El nodo raíz es nulo.");
        }
    }

    // Manejar la respuesta del usuario y avanzar en el arbol
    private void handleAnswer(boolean isYes) {
        if (currentNode != null && !currentNode.isAnswer()) {
            // Avanzar al nodo siguiente basado en la respuesta
            currentNode = isYes ? currentNode.getYes() : currentNode.getNo();
            // Verificar si el nodo siguiente es una respuesta
            if (currentNode.isAnswer()) {
                // Mostrar la respuesta final basada en si se adivino correctamente o no
                showFinalAnswer(isYes);
            } else {
                // Si no es una respuesta, mostrar la nueva pregunta
                viewController.getMainPanel().getGamePanel().getQuestionLabel().setText(currentNode.getQuestion());
            }
        } else if (currentNode != null && currentNode.isAnswer()) {
            // Si ya estamos en un nodo respuesta, manejar directamente el caso final
            showFinalAnswer(isYes);
        } else {
            viewController.getMainPanel().getGamePanel().getQuestionLabel().setText("Error: Nodo actual es nulo o no es una respuesta.");
        }
    }

    // Mostrar la respuesta final y reiniciar el juego o cambiar al otro panel
    private void showFinalAnswer(boolean isYes) {
        if (currentNode != null && currentNode.isAnswer()) {
            if (isYes) {
                // El jugador ha confirmado que adivinamos correctamente el animal
                JOptionPane.showMessageDialog(null, "<html><p style='font-size:14px; color:green;'>¡ Se adivino el animal con exito ! : " + currentNode.getAnswer() + "</p></html>", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                resetGame(); // Reiniciar el juego después de adivinar correctamente
            } else {
                // El jugador ha indicado que no adivinamos correctamente el animal
                JOptionPane.showMessageDialog(null, "<html><p style='font-size:14px;'>No se ha podido adivinar el animal , cambiando al panel de añadir...</p></html>", "Fallo", JOptionPane.ERROR_MESSAGE);
                changeVisibility(); // Cambiar al panel de agregar nuevo animal
            }
        } else {
            viewController.getMainPanel().getGamePanel().getQuestionLabel().setText("Error: Nodo actual es nulo o no es una respuesta.");
        }
    }

    // Método para reiniciar el juego
    private void resetGame() {
        currentNode = binaryTree.getRoot(); // Volver al nodo raíz
        startGame(); // Mostrar la pregunta inicial nuevamente
    }

    // Método para cambiar de panel cuando no se adivina el animal
    private void changeVisibility() {
        viewController.getMainPanel().getGamePanel().setVisible(false); // Ocultar panel de juego
        viewController.getMainPanel().getAddPanel().setVisible(true); // Mostrar panel de agregar
        // Añadir KeyBinding para Ctrl + 9
        InputMap inputMap = viewController.getMainPanel().getAddPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = viewController.getMainPanel().getAddPanel().getActionMap();

        // Vincular la combinación de teclas Ctrl + 9 con la acción
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_9, KeyEvent.CTRL_DOWN_MASK), "control9Pressed");

        // Definir la acción que ocurrirá cuando se presione Ctrl + 9
        actionMap.put("control9Pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                binaryTree.printTree();
            }
        });
        listenerAddPanel();
    }


    private void listenerAddPanel(){
        // Añadir listener al botón de aceptar del panel de agregar
        viewController.getMainPanel().getAddPanel().getAcceptButton().addActionListener(e -> {
            //Extraer los textos actuales de los field
            String animal = viewController.getMainPanel().getAddPanel().getAnimalField().getText().toLowerCase().trim();
            String question = viewController.getMainPanel().getAddPanel().getQuestionField().getText().toLowerCase().trim();
            if(animal.isEmpty()||question.isEmpty()){ //Verificar que tengan contenido
                JOptionPane.showMessageDialog(null, "<html><p style='font-size:14px;'>Por favor rellene todos los campos.</p></html>", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
                // Crear nuevos nodos para la pregunta y el nuevo animal
                Node newAnimalNode = new Node(animal,true);
                Node currentAnimalNode = new Node(currentNode.getAnswer(),true);
                // Actualizar la estructura del árbol
                currentNode.setAnswer(null);
                currentNode.setYes(newAnimalNode);
                currentNode.setNo(currentAnimalNode);
                currentNode.setQuestion(question);
                // Reiniciar el juego después de agregar el nuevo animal
                JOptionPane.showMessageDialog(null, "Informacion guardada con exito . Reiniciando el juego...", "Información", JOptionPane.INFORMATION_MESSAGE);
                viewController.getMainPanel().getAddPanel().getAnimalField().setText("");
                viewController.getMainPanel().getAddPanel().getQuestionField().setText("");
                viewController.getMainPanel().getAddPanel().setVisible(false);
                viewController.getMainPanel().getGamePanel().setVisible(true);
                resetGame(); // Reiniciar el juego
            }
        });
        listenerCancelButton();
    }

    private void listenerCancelButton(){
        viewController.getMainPanel().getAddPanel().getCancelButton().addActionListener(e -> {
            viewController.getMainPanel().getAddPanel().getAnimalField().setText("");
            viewController.getMainPanel().getAddPanel().getQuestionField().setText("");
            resetGame(); // Reiniciar el juego
            viewController.getMainPanel().getAddPanel().setVisible(false);
            viewController.getMainPanel().getGamePanel().setVisible(true);
        });
    }

}