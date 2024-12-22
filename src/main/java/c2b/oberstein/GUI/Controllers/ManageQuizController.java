package c2b.oberstein.GUI.Controllers;

import c2b.oberstein.*;
import c2b.oberstein.util.*;

import java.util.*;

public class ManageQuizController {
   
   public static void saveQuestion(){
   
   }
   
   public static void deleteSelecetedQuiz(String name){
      QuizIOUtil.deleteQuiz(name);
   }
   
   public static void deleteSelecetedQuestion(String quizName){
   
   }
   
   public static void showPanelToCrateQuestion(String quizName){
   
   }
   
   public static void showPanelToCreateQuiz(){
   
   }
   
   public static void createQuiz(String name){
      QuizIOUtil.saveQuiz(new Quiz(name,new ArrayList <>()));
   }
}
