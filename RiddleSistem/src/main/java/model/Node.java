package model;

public class Node {
    private String question; // Pregunta que irá en el nodo
    private Node yes;        // Nodo para la respuesta afirmativa
    private Node no;         // Nodo para la respuesta negativa
    private String answer;    // Para almacenar el nombre del animal

    // Constructor para preguntas
    public Node(String question) {
        this.question = question;
    }

    // Constructor para respuestas finales
    public Node(String answer, boolean isAnswer) {
        if (isAnswer) {
            this.answer = answer;
        } else {
            this.question = answer;
        }
    }

    // Getters y Setters
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Node getYes() {
        return yes;
    }

    public void setYes(Node yes) {
        this.yes = yes;
    }

    public Node getNo() {
        return no;
    }

    public void setNo(Node no) {
        this.no = no;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    // Método que sirve para saber si el nodo actual es una respuesta final
    public boolean isAnswer() {
        return answer != null;
    }

    // Método para obtener una representación en cadena del nodo
    @Override
    public String toString() {
        if (isAnswer()) {
            return "Respuesta: " + answer;
        } else {
            return "Pregunta: " + question;
        }
    }

    // Método para obtener un resumen del nodo y sus hijos
    public String getSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append(this.toString()).append("\n");

        // Recursivamente agrega el resumen de los nodos hijos
        if (yes != null) {
            summary.append("  Sí -> ").append(yes.getSummary());
        } else {
            summary.append("  Sí -> null\n");
        }

        if (no != null) {
            summary.append("  No -> ").append(no.getSummary());
        } else {
            summary.append("  No -> null\n");
        }

        return summary.toString();
    }

    // Método para comprobar si el nodo tiene hijos
    public boolean hasChildren() {
        return yes != null || no != null;
    }
}