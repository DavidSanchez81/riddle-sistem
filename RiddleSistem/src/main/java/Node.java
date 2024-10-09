public class Node {
    //Clase que define la estructura del nodo
    String question; //Pregunta.

    Node si;  // nodo que apunta a  la rama "sí".
    Node no;  // nodo que apunta a la rama "no".

    //Constructor para inicializar las ramas
    public Node(String question) {
        this.question = question;
        this.si = null;
        this.no = null;
    }
}
