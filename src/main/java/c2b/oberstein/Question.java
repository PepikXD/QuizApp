package c2b.oberstein;

import lombok.*;

import java.util.*;
@Data
public class Question {
   
   private QuestionType questionType;
   private String question;
   private String[] multipleChoiceAnswers;
   private boolean yesOrNoAnswer;
   private String openAnswer;
   
   /**
    * Constructor for multiplechoise question
    * @param question
    * @param answer1
    * @param answer2
    * @param answer3
    * @param answer4
    */
   public Question(String question, String answer1, String answer2, String answer3, String answer4){
      questionType = QuestionType.MULTIPLE_CHOICE;
      this.question = question;
      multipleChoiceAnswers = new String[]{
              answer1,
              answer2,
              answer3,
              answer4
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
