package c2b.oberstein;

import c2b.oberstein.GUI.*;
import c2b.oberstein.util.*;
import lombok.*;

import java.util.*;

@Data
public class QuizApp implements Runnable{
   
   @Getter
   private static List<Quiz> quizzes;
   @Getter
   private static MainFrame mainFrame;
   public static String[] getQuizzesNames(){
      String[] s = new String[quizzes.size()];
      for (int i = 0; i < s.length; i++) {
         s[i] = quizzes.get(i).getName();
      }
      return s;
   }
   
   
   
   public QuizApp() {
      quizzes = QuizIOUtil.getAllQuizzesAsArray();
   }
   
   @Override
   public void run() {
      
      QuizIOUtil.saveQuiz(new Quiz("A",new ArrayList <>()));
      QuizIOUtil.saveQuiz(new Quiz("B",new ArrayList <>()));
      QuizIOUtil.saveQuiz(new Quiz("C",new ArrayList <>()));
      QuizIOUtil.saveQuiz(new Quiz("D",new ArrayList <>()));
      
      mainFrame = new MainFrame();
   
   }
}
