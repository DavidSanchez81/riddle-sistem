package view.panels;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private GamePanel gamePanel;

    /**
     * @author monxvoll
     **/

    //Constructor de la clase
    public MainPanel() {
        gamePanel = new GamePanel(); // Se inicializan las visibilidades de los paneles, junto a sus tamaños ampliados
        gamePanel.setVisible(true);
        add(gamePanel);
        gamePanel.setPreferredSize(new Dimension(700, 700)); // Aumentado de 700x700 a 900x900

    }

    // Getters

    public GamePanel getGamePanel() {
        return gamePanel;
    }
}
