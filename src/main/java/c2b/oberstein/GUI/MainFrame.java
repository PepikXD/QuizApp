package c2b.oberstein.GUI;


import c2b.oberstein.GUI.Views.*;

import lombok.*;

import javax.swing.*;



@Data
public class MainFrame extends JFrame{
   
   private HomeView homeView = new HomeView();
   private ManageQuizView manageQuizView = new ManageQuizView();
   private QuizView quizView = null;
   private EndScreenView endScreenView = null;
   private ChooseQuizView chooseQuizView = new ChooseQuizView();
   
   private JPanel activePanel = homeView;
   
   public MainFrame() {
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(1000,650);
      setResizable(false);
      add(activePanel);
      setVisible(true);
      
   }
}
