package c2b.oberstein;

import c2b.oberstein.GUI.*;
import c2b.oberstein.GUI.Views.*;
import c2b.oberstein.util.*;

import javax.swing.*;
import java.util.*;

public class Main {
   public static void main(String[] args) {
      
      
      
      List<Question> xd = new ArrayList<>();
//      xd.add(new Question("a",true));
//      xd.add(new Question("b","negr"));
//      xd.add(new Question("c","1","2","3","4"));
      
//      QuizIOUtil.saveQuiz(new Quiz("A",xd));
//      QuizIOUtil.saveQuiz(new Quiz("B",xd));
//      QuizIOUtil.saveQuiz(new Quiz("C",xd));
//      QuizIOUtil.saveQuiz(new Quiz("D",xd));
      
      
      QuizApp quizApp = new QuizApp();
      quizApp.run();
   
   }
}