package c2b.oberstein.GUI.QuizPanels;

import c2b.oberstein.*;
import c2b.oberstein.GUI.Controllers.*;
import lombok.*;

import javax.swing.*;
import java.awt.*;


@Data
public class QuestionPanel extends JPanel {
   
   private Question question;
   private JTextArea txtAreaQuestion;
   private JButton btnNext;
   private JButton btnEnd;
   
   public QuestionPanel(){
      setBounds(10,10,980,580);
      
      initialize();
   }

   
   private void initialize(){
      
      txtAreaQuestion = new JTextArea();
      txtAreaQuestion.setRows(4);
      txtAreaQuestion.setText("");
      txtAreaQuestion.setEditable(false);
      txtAreaQuestion.setLineWrap(true);
      txtAreaQuestion.setFont(new Font("Unispace", Font.PLAIN, 30));
      txtAreaQuestion.setBounds(10, 10, 950, 150);
      add(txtAreaQuestion);
      
      btnNext = new JButton("Next");
      btnNext.setFont(new Font("Unispace", Font.PLAIN, 20));
      btnNext.setBounds(800, 500, 150, 40);
      btnNext.addActionListener(ae -> QuizViewController.nextBtn());
      add(btnNext);
      
      btnEnd = new JButton("End Quiz");
      btnEnd.setFont(new Font("Unispace", Font.PLAIN, 20));
      btnEnd.setBounds(800, 500, 150, 40);
      btnEnd.addActionListener(ae -> QuizViewController.endBtn());
      add(btnEnd);
   }
}
