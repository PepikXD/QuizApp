package c2b.oberstein;

import lombok.*;

import java.util.*;
@Data
public class Question {
   
   private QuestionType questionType;
   private String question;
   private String[] multipleChoiceAnswers;
   private String correctMltpAnswer;
   private boolean yesOrNoAnswer;
   private String openAnswer;
   
   /**
    * Constructor for multiplechoise question
    * @param question
    * @param correct
    * @param wrong1
    * @param wrong2
    * @param wrong3
    */
   public Question(String question, String correct, String wrong1, String wrong2, String wrong3){
      questionType = QuestionType.MULTIPLE_CHOICE;
      this.question = question;
      correctMltpAnswer = correct;
      multipleChoiceAnswers = new String[]{
              correct,
              wrong1,
              wrong2,
              wrong3
      };
   }
   
   /**
    * Constructor for Yes or No question
    * @param question
    * @param yesOrNoAnswer true if answer is Yes - false if No
    */
   public Question(String question, boolean yesOrNoAnswer){
      questionType = QuestionType.YES_OR_NO;
      this.question = question;
      this.yesOrNoAnswer = yesOrNoAnswer;
   }
   
   /**
    * Constructor for opn answer question
    * @param question
    * @param openAnswer !!CASE SENSITIVE
    */
   public Question(String question, String openAnswer){
      questionType = QuestionType.OPEN;
      this.question = question;
      this.openAnswer = openAnswer;
   }

}
