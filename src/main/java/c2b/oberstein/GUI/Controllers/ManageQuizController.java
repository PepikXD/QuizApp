package c2b.oberstein.GUI.Controllers;

import c2b.oberstein.*;

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
   
   public static void showPanelToCrateQuestion(){
   
   }
   
   public static void showPanelToCreateQuiz(){
   
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
}
