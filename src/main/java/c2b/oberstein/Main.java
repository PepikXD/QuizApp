package c2b.oberstein;

import c2b.oberstein.GUI.*;
import c2b.oberstein.GUI.Views.*;
import c2b.oberstein.util.*;

import javax.swing.*;
import java.util.*;

public class Main {
   public static void main(String[] args) {
      
      QuizIOUtil.saveQuiz(new Quiz("A",new ArrayList <>()));
      QuizIOUtil.saveQuiz(new Quiz("B",new ArrayList <>()));
      QuizIOUtil.saveQuiz(new Quiz("C",new ArrayList <>()));
      QuizIOUtil.saveQuiz(new Quiz("D",new ArrayList <>()));
      
      MainFrame mainFrame = new MainFrame();
   
   }
}