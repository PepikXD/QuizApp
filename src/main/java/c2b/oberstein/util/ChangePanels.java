package c2b.oberstein.util;

import c2b.oberstein.*;
import c2b.oberstein.GUI.*;
import c2b.oberstein.GUI.Controllers.*;
import c2b.oberstein.GUI.Views.*;

public class ChangePanels {
   
   private static MainFrame mainFrame = QuizApp.getMainFrame();
   
   // all methods below does practicly the same
   // the change the active panel in main frame and refreshes the window to disply correct
   public static void changeToHome(){
      
      mainFrame.remove(mainFrame.getActivePanel());
      mainFrame.setActivePanel(mainFrame.getHomeView());
      mainFrame.add(mainFrame.getActivePanel());
      mainFrame.revalidate();
      mainFrame.repaint();
   }
   
   public static void changeToManage(){
      
      mainFrame.remove(mainFrame.getActivePanel());
      mainFrame.setActivePanel(mainFrame.getManageQuizView());
      mainFrame.add(mainFrame.getActivePanel());
      mainFrame.revalidate();
      mainFrame.repaint();
   }
   
   public static void changeToQuiz(String quizName){
      
      mainFrame.remove(mainFrame.getActivePanel());
      mainFrame.setQuizView(new QuizView(quizName)); // creates the correct quiz in quiz view
      QuizApp.setCheckResults(new CheckResults(mainFrame.getQuizView().getQuiz())); // creates coresponding result checker for quiz
      QuizViewController.nextBtn();
      mainFrame.setActivePanel(mainFrame.getQuizView());
      mainFrame.add(mainFrame.getActivePanel());
      mainFrame.revalidate();
      mainFrame.repaint();
   }
   
   public static void changeToEnd(String quizName){
      
      mainFrame.remove(mainFrame.getActivePanel());
      mainFrame.setEndScreenView(new EndScreenView(quizName)); // creates correct end screen to display from correct quiz
      mainFrame.setActivePanel(mainFrame.getEndScreenView());
      mainFrame.add(mainFrame.getActivePanel());
      mainFrame.revalidate();
      mainFrame.repaint();
      
   }
   
   public static void changeToChooseQuiz(){
      
      mainFrame.remove(mainFrame.getActivePanel());
      mainFrame.setActivePanel(mainFrame.getChooseQuizView());
      mainFrame.getChooseQuizView().getQuizList().setSelectedIndex(0);
      mainFrame.add(mainFrame.getActivePanel());
      mainFrame.revalidate();
      mainFrame.repaint();
      
   }
   
}
