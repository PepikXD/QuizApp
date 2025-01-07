package c2b.oberstein.GUI.Controllers;

import c2b.oberstein.util.*;

public class ChooseQuizController {
   /**
    * changes the panel to quizView with correct queestion
    * @param chosenQuizIndex index of the question directory
    */
   public static void play(int chosenQuizIndex){
      
      String chosenQuizName = QuizIOUtil.getAllQuizzesNamesAsArray()[chosenQuizIndex];
      ChangePanels.changeToQuiz(chosenQuizName);
      
   }
   
}
