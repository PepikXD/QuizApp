package c2b.oberstein.GUI.Controllers;

import c2b.oberstein.*;
import c2b.oberstein.GUI.Views.*;
import c2b.oberstein.util.*;

import javax.swing.*;
import java.util.*;


public class ManageQuizController {
   
   private static ManageQuizView manageQuizView = QuizApp.getMainFrame().getManageQuizView();

   /**
    *
    * deletes selected quiz
    * @param index index of selected quiz
    */
   public static void deleteSelecetedQuiz(int index){
      QuizApp.getQuizzes().remove(index);
      QuizIOUtil.deleteQuiz(manageQuizView.getQuizComboBox().getItemAt(index));
      removeFromComboBox(manageQuizView.getQuizComboBox(), index);
   }

   /**
    *
    * @param index index of question in quiz
    * @param quizIndex index of selecte dquiz
    */
   public static void deleteSelecetedQuestion(int index, int quizIndex){
      QuizApp.getQuizzes().get(quizIndex).getQuestions().remove(index);
      removeFromComboBox(manageQuizView.getQuestionComboBox(), index);
   }


   /**
    *
    * show the correct panel to edit question based of question type
    * and sets the field values to current values in question
    * @param qestionIndex index of question to edit
    * @param quizIndex index of quiz th equestion is from
    */
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
      }
      switchCreationPanel(1);
   }

   /**
    * shows panel to edit quiz
    * @param quizIndex index of edited quiz
    */
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

   /**
    * adds new question to quiz
    * @param question index of the added question
    * @param quizIndex index of quiz to which add the question
    */
   public static void createQuestion(Question question, int quizIndex){
      QuizApp.getQuizzes().get(quizIndex).getQuestions().add(question);
      addToComboBox(manageQuizView.getQuestionComboBox(), question.getQuestion());
      manageQuizView.getQuestionComboBox().setSelectedIndex(manageQuizView.getQuestionComboBox().getItemCount()-1);
   }

   /**
    * adds new quiz
    * @param name quiz name
    */
   public static void createQuiz(String name){
      QuizApp.getQuizzes().add(new Quiz(name,new ArrayList<>()));
      addToComboBox(QuizApp.getMainFrame().getManageQuizView().getQuizComboBox(), name);
      manageQuizView.getQuizComboBox().setSelectedIndex(manageQuizView.getQuizComboBox().getItemCount()-1);
   }

   /**
    * removes item from comboBox
    * @param comboBox form which to remove
    * @param index index of item to remove
    */
   private static void removeFromComboBox(JComboBox comboBox, int index){
      System.out.println(comboBox.getItemCount() + "-" + index);
      try {
         comboBox.removeItemAt(index);
      }catch (Exception e){
         System.out.println("vedle pico");
      }
   }

   /**
    * adds new value to combobox
    * @param comboBox to which add
    * @param value what to add
    */
   private static void addToComboBox(JComboBox comboBox, String value){
      comboBox.addItem(value);
   }

   /**
    * updates the name of quiz
    * @param name new name
    * @param index index of edited quiz
    */
   public static void saveQuiz(String name, int index) {
      QuizApp.getQuizzes().get(index).setName(name);
      
   }

   /**
    * goes back to homeView
    */
   public static void goBack() {
      ChangePanels.changeToHome();
      QuizApp.getMainFrame().setChooseQuizView(new ChooseQuizView());
   }

   /**
    * switches to correct panel based on question type
    * @param index to which to go to:
    *              0 - Multiple choice
    *              1 - Yes or No
    *              2 - Open answer
    */
   public static void switchQuestionTypePanel(int index) {
      manageQuizView.getMultipleChoicePanel().setVisible((index == 0));
      manageQuizView.getYesOrNoPanel().setVisible((index == 1));
      manageQuizView.getOpenQuestionPanel().setVisible((index == 2));
   }

   /**
    * changes panel to create or edit question or quiz
    * @param index to which to go to:
    *              0 - create quiz panek
    *              1 - edit question panel
    */
   public static void switchCreationPanel(int index){
      manageQuizView.getCreateQuizPanel().setVisible(index == 0);
      manageQuizView.getEditQuestionPanel().setVisible(index == 1);
      
   }

   /**
    * saves all quizzes to files
    */
   public static void saveChanges() {
      for (Quiz quiz : QuizApp.getQuizzes()) {
         QuizIOUtil.saveQuiz(quiz);
      }
      QuizApp.getMainFrame().setChooseQuizView(new ChooseQuizView());
   }

   /**
    * sets up qustion values to combo box
    * @param quizIndex index of quiz to get qustion from
    */
   public static void setQuestionComboBoxValues(int quizIndex) {
      manageQuizView.getQuestionComboBox().removeAllItems();
      
      for (Question question : QuizApp.getQuizzes().get(quizIndex).getQuestions()) {
         manageQuizView.getQuestionComboBox().addItem(question.getQuestion());
      }
      
   }
}
