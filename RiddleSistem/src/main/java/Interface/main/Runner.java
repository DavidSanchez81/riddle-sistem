package Interface.main;

import javax.swing.*;
import Interface.panels.PrincipalFrame;

public class Runner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PrincipalFrame::new);
    }
}
