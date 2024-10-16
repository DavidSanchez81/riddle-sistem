package view.listeners;


import view.panels.MainPanel;

public class ViewController {
   private MainPanel mainPanel;


   public ViewController(){
      this.mainPanel = new MainPanel();
   }

   //Getter
   public MainPanel getMainPanel() {
      return mainPanel;
   }
}