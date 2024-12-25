package c2b.oberstein.util;

import c2b.oberstein.*;
import com.google.gson.*;
import lombok.*;
import java.io.*;
import java.util.*;


public class QuizIOUtil {
   
   private static final Gson gson = new Gson();
   @Getter
   private static final String absolutePathTo = new File("").getAbsolutePath() + "\\quizes\\";


   public static boolean saveQuiz(Quiz quiz){
      File file = new File(absolutePathTo + quiz.getName());
      BufferedWriter writer;
      try {
         writer = new BufferedWriter(new FileWriter(file));
         writer.write(gson.toJson(quiz));
         writer.close();
      } catch (IOException e) {
         return false;
      }
      return true;
   }
   
   public static Quiz readQuiz(String name){
      File file = new File(absolutePathTo + name);
      Quiz returnQuiz = null;
      BufferedReader reader;
      try {
         reader = new BufferedReader(new FileReader(file));
         returnQuiz = gson.fromJson(reader.readLine(), Quiz.class);
         reader.close();
      }catch (IOException e){
         //TODO: add ERROR popup
      }
      return returnQuiz;
   }
   
   public static List <Quiz> getAllQuizzesAsArray(){
      File[] files = new File(absolutePathTo).listFiles();
      List<Quiz> quizzes = new ArrayList <>(1);
      for (File f:files){
         quizzes.add(readQuiz(f.getName()));
      }
      return quizzes;
   }
   
   public static String[] getAllQuizzesNamesAsArray(){
      File[] files = new File(absolutePathTo).listFiles();
      String[] names = new String[files.length];
      for (int i = 0; i < names.length; i++) {
         names[i] = files[i].getName();
      }
      return names;
   }
   
   public static boolean deleteQuiz(String name){
      File file = new File(absolutePathTo + name);
      return file.delete();
   }
   
}
