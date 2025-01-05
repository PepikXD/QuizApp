package c2b.oberstein.GUI.Controllers;

import c2b.oberstein.*;
import c2b.oberstein.GUI.Views.*;
import c2b.oberstein.util.*;

public class QuizViewController {
   private static QuizView quizView = QuizApp.getMainFrame().getQuizView();
   

   public static void previousBtn() {
      quizView.remove(quizView.getActivePanel());
      quizView.setSelectedIndex(quizView.getSelectedIndex()-1);
      quizView.setActivePanel(quizView.getQuestionPanelList().get(quizView.getSelectedIndex()));
      quizView.add(quizView.getActivePanel());
      quizView.revalidate();
      quizView.repaint();
   }

   public static void nextBtn(){
      System.out.println(quizView.getQuestionPanelList());
      System.out.println(quizView.getSelectedIndex());
      quizView.remove(quizView.getActivePanel());
      quizView.setSelectedIndex(quizView.getSelectedIndex()+1);
      quizView.setActivePanel(quizView.getQuestionPanelList().get(quizView.getSelectedIndex()));
      quizView.add(quizView.getActivePanel());
      quizView.revalidate();
      quizView.repaint();
   }

   public static void endBtn() {
      quizView.setSelectedIndex(0);
      ChangePanels.changeToEnd(quizView.getQuiz().getName());
      QuizApp.getMainFrame().setQuizView(null);
   }
}
