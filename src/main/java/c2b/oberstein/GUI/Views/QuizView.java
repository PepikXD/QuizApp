package c2b.oberstein.GUI.Views;

import c2b.oberstein.*;
import c2b.oberstein.GUI.QuizPanels.*;
import c2b.oberstein.util.*;
import lombok.*;

import javax.swing.*;
import java.awt.*;


@Data
public class QuizView extends JPanel {
   
   private Quiz quiz;
   
   private JTabbedPane tabbedPane;
   
   public QuizView(String quizName) {
      
      this.quiz = QuizIOUtil.readQuiz(quizName);
      
      setLayout(null);
      
      initialize();
      
   }
   
   private void initialize(){
      
      tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      tabbedPane.setBounds(10, 10, 980, 580);
      add(tabbedPane);
      
      createQuestionPanels();
      
   }
   
   private void createQuestionPanels(){
      int counter = 1; //question number
      for (Question q : quiz.getQuestions()){
         switch (q.getQuestionType().value){
            case "Multiple Choice":
               MltpChoicePanel mltpChoicePanel = new MltpChoicePanel(q);
               if (counter == 1) mltpChoicePanel.getBtnPrevious().setVisible(false);
               if (counter == quiz.getQuestions().size()) mltpChoicePanel.getBtnNext().setVisible(false);
               tabbedPane.addTab(String.valueOf(counter), mltpChoicePanel);
               break;
            case "Yes Or No":
               YesOrNoPanel yesOrNoPanel = new YesOrNoPanel(q);
               if (counter == 1) yesOrNoPanel.getBtnPrevious().setVisible(false);
               if (counter == quiz.getQuestions().size()) yesOrNoPanel.getBtnNext().setVisible(false);
               tabbedPane.addTab(String.valueOf(counter), yesOrNoPanel);
               break;
            case "Open":
               OpenPanel openPanel = new OpenPanel(q);
               if (counter == 1) openPanel.getBtnPrevious().setVisible(false);
               if (counter == quiz.getQuestions().size()) openPanel.getBtnNext().setVisible(false);
               tabbedPane.addTab(String.valueOf(counter), new OpenPanel(q));
               break;
         }
         counter++;
      }
   }
}

