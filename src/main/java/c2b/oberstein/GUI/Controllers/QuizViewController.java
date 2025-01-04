package c2b.oberstein.GUI.Controllers;

import c2b.oberstein.*;
import c2b.oberstein.GUI.Views.*;
import c2b.oberstein.util.*;

public class QuizViewController {
   private static final QuizView quizView = QuizApp.getMainFrame().getQuizView();
   
   
   public static void previousBtn() {
      quizView.getTabbedPane().setSelectedIndex(quizView.getTabbedPane().getSelectedIndex()-1);
   }
   
   public static void nextBtn(){
      quizView.getTabbedPane().setSelectedIndex(quizView.getTabbedPane().getSelectedIndex()+1);
   }
   
   public static void endBtn() {
      quizView.getTabbedPane().setSelectedIndex(0);
      ChangePanels.changeToEnd(quizView.getQuiz().getName());
   }
}
