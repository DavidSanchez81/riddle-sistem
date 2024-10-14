package model;

import java.util.Scanner;

// Clase que se ejecuta luego de tener ya el árbol cargado desde el archivo JSON
public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null; // La raíz empieza en null porque aún no hay una pregunta
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    // Método utilizado para recorrer el árbol
    public void changeSon() {
        Node current = root;
        Scanner scanner = new Scanner(System.in);

        if (current == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        while (!current.isAnswer()) { // Si el nodo actual no es una respuesta final
            System.out.println(current.getQuestion()); // Imprime la pregunta actual
            String answer = scanner.nextLine().toLowerCase(); // la respuesta la parsea a minúscula

            if (answer.equals("si")) {
                current = current.getYes(); // Moverse al hijo "sí"
            } else if (answer.equals("no")) {
                current = current.getNo(); // Moverse al hijo "no"
            } else {
                System.out.println("Por favor, responde solo con 'sí' o 'no'.");
            }
        }

        // Si llegamos a un nodo hoja (en este caso a una respuesta )
        System.out.println("¿Estás pensando en un " + current.getAnswer() + "? (si/no)"); // Imprime el animal correspondiente
        String answer = scanner.nextLine().toLowerCase(); //parsea a minúscula

        if (answer.equals("si")) {
            System.out.println("Animal adivinado con éxito");
        } else {
            System.out.println("No se ha podido adivinar el animal");
            System.out.println("¿Qué animal estás pensando?");
            String newAnimal = scanner.nextLine();

            System.out.println("¿Qué pregunta puede diferenciarlo del " + current.getAnswer() + "?");
            String newQuestion = scanner.nextLine();

            // Crear nuevos nodos para la pregunta y el nuevo animal
            Node newAnimalNode = new Node(newAnimal);
            Node currentAnimalNode = new Node(current.getAnswer());

            // Actualizar la estructura del árbol
            current.setAnswer(false);
            current.setYes(newAnimalNode);
            current.setNo(currentAnimalNode);
            current.setQuestion(newQuestion);

            System.out.println("He aprendido algo nuevo.");
        }
    }

    // Método para imprimir el árbol de forma detallada
    public void printTree() {
        printTree(root, 0); // Se inicia la impresión desde la raíz con el nivel 0
    }

    // Método recursivo que imprime añadiendo caracteres
    private void printTree(Node node, int level) {
        if (node == null) {
            return; // No se imprime nada si el nodo es nulo
        }

        // Se añade indentación según el nivel del nodo
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indentation.append("   ");
        }

        // Se verifica si es un nodo hoja o una pregunta
        if (node.isAnswer()) {
            // Si es una hoja, imprime el animal
            System.out.println(indentation + "Nivel " + level + ": [Animal] " + node.getAnswer());
        } else {
            // Si es una pregunta, imprime la pregunta
            System.out.println(indentation + "Nivel " + level + ": [Pregunta] " + node.getQuestion());

            // Imprime el hijo "sí"
            if (node.getYes() != null) {
                System.out.println(indentation + "   ├── Hijo 'sí':");
                printTree(node.getYes(), level + 1); // Llama recursivamente para el hijo "sí"
            } else {
                System.out.println(indentation + "   ├── Hijo 'sí': null");
            }

            // Imprime el hijo "no"
            if (node.getNo() != null) {
                System.out.println(indentation + "   └── Hijo 'no':");
                printTree(node.getNo(), level + 1); // Llama recursivamente para el hijo "no"
            } else {
                System.out.println(indentation + "   └── Hijo 'no': null");
            }
        }
    }

    // Método para guardar el árbol en un archivo JSON (a implementar)
    public void saveTreeToJSON(String filePath) {
        // Implementación para guardar el árbol en formato JSON
    }

    // Método para buscar un nodo (opcional, a implementar)
    public boolean searchNode(String answer) {
        // Implementación de búsqueda en el árbol
        return searchNode(root, answer);
    }

    private boolean searchNode(Node node, String answer) {
        if (node == null) {
            return false; // Nodo no encontrado
        }
        if (node.isAnswer() && node.getAnswer().equalsIgnoreCase(answer)) {
            return true; // Nodo encontrado
        }
        // Recursión en hijos
        return searchNode(node.getYes(), answer) || searchNode(node.getNo(), answer);
    }

    // Método para eliminar un nodo (opcional, a implementar)
    public boolean deleteNode(String answer) {
        // Implementación para eliminar un nodo
        return deleteNode(root, answer);
    }

    private boolean deleteNode(Node node, String answer) {
        // Lógica para eliminar un nodo
        return false; // Implementar lógica aquí
    }
}
