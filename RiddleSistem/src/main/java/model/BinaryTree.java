package model;

import java.util.Scanner;

public class BinaryTree {
    //Clase donde se define el comportamiento del arbol
    private Node root;

    public BinaryTree(){
        //El arbol empieza vacio
        root = null;
    }

    //Metodo que cambia de hijo dependiendo la respuesta del usuario (si/no) ( si tiene hijos el nodo actual )
    public void changeSon(){
        Node current = root; // empieza desde la raiz
        Scanner scanner = new Scanner(System.in);
        while (current.si != null && current.no !=null){ //Si tiene hijos el nodo actual
            System.out.println(current.question); //imprime la pregunta actual
            String answer = scanner.nextLine().toLowerCase(); // guarda la respuesta en minuscula
            if(answer.equals("si")){
                current = current.si; //moverse al hijo si
            }else {
                current = current.no; //moverse al hijo no
            }
        }
    }
}