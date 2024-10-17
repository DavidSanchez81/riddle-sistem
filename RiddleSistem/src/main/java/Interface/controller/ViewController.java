package Interface.controller;

import Interface.controller.listeners.ListenersGamePanel;
import Interface.panels.MainPanel;
import model.BinaryTree;
import model.ManagementPersistence;

public class ViewController {
   private MainPanel mainPanel;
   private ListenersGamePanel listenersGamePanel;

   public ViewController(){
      this.mainPanel = new MainPanel(); // Inicializa el panel principal
      this.listenersGamePanel = new ListenersGamePanel(this); // Pasa el árbol cargado al listener
   }

   public MainPanel getMainPanel() {
      return mainPanel;
   }

}