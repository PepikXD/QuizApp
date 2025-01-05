package c2b.oberstein.GUI.Controllers;

import c2b.oberstein.*;
import c2b.oberstein.GUI.QuizPanels.*;
import c2b.oberstein.GUI.Views.*;
import c2b.oberstein.util.*;

import java.util.*;
import java.util.zip.*;

public class QuizViewController {
   private static QuizView quizView = QuizApp.getMainFrame().getQuizView();
   

   public static void previousBtn() {
      
      if (quizView.getSelectedIndex() == 0){
         quizView.getMltpChoicePanel().getBtnPrevious().setVisible(false);
         quizView.getYesOrNoPanel().getBtnPrevious().setVisible(false);
         quizView.getOpenPanel().getBtnPrevious().setVisible(false);
         quizView.setSelectedIndex(quizView.getSelectedIndex()+1);
      }
      
      System.out.println(quizView.getSelectedIndex());
      quizView.setSelectedIndex(quizView.getSelectedIndex()-1);
      Question prevQ = quizView.getQuestions().get(quizView.getSelectedIndex());
      System.out.println(quizView.getSelectedIndex());
      
      if (quizView.getSelectedIndex() < quizView.getQuestions().size()-1){
         quizView.getMltpChoicePanel().getBtnNext().setVisible(true);
         quizView.getYesOrNoPanel().getBtnNext().setVisible(true);
         quizView.getOpenPanel().getBtnNext().setVisible(true);
         
         quizView.getMltpChoicePanel().getBtnEnd().setVisible(false);
         quizView.getYesOrNoPanel().getBtnEnd().setVisible(false);
         quizView.getOpenPanel().getBtnEnd().setVisible(false);
      }
      
      
      changeDisplayedQuestion(prevQ);
      
      quizView.revalidate();
      quizView.repaint();
   }

   public static void nextBtn(){
      checkWhich();
      System.out.println(quizView.getSelectedIndex());
      quizView.setSelectedIndex(quizView.getSelectedIndex()+1);
      Question nextQ = quizView.getQuestions().get(quizView.getSelectedIndex());
      System.out.println(quizView.getSelectedIndex());
      
      if (quizView.getSelectedIndex() > 0){
         quizView.getMltpChoicePanel().getBtnPrevious().setVisible(true);
         quizView.getYesOrNoPanel().getBtnPrevious().setVisible(true);
         quizView.getOpenPanel().getBtnPrevious().setVisible(true);
      }
      
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
      checkWhich();
      quizView.setSelectedIndex(0);
      ChangePanels.changeToEnd(quizView.getQuiz().getName());
      
   }
   
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
