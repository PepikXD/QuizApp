package c2b.oberstein.util;

import c2b.oberstein.*;
import com.google.gson.*;
import lombok.*;
import java.io.*;
import java.util.*;


public class QuizIOUtil {
   
   private static final Gson gson = new Gson();
   @Getter
   private static final String absolutePathTo = new File("").getAbsolutePath() + "\\quizzes\\";


   /**
    * create new file for quiz if doesn't exist already,if exist overwrites the current file
    * @param quiz quiz object
    * @return true if succesful, false otherwies
    */
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

   /**
    * read file (if exists) of the 'name' and creates object from the file
    * @param name name of quiz
    * @return quiz corresponding to this name
    */
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

   /**
    * read all quizzes
    * @return all saved quizzes
    */
   public static List <Quiz> getAllQuizzesAsArray(){
      File[] files = new File(absolutePathTo).listFiles();
      List<Quiz> quizzes = new ArrayList <>(1);
      for (File f:files){
         quizzes.add(readQuiz(f.getName()));
      }
      return quizzes;
   }

   /**
    * reads all file names in quizzes directory
    * @return names of every quiz
    */
   public static String[] getAllQuizzesNamesAsArray(){
      File[] files = new File(absolutePathTo).listFiles();
      String[] names = new String[files.length];
      for (int i = 0; i < names.length; i++) {
         names[i] = files[i].getName();
      }
      return names;
   }

   /**
    * deletes the file of the 'name'
    * @param name name of quiz to be deleted
    * @return true if deleted succesfuly, false otherwise
    */
   public static boolean deleteQuiz(String name){
      File file = new File(absolutePathTo + name);
      return file.delete();
   }
   
}
