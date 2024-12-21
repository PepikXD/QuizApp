package c2b.oberstein;

import lombok.*;

import javax.security.auth.login.*;
import java.util.*;

@Data
@AllArgsConstructor
public class Quiz {
   
   private String name;
   private List<Question> questions;
   
   public String getName(){
      return name;
   }
   
}
