package c2b.oberstein.GUI.Components;

import c2b.oberstein.*;
import c2b.oberstein.GUI.Controllers.*;
import c2b.oberstein.util.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizListView extends JPanel{
   
   private JList<JButton> quizViewList;
   private Quiz[] quizzes = QuizIOUtil.getAllQuizesAsArray();
   private boolean isForEdit;
   
   /**
    *
    * @param isForEdit truw if is on quiz mannager view / false if is for picking quiz to play
    */
   public QuizListView(boolean isForEdit) {
      this.isForEdit = isForEdit;
      this.setLayout(null);
   }
   
   private void initialize(){
      quizViewList = new JList <>();
      for (int i = 0; i < quizzes.length; i++) {
         JButton button = new JButton(quizzes[i].getName());
         button.setHorizontalAlignment(SwingConstants.CENTER);
         button.setVerticalAlignment(SwingConstants.CENTER);
         if (isForEdit){
            button.addActionListener(actionEvent -> QuizListViewController.goToQuizEditor());
         }else {
            button.addActionListener(actionEvent -> QuizListViewController.goToQuiz());
         }
         quizViewList.add(button);
      }
      
   }
}
