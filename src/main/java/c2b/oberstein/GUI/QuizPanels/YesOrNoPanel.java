package c2b.oberstein.GUI.QuizPanels;

import c2b.oberstein.*;

import javax.swing.*;
import java.awt.*;

public class YesOrNoPanel extends QuizPanel{
   
   private ButtonGroup buttonGroup = new ButtonGroup();
   private final Question question = super.getQuestion();
   private JRadioButton rdbtnYes;
   private JRadioButton rdbtnNo;
   private JLabel lblYes;
   private JLabel lblNo;
   
   public YesOrNoPanel(Question question) {
      super(question);
      
      setLayout(null);
      
      initialize();
   }
   
   private void initialize(){
      
      rdbtnYes = new JRadioButton("");
      buttonGroup.add(rdbtnYes);
      rdbtnYes.setBounds(25, 250, 25, 25);
      add(rdbtnYes);
      
      rdbtnNo = new JRadioButton("");
      buttonGroup.add(rdbtnNo);
      rdbtnNo.setBounds(25, 350, 25, 25);
      add(rdbtnNo);
      
      lblYes = new JLabel("Yes");
      lblYes.setFont(new Font("Unispace", Font.PLAIN, 25));
      lblYes.setBounds(70, 245, 100, 35);
      add(lblYes);
      
      lblNo = new JLabel("No");
      lblNo.setFont(new Font("Unispace", Font.PLAIN, 25));
      lblNo.setBounds(70, 345, 100, 35);
      add(lblNo);
      
   }
}
