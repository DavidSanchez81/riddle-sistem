package Interface.panels;



import javax.swing.*;

import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;

public class AddPanel extends JPanel {

    private JTextField animalField;
    private JTextField questionField;
    private JButton acceptButton;
    private JLabel titleLabel;
    private JLabel animalLabel;
    private JLabel questionLabel;

    public AddPanel() {
        // Inicialización de componentes
        initializeComponents();

        // Diseño del panel usando GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Dimensiones para etiquetas y campos de texto
        Dimension labelDimension = new Dimension(150, 40); // Aumentado
        Dimension fieldDimension = new Dimension(200, 40); // Aumentado

        // Configuración del título
        titleLabel.setPreferredSize(new Dimension(260, 50)); // Aumentado
        titleLabel.setForeground(new Color(64, 193, 208));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(70, 60, 61));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        titleLabel.setFont(new Font("Lato", Font.BOLD, 28)); // Aumentado
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 20, 0);
        add(titleLabel, gbc);

        // Configuración de Origen
        animalLabel.setPreferredSize(labelDimension);
        animalLabel.setBackground(new Color(240, 200, 214));
        animalLabel.setOpaque(true);
        animalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        animalLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 5);
        add(animalLabel, gbc);

        animalField.setPreferredSize(fieldDimension);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 10);
        add(animalField, gbc);

        // Configuración de Destino
        questionLabel.setPreferredSize(labelDimension);
        questionLabel.setBackground(new Color(113, 15, 61));
        questionLabel.setOpaque(true);
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 5);
        add(questionLabel, gbc);

        questionField.setPreferredSize(fieldDimension);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 10);
        add(questionField, gbc);

        // Configuración de Botones
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 20, 0);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(acceptButton);
        add(buttonPanel, gbc);

        // Configuración de colores generales del panel
        setBackground(new Color(50, 43, 45));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void initializeComponents() {

        // Inicialización del título
        titleLabel = new JLabel("Riddle System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Lato", Font.BOLD, 28));

        // Configuración de las etiquetas
        animalLabel = createMinimalLabel(" ¿Qué animal estás pensando?");
        questionLabel = createMinimalLabel(" ¿Pregunta para este animal?");

        // Configuración de los campos de texto
        animalField = createMinimalTextField(20);
        animalField.setName("animal");
        animalField.setBackground(new Color(152, 139, 148));
        questionField = createMinimalTextField(20);
        questionField.setName("question");
        questionField.setBackground(new Color(152, 139, 148));



        // Configuración de los botones
        Dimension buttonDimension = new Dimension(200, 40); // Aumentado
        acceptButton = createStyledButton("Aceptar", buttonDimension);
    }

    private JLabel createMinimalLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Montserrat", Font.BOLD, 16)); // Aumentado
        label.setForeground(Color.BLACK);
        label.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(70, 60, 61)),
                BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        label.setOpaque(true);
        label.setBackground(new Color(225, 193, 158));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        return label;
    }

    private JTextField createMinimalTextField(int columns) {
        JTextField textField = new JTextField(columns);
        textField.setFont(new Font("Montserrat", Font.PLAIN, 16)); // Aumentado
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        return textField;
    }

    private JButton createStyledButton(String text, Dimension dimension) {
        JButton button = new JButton(text);
        button.setPreferredSize(dimension);
        button.setFont(new Font("Montserrat", Font.BOLD, 16)); // Aumentado
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(70, 60, 61));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        return button;
    }

    private static class ArrowIcon implements Icon {
        private static final int WIDTH = 11; // Aumentado
        private static final int HEIGHT = 7; // Aumentado

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g.create();

            g2.setColor(Color.BLACK);

            int midPointX = WIDTH / 2;
            int[] xPoints = {x, x + WIDTH, x + midPointX};
            int[] yPoints = {y, y, y + HEIGHT};

            g2.fillPolygon(xPoints, yPoints, 3);
            g2.dispose();
        }

        @Override
        public int getIconWidth() {
            return WIDTH;
        }

        @Override
        public int getIconHeight() {
            return HEIGHT;
        }
    }

    private void configureComboBox(JComboBox<String> comboBox) {
        comboBox.setPreferredSize(new Dimension(200, 40)); // Aumentado
        comboBox.setFont(new Font("Montserrat", Font.PLAIN, 16)); // Aumentado
        comboBox.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(3, 3, 3, 3)));

        comboBox.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton arrowButton = super.createArrowButton();
                arrowButton.setBackground(new Color(152, 139, 148));
                arrowButton.setBorder(BorderFactory.createEmptyBorder());
                arrowButton.setContentAreaFilled(false);
                arrowButton.setIcon(new ArrowIcon());
                return arrowButton;
            }

            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup popup = (BasicComboPopup) super.createPopup();
                return popup;
            }
        });
    }

    public JTextField getAnimalField() {
        return animalField;
    }

    public void setAnimalField(JTextField animalField) {
        this.animalField = animalField;
    }

    public JTextField getQuestionField() {
        return questionField;
    }

    public void setQuestionField(JTextField questionField) {
        this.questionField = questionField;
    }

    public JButton getAcceptButton() {
        return acceptButton;
    }

    public void setAcceptButton(JButton acceptButton) {
        this.acceptButton = acceptButton;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JLabel getAnimalLabel() {
        return animalLabel;
    }

    public void setAnimalLabel(JLabel animalLabel) {
        this.animalLabel = animalLabel;
    }

    public JLabel getQuestionLabel() {
        return questionLabel;
    }

    public void setQuestionLabel(JLabel questionLabel) {
        this.questionLabel = questionLabel;
    }
}