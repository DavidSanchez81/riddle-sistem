package Interface.controller;


import Interface.controller.listeners.Test;
import Interface.panels.MainPanel;

public class ViewController {
   private MainPanel mainPanel;
   private Test test;


   public ViewController(){
      this.mainPanel = new MainPanel();
      this.test = new Test(this);
   }

   //Getter
   public MainPanel getMainPanel() {
      return mainPanel;
   }
}