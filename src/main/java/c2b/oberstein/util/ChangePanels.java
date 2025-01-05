package c2b.oberstein.util;

import c2b.oberstein.*;
import c2b.oberstein.GUI.*;
import c2b.oberstein.GUI.Views.*;

public class ChangePanels {
   
   private static MainFrame mainFrame = QuizApp.getMainFrame();
   
   
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
      mainFrame.setQuizView(new QuizView(quizName));
      mainFrame.setActivePanel(mainFrame.getQuizView());
      mainFrame.add(mainFrame.getActivePanel());
      mainFrame.revalidate();
      mainFrame.repaint();
   }
   
   public static void changeToEnd(String quizName){
      
      mainFrame.remove(mainFrame.getActivePanel());
      mainFrame.setEndScreenView(new EndScreenView(quizName));
      mainFrame.setActivePanel(mainFrame.getEndScreenView());
      mainFrame.add(mainFrame.getActivePanel());
      mainFrame.revalidate();
      mainFrame.repaint();
      
   }
   
   public static void changeToChooseQuiz(){
      
      mainFrame.remove(mainFrame.getActivePanel());
      mainFrame.setActivePanel(mainFrame.getChooseQuizView());
      mainFrame.add(mainFrame.getActivePanel());
      mainFrame.revalidate();
      mainFrame.repaint();
      
   }
   
}
