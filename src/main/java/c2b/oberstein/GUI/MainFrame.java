package c2b.oberstein.GUI;


import c2b.oberstein.GUI.Views.*;

import lombok.*;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


@Data
public class MainFrame extends JFrame{
   
   private HomeView homeView = new HomeView();
   private ManageQuizView manageQuizView = new ManageQuizView();
   
   
   public MainFrame() {
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setSize(1000,650);
      this.setResizable(false);
      this.add(manageQuizView);
      this.setVisible(true);
   }
}
