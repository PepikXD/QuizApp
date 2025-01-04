package c2b.oberstein.GUI.Controllers;

import c2b.oberstein.util.*;

public class ChooseQuizController {
   
   public static void play(int chosenQuizIndex){
      
      String chosenQuizName = QuizIOUtil.getAllQuizzesNamesAsArray()[chosenQuizIndex];
      
      ChangePanels.changeToQuiz(chosenQuizName);
      
   }
   
}
