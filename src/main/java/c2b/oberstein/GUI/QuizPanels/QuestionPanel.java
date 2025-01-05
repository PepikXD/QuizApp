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
   private JButton btnPrevious;
   private JButton btnNext;
   private JButton btnEnd;
   
   
   public QuestionPanel(Question question) {
      this.question = question;
      
      setBounds(10,10,980,580);
      
      initialize();

   }
   
   private void initialize(){
      
      txtAreaQuestion = new JTextArea();
      txtAreaQuestion.setRows(4);
      txtAreaQuestion.setText(question.getQuestion());
      txtAreaQuestion.setEditable(false);
      txtAreaQuestion.setLineWrap(true);
      txtAreaQuestion.setFont(new Font("Unispace", Font.PLAIN, 30));
      txtAreaQuestion.setBounds(10, 10, 950, 150);
      add(txtAreaQuestion);
      
      btnPrevious = new JButton("Previous");
      btnPrevious.setFont(new Font("Unispace", Font.PLAIN, 20));
      btnPrevious.setBounds(25, 500, 150, 40);
      btnPrevious.addActionListener(_ -> QuizViewController.previousBtn());
      add(btnPrevious);
      
      btnNext = new JButton("Next");
      btnNext.setFont(new Font("Unispace", Font.PLAIN, 20));
      btnNext.setBounds(800, 500, 150, 40);
      btnNext.addActionListener(_ -> QuizViewController.nextBtn());
      add(btnNext);
      
      btnEnd = new JButton("End Quiz");
      btnEnd.setFont(new Font("Unispace", Font.PLAIN, 20));
      btnEnd.setBounds(800, 500, 150, 40);
      btnEnd.addActionListener(_ -> QuizViewController.endBtn());
      add(btnEnd);
   }
}
