package c2b.oberstein.GUI.Controllers;

import c2b.oberstein.*;
import c2b.oberstein.GUI.Views.*;
import c2b.oberstein.util.*;

import javax.swing.*;
import java.util.*;


public class ManageQuizController {
   
   private static ManageQuizView manageQuizView = QuizApp.getMainFrame().getManageQuizView();
   
   public static void deleteSelecetedQuiz(int index){
      QuizApp.getQuizzes().remove(index);
      removeFromComboBox(manageQuizView.getQuizComboBox(), index);
      System.out.println("deleteQuiz");
   }
   
   
   public static void deleteSelecetedQuestion(int index, int quizIndex){
      QuizApp.getQuizzes().get(quizIndex).getQuestions().remove(index);
      removeFromComboBox(manageQuizView.getQuestionComboBox(), index);
   }
   
   public static void showPanelToEditQuestion(int qestionIndex, int quizIndex){
      if (qestionIndex >= 0 && quizIndex >= 0){
         Question q = QuizApp.getQuizzes().get(quizIndex).getQuestions().get(qestionIndex);
         
         manageQuizView.getQuestionTextField().setText(q.getQuestion());
         manageQuizView.getQuestTypeComboBox().setSelectedItem(q.getQuestionType().name());
         
         switch (q.getQuestionType().value){
            case "Multiple Choice" -> {
               manageQuizView.getCorrectAnsMltpChoiceTextField().setText(q.getMultipleChoiceAnswers()[0]);
               manageQuizView.getWrongAnsMltpChoiceTextField_1().setText(q.getMultipleChoiceAnswers()[1]);
               manageQuizView.getWrongAnsMltpChoiceTextField_2().setText(q.getMultipleChoiceAnswers()[2]);
               manageQuizView.getWrongAnsMltpChoiceTextField_3().setText(q.getMultipleChoiceAnswers()[3]);
            }
            case "Yes Or No" -> manageQuizView.getRdbtnYes().setSelected(q.isYesOrNoAnswer());
            case "Open" -> manageQuizView.getCorrectAnsOpenQuestTextField().setText(q.getOpenAnswer());
         }
         System.out.println(q.getQuestionType().value);
         manageQuizView.getQuestTypeComboBox().setSelectedItem(q.getQuestionType().value);
         
         manageQuizView.getBtnCreateQuestion().setVisible(false);
         manageQuizView.getBtnSaveQuestion().setVisible(true);
      }else {
         manageQuizView.getQuestionTextField().setText("");
         manageQuizView.getQuestTypeComboBox().setSelectedIndex(0);
         
         manageQuizView.getCorrectAnsMltpChoiceTextField().setText("");
         manageQuizView.getWrongAnsMltpChoiceTextField_1().setText("");
         manageQuizView.getWrongAnsMltpChoiceTextField_2().setText("");
         manageQuizView.getWrongAnsMltpChoiceTextField_3().setText("");
         
         manageQuizView.getRdbtnYes().setSelected(true);
         
         manageQuizView.getCorrectAnsOpenQuestTextField().setText("");
         
         manageQuizView.getBtnCreateQuestion().setVisible(true);
         manageQuizView.getBtnSaveQuestion().setVisible(false);
      } switchCreationPanel(1);
   }
   
   public static void showPanelToCreateQuiz(int quizIndex){
      if (quizIndex >= 0){
         manageQuizView.getCreateQuizNameTextField().setText(QuizApp.getQuizzesNames()[quizIndex]);
         
         manageQuizView.getBtnCreateQuiz().setVisible(false);
         manageQuizView.getBtnSaveQuiz().setVisible(true);
         
      }else {
         manageQuizView.getCreateQuizNameTextField().setText("");
         
         manageQuizView.getBtnCreateQuiz().setVisible(true);
         manageQuizView.getBtnSaveQuiz().setVisible(false);
      }
      
      switchCreationPanel(0);
   }
   
   public static void createQuestion(Question question, int quizIndex){
      QuizApp.getQuizzes().get(quizIndex).getQuestions().add(question);
      addToComboBox(manageQuizView.getQuestionComboBox(), question.getQuestion());
      manageQuizView.getQuestionComboBox().setSelectedIndex(manageQuizView.getQuestionComboBox().getItemCount()-1);
   }
   
   public static void createQuiz(String name){
      QuizApp.getQuizzes().add(new Quiz(name,new ArrayList<>()));
      addToComboBox(QuizApp.getMainFrame().getManageQuizView().getQuizComboBox(), name);
      manageQuizView.getQuizComboBox().setSelectedIndex(manageQuizView.getQuizComboBox().getItemCount()-1);
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
      ChangePanels.changeToHome();
   }
   
   public static void switchQuestionTypePanel(int index) {
      manageQuizView.getMultipleChoicePanel().setVisible((index == 0));
      manageQuizView.getYesOrNoPanel().setVisible((index == 1));
      manageQuizView.getOpenQuestionPanel().setVisible((index == 2));
   }
   
   public static void switchCreationPanel(int index){
//      if (index == -1){
//         QuizApp.getMainFrame().getManageQuizView().getCreateQuizPanel().setVisible(false);
//         QuizApp.getMainFrame().getManageQuizView().getEditQuestionPanel().setVisible(false);
//         return;
//      }
//
      manageQuizView.getCreateQuizPanel().setVisible(index == 0);
      manageQuizView.getEditQuestionPanel().setVisible(index == 1);
      
   }
   
   public static void saveChanges() {
      for (Quiz quiz : QuizApp.getQuizzes()) {
         QuizIOUtil.saveQuiz(quiz);
      }
   }
   
   public static void setQuestionComboBoxValues(int quizIndex) {
      manageQuizView.getQuestionComboBox().removeAllItems();
      
      for (Question question : QuizApp.getQuizzes().get(quizIndex).getQuestions()) {
         manageQuizView.getQuestionComboBox().addItem(question.getQuestion());
      }
      
   }
}
