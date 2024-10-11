package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManagementPersistence {

    private final Gson gson;

    public ManagementPersistence() {
        gson = new GsonBuilder().setPrettyPrinting().create(); // Se formatea el json par hacerlo mas legible
    }

    // Metodo para guardar el arbol en un json
    public void saveTree(BinaryTree tree) {
        try (FileWriter writer = new FileWriter("resources/animals.json")) {
            gson.toJson(tree.getRoot(), writer); // Convierte el arbol a json
            System.out.println("Árbol guardado correctamente en JSON.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo que carga el arbol desde un json
    public BinaryTree loadTree() {
        BinaryTree tree = new BinaryTree();
        try (FileReader reader = new FileReader("resources/animals.json")) {
            Node root = gson.fromJson(reader, Node.class); // Convierte el JSON a un nodo
            tree.setRoot(root);
            System.out.println("Árbol cargado correctamente desde JSON.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tree;
    }
}