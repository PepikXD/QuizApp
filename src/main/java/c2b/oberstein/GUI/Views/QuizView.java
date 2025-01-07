package c2b.oberstein.GUI.Views;

import c2b.oberstein.*;
import c2b.oberstein.GUI.QuizPanels.*;
import c2b.oberstein.util.*;
import lombok.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;


@Data
public class QuizView extends JPanel {
   
   private Quiz quiz;
   
   public QuizView(String quizName) {
      
      this.quiz = QuizIOUtil.readQuiz(quizName);
      questions = quiz.getQuestions();
      setLayout(null);
      
      initialize();
      
      add(mltpChoicePanel);
      add(yesOrNoPanel);
      add(openPanel);
   }
   
   private void initialize(){
      
      mltpChoicePanel = new MltpChoicePanel();
      openPanel = new OpenPanel();
      yesOrNoPanel = new YesOrNoPanel();
   }
   
   private List<Question> questions;
   private int selectedIndex = -1;
   
   private MltpChoicePanel mltpChoicePanel;
   private OpenPanel openPanel;
   private YesOrNoPanel yesOrNoPanel;
   
   
   
}

