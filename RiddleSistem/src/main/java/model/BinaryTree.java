package model;
import java.util.Scanner;

// Clase que se ejecuta luego de tener ya el arbol cargado desde el archivo JSON
public class BinaryTree  {

    private Node root;

    public BinaryTree() {
        root = null; //La raiz empieza en null porque aun no hay una pregunta
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    //Metodo  utilizado para recorrer el arbol
    public void changeSon() {
        Node current = root;
        Scanner scanner = new Scanner(System.in);

        if (current == null) {
            System.out.println("El arbol está vacío.");
            return;
        }

        while (!current.isAnswer()) { // Si el nodo actual  no es una respuesta final
            System.out.println(current.getQuestion()); // Imprime la pregunta actual
            String answer = scanner.nextLine().toLowerCase(); // la respuesta la parsea a minuscula

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
        String answer = scanner.nextLine().toLowerCase(); //parsea a minuscula

        if (answer.equals("si")) {
            System.out.println("Animal adivinado con éxito");
        } else {
            System.out.println("No se ha podido adivinar el animal");
        }
    }

    //Metodos para imprimir el arbol de frma detallada
    public void printTree() {
        printTree(root, 0); // Se inicia la impresion desde la raiz con el nivel 0
    }

    //Metodo recursivo que imprime añadiendo caracteres
    private void printTree(Node node, int level) {
        if (node == null) {
            return; // No se imprime nada si el nodo es nulo
        }

        // se añade identacion segun el nivel del nodo
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
}
