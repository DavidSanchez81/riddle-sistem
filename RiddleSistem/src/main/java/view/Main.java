package view;

import model.BinaryTree;
import model.ManagementPersistence;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagementPersistence persistence = new ManagementPersistence();
        Scanner scanner = new Scanner(System.in);
        // Se carga el arbol desde el archivo JSON
        BinaryTree tree = persistence.loadTree();

        System.out.println("Por favor digite una opcion : ");
        System.out.println("1.Iniciar juego");
        System.out.println("2.Ver arbol");
        int option = scanner.nextInt();
        scanner.nextLine(); // evita que se cole un salto d linea

        switch (option){
            case 1:
                tree.changeSon();
                break;
            case 2:
                tree.printTree();
                break;
            default:
                System.out.println("digite una opcion valida");
        }
    }
}