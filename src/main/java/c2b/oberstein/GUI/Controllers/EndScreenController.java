package c2b.oberstein.GUI.Controllers;

import c2b.oberstein.*;
import c2b.oberstein.GUI.Views.*;
import c2b.oberstein.util.*;

public class EndScreenController {
   
   private static EndScreenView endScreenView = QuizApp.getMainFrame().getEndScreenView();

   public static void end() {
      System.exit(0);
   }
}
