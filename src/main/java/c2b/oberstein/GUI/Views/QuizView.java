package c2b.oberstein.GUI.Views;

import c2b.oberstein.*;
import c2b.oberstein.GUI.QuizPanels.*;
import c2b.oberstein.util.*;
import lombok.*;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.util.*;


@Data
public class QuizView extends JPanel {
   
   private Quiz quiz;
   
//   private JTabbedPane tabbedPane;
   
   private ArrayList<QuestionPanel> questionPanelList = new ArrayList<>();
   
   private int selectedIndex = 0;
   
   private QuestionPanel activePanel;
   
   public QuizView(String quizName) {
      
      this.quiz = QuizIOUtil.readQuiz(quizName);
      setLayout(null);
      
      initialize();
      
   }
   
   private void initialize(){
      
//      setTabbedPane(new JTabbedPane(JTabbedPane.TOP));
//      tabbedPane.setBounds(10, 10, 980, 580);
//      tabbedPane.setName(quiz.getName());
      
      createQuestionPanels();
      activePanel = questionPanelList.getFirst();
      add(activePanel);
//      add(tabbedPane);
      
   }
   
   private void createQuestionPanels(){
//
//      int counter = 1; //question number
//      for (Question q : quiz.getQuestions()){
//         switch (q.getQuestionType().value){
//            case "Multiple Choice":
//               MltpChoicePanel mltpChoicePanel = new MltpChoicePanel(q);
//               if (counter == 1) mltpChoicePanel.getBtnPrevious().setVisible(false);
//               if (counter == quiz.getQuestions().size()) mltpChoicePanel.getBtnNext().setVisible(false);
//               tabbedPane.addTab(String.valueOf(counter), mltpChoicePanel);
//               break;
//            case "Yes Or No":
//               YesOrNoPanel yesOrNoPanel = new YesOrNoPanel(q);
//               if (counter == 1) yesOrNoPanel.getBtnPrevious().setVisible(false);
//               if (counter == quiz.getQuestions().size()) yesOrNoPanel.getBtnNext().setVisible(false);
//               tabbedPane.addTab(String.valueOf(counter), yesOrNoPanel);
//               break;
//            case "Open":
//               OpenPanel openPanel = new OpenPanel(q);
//               if (counter == 1) openPanel.getBtnPrevious().setVisible(false);
//               if (counter == quiz.getQuestions().size()) openPanel.getBtnNext().setVisible(false);
//               tabbedPane.addTab(String.valueOf(counter), new OpenPanel(q));
//               break;
//         }
//         counter++;
//      }
//

      
      for (Question q : quiz.getQuestions()){
         switch (q.getQuestionType().value){
            case "Multiple Choice":
               questionPanelList.add(new MltpChoicePanel(q));
               break;
            case "Yes Or No":
               questionPanelList.add(new YesOrNoPanel(q));
               break;
            case "Open":
               questionPanelList.add(new OpenPanel(q));
               break;
         }
      }
      questionPanelList.getFirst().getBtnPrevious().setVisible(false);
      questionPanelList.getLast().getBtnNext().setVisible(false);
      questionPanelList.getLast().getBtnEnd().setVisible(true);
   }
}

