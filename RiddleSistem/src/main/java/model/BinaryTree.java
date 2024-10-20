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
            getQuestion(current.getQuestion());
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
            Node newAnimalNode = new Node(newAnimal,true);
            Node currentAnimalNode = new Node(current.getAnswer(),true);

            // Actualizar la estructura del árbol
            current.setAnswer(null);
            current.setYes(newAnimalNode);
            current.setNo(currentAnimalNode);
            current.setQuestion(newQuestion);


            System.out.println("He aprendido algo nuevo.");
        }
    }

    // Método para imprimir el árbol de forma detallada
    public void printTree() {
        printTree(root, 0, ""); // Se inicia desde la raíz con el nivel 0 y sin prefijo
    }

    // Método recursivo que imprime añadiendo caracteres de estructura
    private void printTree(Node node, int level, String prefix) {
        if (node == null) {
            System.out.println(prefix + "null");
            return;
        }

        // Imprime el nivel y la pregunta o respuesta del nodo
        if (node.isAnswer()) {
            System.out.println(prefix + "Nivel " + level + ": [Animal] " + node.getAnswer());
        } else {
            System.out.println(prefix + "Nivel " + level + ": [Pregunta] " + node.getQuestion());

            // Manejar el hijo "sí" (izquierda)
            if (node.getYes() != null) {
                System.out.println(prefix + "   ├── Hijo 'sí':");
                printTree(node.getYes(), level + 1, prefix + "   │   "); // Llamada recursiva
            } else {
                System.out.println(prefix + "   ├── Hijo 'sí': null");
            }

            // Manejar el hijo "no" (derecha)
            if (node.getNo() != null) {
                System.out.println(prefix + "   └── Hijo 'no':");
                printTree(node.getNo(), level + 1, prefix + "       "); // Llamada recursiva
            } else {
                System.out.println(prefix + "   └── Hijo 'no': null");
            }
        }
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

    public String getQuestion(String question){
        return question;
    }

}