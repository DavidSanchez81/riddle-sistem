package Interface.panels;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private GamePanel gamePanel;
    private AddPanel addPanel;
    /**
     * @author monxvoll
     **/

    //Constructor de la clase
    public MainPanel() {
        gamePanel = new GamePanel(); // Se inicializan las visibilidades de los paneles, junto a sus tamaños ampliados
        gamePanel.setVisible(true);
        addPanel = new AddPanel();
        addPanel.setVisible(false);
        add(gamePanel);
        gamePanel.setPreferredSize(new Dimension(700, 700)); // Aumentado de 700x700 a 900x900
        add(addPanel);
        addPanel.setPreferredSize(new Dimension(700, 700));

    }

    // Getters

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public AddPanel getAddPanel() {
        return addPanel;
    }

}
