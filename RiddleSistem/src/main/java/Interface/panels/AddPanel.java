package Interface.panels;

import javax.swing.*;
import java.awt.*;

public class AddPanel extends JPanel {

    private JTextField animalField; // Campo de texto para ingresar el nombre de un animal
    private JTextField questionField; // Campo de texto para ingresar una pregunta
    private JButton acceptButton; // Botón de aceptar
    private JButton cancelButton; // Botón de cancelar
    private JLabel titleLabel; // Etiqueta del título
    private JLabel animalLabel; // Etiqueta para el campo del animal
    private JLabel questionLabel; // Etiqueta para el campo de la pregunta

    public AddPanel() {

        initializeComponents(); // Inicializa los componentes

        setLayout(new GridBagLayout()); // Establece el layout del panel como GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints(); // Define restricciones para GridBagLayout
        gbc.weightx = 1; // Expande horizontalmente
        gbc.weighty = 1; // Expande verticalmente
        gbc.fill = GridBagConstraints.HORIZONTAL; // Ocupa todo el espacio horizontalmente

        Dimension labelDimension = new Dimension(150, 40); // Define el tamaño de las etiquetas
        Dimension fieldDimension = new Dimension(200, 40); // Define el tamaño de los campos de texto

        titleLabel.setPreferredSize(new Dimension(260, 50)); // Define el tamaño preferido del título
        titleLabel.setForeground(new Color(64, 193, 208)); // Color del texto del título
        titleLabel.setOpaque(true); // Permite que el fondo del título sea visible
        titleLabel.setBackground(new Color(70, 60, 61)); // Color de fondo del título
        titleLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Borde vacío alrededor del título
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 25)); // Define la fuente del título
        gbc.gridx = 0; // Posiciona el título en la primera columna
        gbc.gridy = 0; // Posiciona el título en la primera fila
        gbc.gridwidth = 2; // El título ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centra el título en su celda
        gbc.insets = new Insets(20, 0, 20, 0); // Espaciado alrededor del título
        add(titleLabel, gbc); // Añade el título al panel con las restricciones dadas

        animalLabel.setPreferredSize(labelDimension); // Define el tamaño preferido de la etiqueta de animal
        animalLabel.setBackground(new Color(240, 200, 214)); // Color de fondo de la etiqueta de animal
        animalLabel.setOpaque(true); // Permite que el fondo de la etiqueta sea visible
        animalLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto de la etiqueta
        animalLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde negro alrededor de la etiqueta
        gbc.gridwidth = 1; // La etiqueta ocupará una columna
        gbc.gridx = 0; // Coloca la etiqueta de animal en la primera columna
        gbc.gridy = 1; // Coloca la etiqueta de animal en la segunda fila
        gbc.anchor = GridBagConstraints.CENTER; // Centra la etiqueta en su celda
        gbc.insets = new Insets(10, 10, 10, 5); // Espaciado alrededor de la etiqueta
        add(animalLabel, gbc); // Añade la etiqueta de animal al panel

        animalField.setPreferredSize(fieldDimension); // Define el tamaño preferido del campo de texto del animal
        gbc.gridx = 1; // Coloca el campo de texto en la segunda columna
        gbc.anchor = GridBagConstraints.CENTER; // Centra el campo de texto en su celda
        gbc.insets = new Insets(10, 0, 10, 10); // Espaciado alrededor del campo de texto
        add(animalField, gbc); // Añade el campo de texto del animal al panel

        questionLabel.setPreferredSize(labelDimension); // Define el tamaño preferido de la etiqueta de la pregunta
        questionLabel.setBackground(new Color(113, 15, 61)); // Color de fondo de la etiqueta de la pregunta
        questionLabel.setOpaque(true); // Permite que el fondo de la etiqueta sea visible
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto de la etiqueta
        questionLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde negro alrededor de la etiqueta
        gbc.gridx = 0; // Coloca la etiqueta de la pregunta en la primera columna
        gbc.gridy = 2; // Coloca la etiqueta de la pregunta en la tercera fila
        gbc.anchor = GridBagConstraints.CENTER; // Centra la etiqueta en su celda
        gbc.insets = new Insets(10, 10, 10, 5); // Espaciado alrededor de la etiqueta
        add(questionLabel, gbc); // Añade la etiqueta de la pregunta al panel

        questionField.setPreferredSize(fieldDimension); // Define el tamaño preferido del campo de texto de la pregunta
        gbc.gridx = 1; // Coloca el campo de texto en la segunda columna
        gbc.anchor = GridBagConstraints.CENTER; // Centra el campo de texto en su celda
        gbc.insets = new Insets(10, 0, 10, 10); // Espaciado alrededor del campo de texto
        add(questionField, gbc); // Añade el campo de texto de la pregunta al panel

        gbc.gridx = 0; // Coloca el panel de botones en la primera columna
        gbc.gridy = 5; // Coloca el panel de botones en la sexta fila
        gbc.gridwidth = 2; // El panel de botones ocupará dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centra el panel de botones
        gbc.insets = new Insets(20, 0, 20, 0); // Espaciado alrededor del panel de botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0)); // Panel con FlowLayout para los botones
        buttonPanel.setOpaque(false); // Hace el panel transparente
        buttonPanel.add(acceptButton); // Añade el botón de aceptar al panel
        buttonPanel.add(cancelButton); // Añade el botón de cancelar al panel
        add(buttonPanel, gbc); // Añade el panel de botones al panel principal

        setBackground(new Color(50, 43, 45)); // Color de fondo del panel principal
        setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde negro alrededor del panel principal
    }

    private void initializeComponents() {

        titleLabel = new JLabel("Riddle System", SwingConstants.CENTER); // Etiqueta del título con texto centrado
        titleLabel.setFont(new Font("Lato", Font.BOLD, 28)); // Fuente y tamaño del título

        animalLabel = createMinimalLabel(" ¿Qué animal estás pensando?"); // Crea la etiqueta para el campo del animal
        questionLabel = createMinimalLabel(" ¿Pregunta para este animal?"); // Crea la etiqueta para el campo de la pregunta

        animalField = createMinimalTextField(20); // Crea el campo de texto para ingresar el animal
        animalField.setName("animal"); // Nombre del campo de texto para identificación
        animalField.setBackground(new Color(152, 139, 148)); // Color de fondo del campo de texto
        questionField = createMinimalTextField(20); // Crea el campo de texto para ingresar la pregunta
        questionField.setName("question"); // Nombre del campo de texto para identificación
        questionField.setBackground(new Color(152, 139, 148)); // Color de fondo del campo de texto

        Dimension buttonDimension = new Dimension(200, 40); // Tamaño preferido de los botones
        acceptButton = createStyledButton("Aceptar", buttonDimension); // Crea el botón de aceptar
        cancelButton = createStyledButton("Cancelar", buttonDimension); // Crea el botón de cancelar
    }

    private JLabel createMinimalLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER); // Crea una etiqueta con texto centrado
        label.setFont(new Font("Montserrat", Font.BOLD, 16)); // Fuente y tamaño del texto
        label.setForeground(Color.BLACK); // Color del texto
        label.setBorder(BorderFactory.createCompoundBorder( // Borde compuesto: línea y espacio alrededor del texto
                BorderFactory.createLineBorder(new Color(70, 60, 61)),
                BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        label.setOpaque(true); // Permite que el fondo sea visible
        label.setBackground(new Color(225, 193, 158)); // Color de fondo de la etiqueta
        label.setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto horizontalmente
        label.setVerticalAlignment(SwingConstants.CENTER); // Centra el texto verticalmente
        return label; // Retorna la etiqueta creada
    }

    private JTextField createMinimalTextField(int columns) {
        JTextField textField = new JTextField(columns); // Crea un campo de texto con el número de columnas especificado
        textField.setFont(new Font("Montserrat", Font.PLAIN, 16)); // Fuente y tamaño del texto
        textField.setBorder(BorderFactory.createCompoundBorder( // Borde compuesto: línea y espacio alrededor del texto
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        return textField; // Retorna el campo de texto creado
    }

    private JButton createStyledButton(String text, Dimension dimension) {
        JButton button = new JButton(text); // Crea un botón con el texto especificado
        button.setPreferredSize(dimension); // Define el tamaño preferido del botón
        button.setFont(new Font("Montserrat", Font.BOLD, 16)); // Fuente y tamaño del texto
        button.setForeground(Color.WHITE); // Color del texto
        button.setBackground(new Color(70, 60, 61)); // Color de fondo del botón
        button.setFocusPainted(false); // Desactiva el enfoque pintado
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde negro alrededor del botón
        button.setContentAreaFilled(false); // Desactiva el área de contenido relleno
        button.setOpaque(true); // Permite que el fondo del botón sea visible
        return button; // Retorna el botón creado
    }

    // Getters para acceder a los componentes fuera de la clase
    public JTextField getAnimalField() {
        return animalField;
    }
    public JTextField getQuestionField() {
        return questionField;
    }
    public JButton getAcceptButton() {
        return acceptButton;
    }
    public JButton getCancelButton(){
        return cancelButton;
    }
}