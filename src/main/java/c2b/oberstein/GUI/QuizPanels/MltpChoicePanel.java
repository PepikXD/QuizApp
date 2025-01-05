package c2b.oberstein.GUI.QuizPanels;

import c2b.oberstein.*;
import lombok.*;

import javax.swing.*;
import java.awt.*;

@Data

public class MltpChoicePanel extends QuestionPanel {
   
   private ButtonGroup buttonGroup = new ButtonGroup();
   
   private Question question = super.getQuestion();
   private JRadioButton rdbtnAnswer1;
   private JRadioButton rdbtnAnswer4;
   private JRadioButton rdbtnAnswer2;
   private JRadioButton rdbtnAnswewr3;
   private JLabel lblAnswer1;
   private JLabel lblAnswer2;
   private JLabel lblAnswer3;
   private JLabel lblAnswer4;
   
   public MltpChoicePanel(){
      super();
      
      setLayout(null);
      initialize();
   }
   public MltpChoicePanel(Question question) {
      super(question);
      
      setLayout(null);
      
      initialize();
      
   }
   
   private void initialize(){
      

      rdbtnAnswer1 = new JRadioButton();
      rdbtnAnswer1.setActionCommand("1");
      buttonGroup.add(rdbtnAnswer1);
      rdbtnAnswer1.setFont(new Font("Unispace", Font.PLAIN, 25));
      rdbtnAnswer1.setBounds(25, 200, 25, 25);
      add(rdbtnAnswer1);
      
      rdbtnAnswer4 = new JRadioButton();
      rdbtnAnswer4.setActionCommand("4");
      buttonGroup.add(rdbtnAnswer4);
      rdbtnAnswer4.setFont(new Font("Unispace", Font.PLAIN, 25));
      rdbtnAnswer4.setBounds(25, 425, 25, 25);
      add(rdbtnAnswer4);
      
      rdbtnAnswer2 = new JRadioButton();
      rdbtnAnswer2.setActionCommand("2");
      buttonGroup.add(rdbtnAnswer2);
      rdbtnAnswer2.setFont(new Font("Unispace", Font.PLAIN, 25));
      rdbtnAnswer2.setBounds(25, 275, 25, 25);
      add(rdbtnAnswer2);
      
      rdbtnAnswewr3 = new JRadioButton();
      rdbtnAnswewr3.setActionCommand("4");
      buttonGroup.add(rdbtnAnswewr3);
      rdbtnAnswewr3.setFont(new Font("Unispace", Font.PLAIN, 25));
      rdbtnAnswewr3.setBounds(25, 350, 25, 25);
      add(rdbtnAnswewr3);
      
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
