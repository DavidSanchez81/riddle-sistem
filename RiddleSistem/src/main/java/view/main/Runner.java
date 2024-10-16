package view.main;

import javax.swing.*;
import view.panels.PrincipalFrame;

public class Runner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PrincipalFrame::new);
    }
}
