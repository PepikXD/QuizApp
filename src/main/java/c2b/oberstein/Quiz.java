package c2b.oberstein;

import lombok.*;

import javax.security.auth.login.*;
import java.util.*;

@Data
@AllArgsConstructor
public class Quiz {
   
   private String name;
   private List<Question> questions;
   
   public String[] getQuestionsAsArray(){
      String[] s = new String[questions.size()];
      for (int i = 0; i < s.length; i++) {
         s[i] = questions.get(i).getQuestion();
      }
      return s;
   }
   
}
