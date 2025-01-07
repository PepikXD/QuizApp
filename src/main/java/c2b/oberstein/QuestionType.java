package c2b.oberstein;

public enum QuestionType {
   MULTIPLE_CHOICE("Multiple Choice"),
   YES_OR_NO("Yes Or No"),
   OPEN("Open"),
   ;
   
   public String value;
   
   QuestionType(String value) {
      this.value = value;
   }

   /**
    *
    * @return all enums value field
    */
   public static String[] getEnumValuesAsStrings(){
      String[] s = new String[QuestionType.values().length];
      for (int i = 0; i < s.length; i++) {
         s[i] = QuestionType.values()[i].value;
      }
      return s;
   }
}
