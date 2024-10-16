package Interface.panels;

import Interface.listeners.ViewController;

import javax.swing.*;

public class PrincipalFrame extends JFrame {

    private ViewController viewController = new ViewController();
    private MainPanel mainPanel;

    public PrincipalFrame() {
        // Obtener el panel principal desde el controlador
        this.mainPanel = viewController.getMainPanel();
        panelConfig();
    }


    // Configura y muestra el JFrame principal
    public void panelConfig() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Operación al cerrar la ventana
        add(mainPanel); // Añadir el panel principal al frame
        pack(); // Ajustar el tamaño del frame según el contenido del panel
        setLocationRelativeTo(null); // Centrar el frame en la pantalla
        // Hacer visible el frame después de todas las configuraciones
        setVisible(true);
    }
}
