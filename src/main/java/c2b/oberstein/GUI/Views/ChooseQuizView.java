package c2b.oberstein.GUI.Views;

import c2b.oberstein.GUI.Controllers.*;
import c2b.oberstein.util.*;
import lombok.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
@Data
public class ChooseQuizView extends JPanel{
   
   private JList quizList;
   private JLabel lblChooseQuiz;
   private JButton btnPlay;
   
   public ChooseQuizView() {
      setLayout(null);
      
      initialize();
      
      add(quizList);
      add(lblChooseQuiz);
      add(btnPlay);
   }
   
   
   private void initialize(){
      
      DefaultListModel<String> model = new DefaultListModel<>();
      DefaultListCellRenderer renderer = new DefaultListCellRenderer();
      renderer.setHorizontalAlignment(SwingConstants.CENTER);
      
      quizList = new JList<>(model);
      quizList.setBorder(new LineBorder(new Color(0, 0, 0)));
      quizList.setSelectedIndex(0);
      quizList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      quizList.setFont(new Font("Unispace", Font.PLAIN, 25));
      quizList.setBounds(10, 100, 980, 400);
      quizList.setCellRenderer(renderer);
      model.addAll(Arrays.stream(QuizIOUtil.getAllQuizzesNamesAsArray()).toList());
      
      
      
      lblChooseQuiz = new JLabel("Choose Quiz To Play");
      lblChooseQuiz.setHorizontalAlignment(SwingConstants.CENTER);
      lblChooseQuiz.setFont(new Font("Unispace", Font.PLAIN, 30));
      lblChooseQuiz.setBounds(250, 25, 500, 50);
      
      
      btnPlay = new JButton("Play");
      btnPlay.setFont(new Font("Unispace", Font.PLAIN, 30));
      btnPlay.setBounds(400, 525, 200, 50);
      btnPlay.addActionListener(_ -> ChooseQuizController.play(quizList.getSelectedIndex()));
   }
}
