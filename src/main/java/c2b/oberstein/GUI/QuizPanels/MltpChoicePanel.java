package c2b.oberstein.GUI.QuizPanels;

import c2b.oberstein.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class MltpChoicePanel extends QuestionPanel {
   
   private ButtonGroup buttonGroup = new ButtonGroup();
   
   private Question question = super.getQuestion();
   private JRadioButton rdbtnAnswer1;
   private JRadioButton rdbtnAnswer2;
   private JRadioButton rdbtnAnswer3;
   private JRadioButton rdbtnAnswewr4;
   private JLabel lblAnswer1;
   private JLabel lblAnswer2;
   private JLabel lblAnswer3;
   private JLabel lblAnswer4;
   
   
   public MltpChoicePanel(Question question) {
      super(question);
      
      setLayout(null);
      
      initialize();
      
   }
   
   private void initialize(){
      
      List<String> shuffeledAnsw = Arrays.asList(question.getMultipleChoiceAnswers());
      Collections.shuffle(shuffeledAnsw);
      
      rdbtnAnswer1 = new JRadioButton(shuffeledAnsw.get(0));
      buttonGroup.add(rdbtnAnswer1);
      rdbtnAnswer1.setFont(new Font("Unispace", Font.PLAIN, 25));
      rdbtnAnswer1.setBounds(25, 200, 25, 25);
      add(rdbtnAnswer1);
      
      rdbtnAnswer2 = new JRadioButton(shuffeledAnsw.get(1));
      buttonGroup.add(rdbtnAnswer2);
      rdbtnAnswer2.setFont(new Font("Unispace", Font.PLAIN, 25));
      rdbtnAnswer2.setBounds(25, 425, 25, 25);
      add(rdbtnAnswer2);
      
      rdbtnAnswer3 = new JRadioButton(shuffeledAnsw.get(2));
      buttonGroup.add(rdbtnAnswer3);
      rdbtnAnswer3.setFont(new Font("Unispace", Font.PLAIN, 25));
      rdbtnAnswer3.setBounds(25, 275, 25, 25);
      add(rdbtnAnswer3);
      
      rdbtnAnswewr4 = new JRadioButton(shuffeledAnsw.get(3));
      buttonGroup.add(rdbtnAnswewr4);
      rdbtnAnswewr4.setFont(new Font("Unispace", Font.PLAIN, 25));
      rdbtnAnswewr4.setBounds(25, 350, 25, 25);
      add(rdbtnAnswewr4);
      
      lblAnswer1 = new JLabel("New label");
      lblAnswer1.setFont(new Font("Unispace", Font.PLAIN, 25));
      lblAnswer1.setBounds(75, 195, 885, 35);
      add(lblAnswer1);
      
      lblAnswer2 = new JLabel("New label");
      lblAnswer2.setFont(new Font("Unispace", Font.PLAIN, 25));
      lblAnswer2.setBounds(75, 270, 885, 35);
      add(lblAnswer2);
      
      lblAnswer3 = new JLabel("New label");
      lblAnswer3.setFont(new Font("Unispace", Font.PLAIN, 25));
      lblAnswer3.setBounds(75, 345, 885, 35);
      add(lblAnswer3);
      
      lblAnswer4 = new JLabel("New label");
      lblAnswer4.setFont(new Font("Unispace", Font.PLAIN, 25));
      lblAnswer4.setBounds(75, 420, 885, 35);
      add(lblAnswer4);
      
      
   }
}
