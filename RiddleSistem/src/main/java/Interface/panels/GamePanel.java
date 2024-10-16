package Interface.panels;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    // Componentes de la interfaz
    private JLabel titleLabel; // Etiqueta para el título
    private JButton botonSi, botonNo; // Botones para las respuestas
    private JTextArea questionLabel; // Área de texto para mostrar la pregunta
    private JLabel gifLabel; // Etiqueta para mostrar el GIF

    // Constructor
    public GamePanel() {
        initializeComponents(); // Inicializa los componentes de la interfaz
        setLayout(new GridBagLayout()); // Establece GridBagLayout como el layout del panel
        GridBagConstraints gbc = new GridBagConstraints(); // Crea un objeto GridBagConstraints para organizar el layout
        gbc.weightx = 1; // Expande horizontalmente los componentes
        gbc.weighty = 1; // Expande verticalmente los componentes
        gbc.fill = GridBagConstraints.HORIZONTAL; // Ocupa todo el espacio horizontalmente

        Dimension buttonDimension = new Dimension(80, 40); // Dimensiones para los botones

        // Configuración del título
        titleLabel.setPreferredSize(new Dimension(400, 50)); // Aumentar el tamaño para que ocupe más espacio
        titleLabel.setForeground(new Color(246, 171, 73)); // Establece el color del texto del título
        titleLabel.setOpaque(true); // Permite que el color de fondo sea visible
        titleLabel.setBackground(new Color(70, 60, 61)); // Color de fondo del título
        titleLabel.setBorder(BorderFactory.createEmptyBorder(4, 0, 5, 0)); // Borde vacío alrededor del título
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 25)); // Define la fuente del título
        gbc.gridx = 0; // Asegurar que el título comience en la columna 0
        gbc.gridy = 0; // Posición del título en la fila 0
        gbc.gridwidth = 3; // Hacer que el título ocupe tres columnas (todo el ancho)
        gbc.anchor = GridBagConstraints.CENTER; // Centra el título
        gbc.insets = new Insets(20, 0, 5, 0); // Añade espacio alrededor del título
        add(titleLabel, gbc); // Añade el título al panel

        // Añadir el GIF entre el título y la pregunta
        ImageIcon gifIcon = new ImageIcon("C:\\Users\\skson\\OneDrive\\Documents\\Sistema Adivinanzas\\RiddleSistem\\src\\resources\\llama.gif"); // Cargar el GIF
        gifLabel = new JLabel(gifIcon); // Crear etiqueta para el GIF
        gbc.gridx = 0; // Colocar el GIF en la columna 0
        gbc.gridy = 1; // Colocar el GIF en la fila 1 (entre título y pregunta)
        gbc.gridwidth = 3; // Hacer que el GIF ocupe tres columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centrar el GIF
        gbc.insets = new Insets(10, 0, 10, 0); // Ajustar los márgenes para el GIF
        add(gifLabel, gbc); // Añadir GIF al panel

        // Añadir área de texto para la pregunta
        JPanel textPanel = new JPanel(new GridBagLayout()); // Panel para centrar el área de texto
        GridBagConstraints gbcText = new GridBagConstraints(); // Configuración para centrar el JTextArea
        gbcText.gridx = 0;
        gbcText.gridy = 0;
        gbcText.anchor = GridBagConstraints.CENTER; // Centrar el JTextArea
        textPanel.add(questionLabel, gbcText); // Añadir el JTextArea al panel

        textPanel.setBackground(new Color(50, 43, 45)); // Fondo oscuro del panel para que coincida con el JTextArea

        JScrollPane scrollPane = new JScrollPane(textPanel); // Envolver el panel en un JScrollPane
        scrollPane.setPreferredSize(new Dimension(400, 110)); // Ajustar tamaño de la pregunta
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Añadir borde negro

        // Colocar el JScrollPane en el panel principal
        gbc.gridx = 0; // Posicionar el panel en la columna 0
        gbc.gridy = 2; // Posicionar área de texto en la tercera fila
        gbc.gridwidth = 2; // Hacer que ocupe dos columnas (ajusta según el espacio necesario)
        gbc.insets = new Insets(4, 10, 3, 10); // Ajustar los márgenes
        add(scrollPane, gbc); // Añadir al panel principal

        // Panel para los botones "Sí" y "No"
        JPanel categoriaPanel = createButtonPanel(botonSi, botonNo, buttonDimension); // Crear panel para los botones
        gbc.gridx = 0; // Centrar el panel de botones en la columna 0
        gbc.gridy = 3; // Posicionar el panel de botones en la cuarta fila
        gbc.gridwidth = 3; // Hacer que el panel ocupe tres columnas
        gbc.insets = new Insets(10, 0, 20, 0); // Ajustar los márgenes
        gbc.anchor = GridBagConstraints.CENTER; // Centrar los botones
        add(categoriaPanel, gbc); // Añadir el panel de botones al panel principal

        // Configuración general del panel principal
        setBackground(new Color(50, 43, 45)); // Fondo del panel
        setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde negro del panel
    }

    // Método para inicializar los componentes
    private void initializeComponents() {
        titleLabel = new JLabel("Riddle System", SwingConstants.CENTER); // Crear el título y centrarlo
        titleLabel.setFont(new Font("Lato", Font.BOLD, 30)); // Fuente del título

        botonSi = createStyledButton("Sí", new Dimension(80, 40)); // Crear botón "Sí"
        botonNo = createStyledButton("No", new Dimension(80, 40)); // Crear botón "No"

        // Configuración del área de texto para la pregunta
        questionLabel = new JTextArea("¿La tierra es plana?"); // Pregunta predeterminada
        questionLabel.setLineWrap(false); // Desactivar ajuste de líneas
        questionLabel.setWrapStyleWord(false); // Desactivar ajuste por palabras
        questionLabel.setEditable(false); // Área de texto no editable
        questionLabel.setFont(new Font("Montserrat", Font.PLAIN, 24)); // Fuente del texto
        questionLabel.setForeground(Color.WHITE); // Texto en blanco
        questionLabel.setBackground(new Color(50, 43, 45)); // Fondo oscuro
        questionLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Borde vacío
    }

    // Crear panel para los botones "Sí" y "No"
    private JPanel createButtonPanel(JButton button1, JButton button2, Dimension dimension) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0)); // Panel con FlowLayout centrado
        panel.setOpaque(false); // Panel transparente
        button1.setPreferredSize(dimension); // Tamaño del botón "Sí"
        button2.setPreferredSize(dimension); // Tamaño del botón "No"
        panel.add(button1); // Añadir botón "Sí"
        panel.add(button2); // Añadir botón "No"
        return panel; // Devolver panel con botones
    }

    // Método para crear un botón con estilo
    private JButton createStyledButton(String text, Dimension dimension) {
        JButton button = new JButton(text); // Crear botón con texto
        button.setPreferredSize(dimension); // Establecer tamaño
        button.setFont(new Font("Montserrat", Font.BOLD, 16)); // Fuente del botón
        button.setForeground(Color.WHITE); // Texto en blanco
        button.setBackground(new Color(70, 60, 61)); // Fondo oscuro
        button.setFocusPainted(false); // Sin borde de foco
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde negro
        button.setContentAreaFilled(false); // Estilo plano
        button.setOpaque(true); // Fondo visible
        return button; // Devolver botón
    }

    // Métodos getter para acceder a los componentes
    public JButton getBotonSi() {
        return botonSi; // Devolver botón "Sí"
    }

    public JButton getBotonNo() {
        return botonNo; // Devolver botón "No"
    }

    public JTextArea getQuestionLabel() {
        return questionLabel; // Devolver área de texto de la pregunta
    }
}