package view.listeners;


import view.panels.MainPanel;

public class ViewController {
   private MainPanel mainPanel;

   /**
    * @author monxvoll
    **/

   public ViewController(){
      this.mainPanel = new MainPanel();
   }

   //Getter
   public MainPanel getMainPanel() {
      return mainPanel;
   }
}