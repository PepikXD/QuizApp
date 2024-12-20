package c2b.oberstein;

import lombok.*;
import java.util.*;

@Data
@AllArgsConstructor
public class Quiz {
   
   private String name;
   private List<Question> questions;
   
}
