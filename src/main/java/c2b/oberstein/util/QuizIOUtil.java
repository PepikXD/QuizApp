package c2b.oberstein.util;

import c2b.oberstein.*;
import com.google.gson.*;
import lombok.*;

import java.io.*;


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
      }catch (IOException e){
         //TODO: add ERROR popup
      }
      return returnQuiz;
   }
   
   public static boolean deleteQuiz(String name){
      File file = new File(absolutePathTo + name);
      return file.delete();
   }
   
}
