package view;

import model.BinaryTree;
import model.ManagementPersistence;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagementPersistence persistence = new ManagementPersistence();
        Scanner scanner = new Scanner(System.in);
        
        // Se carga el árbol desde el archivo JSON
        BinaryTree tree = persistence.loadTree();

        // Menú principal
        while (true) {
            System.out.println("\nPor favor digite una opción:");
            System.out.println("1. Iniciar juego");
            System.out.println("2. Ver árbol");
            System.out.println("3. Salir");
            int option = scanner.nextInt();
            scanner.nextLine(); // evita que se cole un salto de línea

            switch (option) {
                case 1:
                    tree.changeSon(); // Inicia el juego
                    break;
                case 2:
                    tree.printTree(); // Muestra el árbol
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    scanner.close(); // Cierra el scanner para liberar recursos
                    return; // Sale del bucle
                default:
                    System.out.println("Digite una opción válida. Intente de nuevo.");
            }
        }
    }
}
