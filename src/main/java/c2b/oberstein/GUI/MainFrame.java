package c2b.oberstein.GUI;


import c2b.oberstein.GUI.Views.*;

import lombok.*;

import javax.swing.*;



@Data
public class MainFrame extends JFrame{
   
   private HomeView homeView = new HomeView();
   private ManageQuizView manageQuizView;
   
   
   public MainFrame() {
      
      manageQuizView = new ManageQuizView();
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(1000,650);
      setResizable(false);
      add(manageQuizView);
      setVisible(true);
   }
}
