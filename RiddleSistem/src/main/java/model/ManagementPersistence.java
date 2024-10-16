package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ManagementPersistence {

    public static final String filePath = "src\\resources\\animals.json";


    private final Gson gson;

    public ManagementPersistence() {
        // Se crea un objeto Gson con formato de impresión para hacer el JSON más legible
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // Método para guardar el árbol en un JSON con una ruta personalizada
    public void saveTree(BinaryTree tree) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(tree.getRoot(), writer); // Convierte el árbol a JSON
            System.out.println("Árbol guardado correctamente en JSON en: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al guardar el árbol en JSON:");
            e.printStackTrace();
        }
    }

    // Método que carga el árbol desde un JSON con una ruta personalizada
    public BinaryTree loadTree() {
        BinaryTree tree = new BinaryTree();
        System.out.println(filePath);
        if (filePath == null) {
            System.out.println("La ruta del archivo no puede ser nula.");
            return tree;
        }

        Path path = Paths.get(filePath);

        // Verificar si el archivo existe
        if (!Files.exists(path)) {
            System.out.println("El archivo JSON no existe en la ruta especificada: " + filePath);
            return tree;
        }

        try (FileReader reader = new FileReader(filePath)) {
            Node root = gson.fromJson(reader, Node.class); // Convierte el JSON a un nodo
            tree.setRoot(root);
            System.out.println("Árbol cargado correctamente desde JSON: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al cargar el árbol desde JSON:");
            e.printStackTrace();
        }
        return tree;
    }
}
