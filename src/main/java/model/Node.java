package model;

public class Node {
    String question; // Esto puede ser una pregunta o un objeto.
    Node si;     // Apuntador a la rama "sí".
    Node no;     // Apuntador a la rama "no".

    //Constructor para inicializar los valores del nodo
    public Node(String question) {
        this.question = question;
        this.si = null;
        this.no = null;
    }
}