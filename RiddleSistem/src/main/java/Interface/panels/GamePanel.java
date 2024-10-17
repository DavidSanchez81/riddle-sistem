package Interface.panels;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private JLabel titleLabel, imageLabel;
    private JButton botonSi, botonNo;
    private JTextArea questionLabel;

    public GamePanel() {
        initializeComponents();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Dimensiones para botones
        Dimension buttonDimension = new Dimension(80, 40);

        // Configuración del título
        titleLabel.setPreferredSize(new Dimension(260, 50));
        titleLabel.setForeground(new Color(246, 171, 73));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(70, 60, 61));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        titleLabel.setFont(new Font("Lato", Font.BOLD, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 5, 0);
        add(titleLabel, gbc);

        // Configuración de la imagen sobre la pregunta
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Abarcar las dos columnas
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE; // Evita expansión
        gbc.insets = new Insets(0, 0, 10, 0);
        add(imageLabel, gbc);

        // Configuración del JTextArea con JScrollPane para la pregunta
        JScrollPane scrollPane = new JScrollPane(questionLabel);
        scrollPane.setPreferredSize(new Dimension(300, 100));
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(scrollPane, gbc);

        // Configuración de los botones "Sí" y "No"
        JPanel categoriaPanel = createButtonPanel(botonSi, botonNo, buttonDimension);
        gbc.gridy = 3;
        gbc.insets = new Insets(20, 0, 20, 0);
        add(categoriaPanel, gbc);

        // Configuración del botón "Reiniciar"
        gbc.gridy = 4;
        gbc.insets = new Insets(10, 0, 20, 0); // Espaciado adicional para el botón de reinicio
       // add(botonReiniciar, gbc);

        // Configuración general del panel
        setBackground(new Color(50, 43, 45));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void initializeComponents() {
        // Inicialización del título
        titleLabel = new JLabel("Riddle System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Lato", Font.BOLD, 28));

        // Inicialización de la imagen
        imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("C:/Users/skson/OneDrive/Pictures/temp/zi.jpg"); // Ruta correcta a la imagen
        Image scaledImage = imageIcon.getImage().getScaledInstance(480, 290,Image.SCALE_FAST);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centrar imagen dentro del JLabel
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Borde blanco

        // Inicialización de los botones
        botonSi = createStyledButton("Sí", new Dimension(80, 40));
        botonNo = createStyledButton("No", new Dimension(80, 40));

        // Inicialización del JTextArea para la pregunta
        questionLabel = new JTextArea("¿La tierra es plana?");
        questionLabel.setLineWrap(true);
        questionLabel.setWrapStyleWord(true);
        questionLabel.setEditable(false);
        questionLabel.setFont(new Font("Montserrat", Font.PLAIN, 18));
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setBackground(new Color(50, 43, 45));
        questionLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    }

    private JPanel createButtonPanel(JButton button1, JButton button2, Dimension dimension) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panel.setOpaque(false);
        button1.setPreferredSize(dimension);
        button2.setPreferredSize(dimension);
        panel.add(button1);
        panel.add(button2);
        return panel;
    }

    private JButton createStyledButton(String text, Dimension dimension) {
        JButton button = new JButton(text);
        button.setPreferredSize(dimension);
        button.setFont(new Font("Montserrat", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(70, 60, 61));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        return button;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JLabel getImageLabel() {
        return imageLabel;
    }

    public void setImageLabel(JLabel imageLabel) {
        this.imageLabel = imageLabel;
    }

    public JButton getBotonSi() {
        return botonSi;
    }

    public void setBotonSi(JButton botonSi) {
        this.botonSi = botonSi;
    }

    public JButton getBotonNo() {
        return botonNo;
    }

    public void setBotonNo(JButton botonNo) {
        this.botonNo = botonNo;
    }

    public JTextArea getQuestionLabel() {
        return questionLabel;
    }

    public void setQuestionLabel(JTextArea questionLabel) {
        this.questionLabel = questionLabel;
    }
}