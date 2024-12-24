package c2b.oberstein.GUI.Controllers;

import c2b.oberstein.*;
import c2b.oberstein.GUI.*;

import javax.swing.*;
import java.util.*;

public class ManageQuizController {
   
   
   public static void deleteSelecetedQuiz(int index){
      QuizApp.getQuizzes().remove(index);
      removeFromComboBox(QuizApp.getMainFrame().getManageQuizView().getQuizComboBox(), index);
      System.out.println("deleteQuiz");
   }
   
   
   public static void deleteSelecetedQuestion(int index, int quizIndex){
      QuizApp.getQuizzes().get(quizIndex).getQuestions().remove(index);
      removeFromComboBox(QuizApp.getMainFrame().getManageQuizView().getQuestionComboBox(), index);
   }
   
   public static void showPanelToEditQuestion(){
      switchCreationPanel(1);
   }
   
   public static void showPanelToCreateQuiz(){
      switchCreationPanel(0);
   }
   
   public static void saveQuestion(Question question, int quizIndex){
      QuizApp.getQuizzes().get(quizIndex).getQuestions().add(question);
      addToComboBox(QuizApp.getMainFrame().getManageQuizView().getQuestionComboBox(), question.getQuestion());
   }
   
   public static void createQuiz(String name){
      QuizApp.getQuizzes().add(new Quiz(name,new ArrayList<>()));
      addToComboBox(QuizApp.getMainFrame().getManageQuizView().getQuizComboBox(), name);
   }
   
   private static void removeFromComboBox(JComboBox comboBox, int index){
      System.out.println(comboBox.getItemCount() + "-" + index);
      try {
         comboBox.removeItemAt(index);
      }catch (Exception e){
         System.out.println("vedle pico");
      }
      
      
   }
   
   private static void addToComboBox(JComboBox comboBox, String value){
      comboBox.addItem(value);
   }
   
   public static void saveQuiz(String name, int index) {
      QuizApp.getQuizzes().get(index).setName(name);
   }
   
   public static void goBack() {
   }
   
   public static void switchQuestionTypePanel(int index) {
      QuizApp.getMainFrame().getManageQuizView().getMultipleChoicePanel().setVisible((index == 0));
      QuizApp.getMainFrame().getManageQuizView().getYesOrNoPanel().setVisible((index == 1));
      QuizApp.getMainFrame().getManageQuizView().getOpenQuestionPanel().setVisible((index == 2));
   }
   
   public static void switchCreationPanel(int index){
//      if (index == -1){
//         QuizApp.getMainFrame().getManageQuizView().getCreateQuizPanel().setVisible(false);
//         QuizApp.getMainFrame().getManageQuizView().getEditQuestionPanel().setVisible(false);
//         return;
//      }
//
      QuizApp.getMainFrame().getManageQuizView().getCreateQuizPanel().setVisible(index == 0);
      QuizApp.getMainFrame().getManageQuizView().getEditQuestionPanel().setVisible(index == 1);
      
   }
}
