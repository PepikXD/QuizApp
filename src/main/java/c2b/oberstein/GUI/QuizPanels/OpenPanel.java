package c2b.oberstein.GUI.QuizPanels;

import c2b.oberstein.*;

import javax.swing.*;
import java.awt.*;

public class OpenPanel extends QuizPanel{
   
   private final Question question = super.getQuestion();
   private JTextArea txtAreaAnswer;
   private JLabel lblAnswer;
   
   
   public OpenPanel(Question question) {
      super(question);
      
      setLayout(null);
      
      initialize();
      
   }
   
   private void initialize(){
      
      txtAreaAnswer = new JTextArea();
      txtAreaAnswer.setText("");
      txtAreaAnswer.setLineWrap(true);
      txtAreaAnswer.setFont(new Font("Unispace", Font.PLAIN, 25));
      txtAreaAnswer.setBounds(10, 250, 950, 200);
      add(txtAreaAnswer);
      
      lblAnswer = new JLabel("Answer:");
      lblAnswer.setFont(new Font("Unispace", Font.BOLD, 29));
      lblAnswer.setBounds(10, 200, 200, 50);
      add(lblAnswer);
   }
}