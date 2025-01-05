package c2b.oberstein.GUI;


import c2b.oberstein.GUI.Views.*;
import lombok.*;

import javax.swing.*;


@Data
public class MainFrame extends JFrame {
   
   private HomeView homeView;
   private ManageQuizView manageQuizView;
   private QuizView quizView;
   private EndScreenView endScreenView;
   private ChooseQuizView chooseQuizView;
   
   private JPanel activePanel;
   
   public MainFrame() {
      
      homeView = new HomeView();
      manageQuizView = new ManageQuizView();
      chooseQuizView = new ChooseQuizView();
      
      activePanel = homeView;
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(1015, 650);
      setResizable(false);
      add(activePanel);
      setVisible(true);
      
   }
}
