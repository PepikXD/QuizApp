package c2b.oberstein.GUI.Controllers;

import c2b.oberstein.*;
import c2b.oberstein.GUI.QuizPanels.*;
import c2b.oberstein.GUI.Views.*;
import c2b.oberstein.util.*;

import java.util.*;
import java.util.zip.*;

public class QuizViewController {
   private static QuizView quizView = QuizApp.getMainFrame().getQuizView();


   public static void nextBtn(){
      //chesck answer
      checkWhich();

      // sets the next question
      quizView.setSelectedIndex(quizView.getSelectedIndex()+1);
      Question nextQ = quizView.getQuestions().get(quizView.getSelectedIndex());

      // changes the next button to end quiz button
      if (quizView.getSelectedIndex() == quizView.getQuestions().size()-1){
         quizView.getMltpChoicePanel().getBtnNext().setVisible(false);
         quizView.getYesOrNoPanel().getBtnNext().setVisible(false);
         quizView.getOpenPanel().getBtnNext().setVisible(false);
         
         quizView.getMltpChoicePanel().getBtnEnd().setVisible(true);
         quizView.getYesOrNoPanel().getBtnEnd().setVisible(true);
         quizView.getOpenPanel().getBtnEnd().setVisible(true);
      }
      changeDisplayedQuestion(nextQ);
      
      quizView.revalidate();
      quizView.repaint();
   }

   public static void endBtn() {
      //checks answer
      checkWhich();
      quizView.setSelectedIndex(0);
      ChangePanels.changeToEnd(quizView.getQuiz().getName());
      
   }

   /**
    * changes the dislayed panel basen on questionvtype and updatess all necessery fields
    * @param q question to display next
    */
   private static void changeDisplayedQuestion(Question q){
      
      switch (q.getQuestionType().value){
         case "Multiple Choice":
            MltpChoicePanel panel = quizView.getMltpChoicePanel();
            List<String> randomized = Arrays.asList(q.getMultipleChoiceAnswers());
            Collections.shuffle(randomized);
            
            panel.getTxtAreaQuestion().setText(q.getQuestion());
            
            panel.getLblAnswer1().setText(randomized.get(0));
            panel.getLblAnswer2().setText(randomized.get(1));
            panel.getLblAnswer3().setText(randomized.get(2));
            panel.getLblAnswer4().setText(randomized.get(3));
            
            quizView.getMltpChoicePanel().setVisible(true);
            quizView.getYesOrNoPanel().setVisible(false);
            quizView.getOpenPanel().setVisible(false);
            
            break;
         case "Yes Or No":
            YesOrNoPanel panel1 = quizView.getYesOrNoPanel();
            
            panel1.getTxtAreaQuestion().setText(q.getQuestion());
            
            quizView.getMltpChoicePanel().setVisible(false);
            quizView.getYesOrNoPanel().setVisible(true);
            quizView.getOpenPanel().setVisible(false);
            
            break;
         case "Open":
            OpenPanel panel2 = quizView.getOpenPanel();
            
            panel2.getTxtAreaQuestion().setText(q.getQuestion());
            
            quizView.getMltpChoicePanel().setVisible(false);
            quizView.getYesOrNoPanel().setVisible(false);
            quizView.getOpenPanel().setVisible(true);
            
            break;
      }
      
   }

   /**
    * checks if the answer is correct
    */
   private static void checkWhich(){
      if (quizView.getSelectedIndex() > -1) {
         switch (quizView.getQuestions().get(quizView.getSelectedIndex()).getQuestionType().value) {
            case "Multiple Choice":
               String answer = "";
               switch (quizView.getMltpChoicePanel().getButtonGroup().getSelection().getActionCommand()) {
                  case "1":
                     answer = quizView.getMltpChoicePanel().getLblAnswer1().getText();
                     break;
                  case "2":
                     answer = quizView.getMltpChoicePanel().getLblAnswer2().getText();
                     break;
                  case "3":
                     answer = quizView.getMltpChoicePanel().getLblAnswer3().getText();
                     break;
                  case "4":
                     answer = quizView.getMltpChoicePanel().getLblAnswer4().getText();
                     break;
               }
               
               QuizApp.getCheckResults().checkMltpAnswer(quizView.getQuestions().get(quizView.getSelectedIndex()), answer);
               break;
            case "Yes Or No":
               QuizApp.getCheckResults().checkYoNAnwer(quizView.getQuestions().get(quizView.getSelectedIndex()), quizView.getYesOrNoPanel().getRdbtnYes().isSelected());
               break;
            case "Open":
               QuizApp.getCheckResults().checkOpenAnswer(quizView.getQuestions().get(quizView.getSelectedIndex()), quizView.getOpenPanel().getTxtAreaAnswer().getText());
               break;
         }
      }
   }
}
