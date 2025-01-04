package c2b.oberstein.GUI.Views;

import c2b.oberstein.*;
import c2b.oberstein.GUI.Controllers.*;
import c2b.oberstein.util.*;
import lombok.*;

import javax.swing.*;
import java.awt.*;


@Data
public class EndScreenView extends JPanel {
   
   private Quiz playedQuiz;
   
   private JButton btnPlayAgain;
   private JButton btnChangeQuiz;
   private JButton btnEnd;
   private JLabel lblQuizNameText;
   private JLabel lblQuizName;
   private JLabel lblScoreText;
   private JLabel lblCorrectXyWrong;
   
   public EndScreenView(String quizName) {
      playedQuiz = QuizIOUtil.readQuiz(quizName);
      
      setLayout(null);
      
      initialze();
      
      add(btnPlayAgain);
      add(btnChangeQuiz);
      add(btnEnd);
      add(lblQuizNameText);
      add(lblQuizName);
      add(lblScoreText);
      add(lblCorrectXyWrong);
   }
   
   private void initialze(){
      
      btnPlayAgain = new JButton("Play Again");
      btnPlayAgain.setFont(new Font("Unispace", Font.PLAIN, 25));
      btnPlayAgain.setBounds(350, 350, 300, 50);
      btnPlayAgain.addActionListener(_ -> EndScreenController.playAgain());
      
      btnChangeQuiz = new JButton("Change Quiz");
      btnChangeQuiz.setFont(new Font("Unispace", Font.PLAIN, 25));
      btnChangeQuiz.setBounds(350, 410, 300, 50);
      btnChangeQuiz.addActionListener(_ -> EndScreenController.changeQuiz());
      
      btnEnd = new JButton("End");
      btnEnd.setFont(new Font("Unispace", Font.PLAIN, 25));
      btnEnd.setBounds(350, 470, 300, 50);
      btnEnd.addActionListener(_ -> EndScreenController.end());
      
      lblQuizNameText = new JLabel("Quiz Name:");
      lblQuizNameText.setHorizontalAlignment(SwingConstants.CENTER);
      lblQuizNameText.setFont(new Font("Unispace", Font.PLAIN, 25));
      lblQuizNameText.setBounds(350, 30, 300, 50);
      
      
      lblQuizName = new JLabel(playedQuiz.getName());
      lblQuizName.setHorizontalAlignment(SwingConstants.CENTER);
      lblQuizName.setFont(new Font("Unispace", Font.PLAIN, 25));
      lblQuizName.setBounds(200, 90, 600, 50);
      
      
      lblScoreText = new JLabel("Score:");
      lblScoreText.setHorizontalAlignment(SwingConstants.CENTER);
      lblScoreText.setFont(new Font("Unispace", Font.PLAIN, 25));
      lblScoreText.setBounds(350, 175, 300, 50);
      
      
      lblCorrectXyWrong = new JLabel("Correct: XY Wrong: XY"); //TODO:
      lblCorrectXyWrong.setHorizontalAlignment(SwingConstants.CENTER);
      lblCorrectXyWrong.setFont(new Font("Unispace", Font.PLAIN, 25));
      lblCorrectXyWrong.setBounds(200, 235, 600, 50);
      
   
   }
}
