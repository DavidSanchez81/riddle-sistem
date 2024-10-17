package Interface.controller.listeners;

import Interface.controller.ViewController;

import java.util.HashSet;
import java.util.Set;

public class Test {
    //Respectivas Instancias
    private final ViewController viewController;



    //Constructor de la clase
    public Test(ViewController viewController) {
        this.viewController = viewController;
        buttonTestYes();
        buttonTestNo();
    }

    public void buttonTestYes(){
        viewController.getMainPanel().getGamePanel().getBotonSi().addActionListener(e -> {
         viewController.getMainPanel().getGamePanel().getQuestionLabel().setText("Respuesta en caso de si");
        });
    }

    public void buttonTestNo(){
        viewController.getMainPanel().getGamePanel().getBotonNo().addActionListener(e -> {
            viewController.getMainPanel().getGamePanel().getQuestionLabel().setText("Respuesta en caso de no");
        });
    }
}
