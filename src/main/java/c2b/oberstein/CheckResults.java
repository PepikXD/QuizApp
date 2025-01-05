package c2b.oberstein;

import c2b.oberstein.GUI.Views.*;
import lombok.*;

import java.util.*;

@Data
public class CheckResults {
   
   private int correct;
   private int wrong;
   private Quiz quiz;
   
   private List<Question> questions;
   
   public CheckResults(Quiz quiz) {
      this.quiz = quiz;
      questions = quiz.getQuestions();
   }
   
   public void checkMltpAnswer(Question q, String answer){
      if (q.getCorrectMltpAnswer().equals(answer)) {
         correct++;
      } else {
         wrong++;
      }
   }
   
   public void checkYoNAnwer(Question q, boolean answer){
      if (q.isYesOrNoAnswer() == answer){
         correct++;
      } else {
         wrong++;
      }
   }
   
   public void checkOpenAnswer(Question q, String answer){
      if (q.getOpenAnswer().equals(answer)){
         correct++;
      } else {
         wrong++;
      }
      
   }
   
   public String getScoreTetx(){
      return "Correct: " + correct + " Wrong: " + wrong;
   }
}
