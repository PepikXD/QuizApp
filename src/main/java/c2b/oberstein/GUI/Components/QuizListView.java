package c2b.oberstein.GUI.Components;

import c2b.oberstein.util.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizListView {
   
   private JScrollPane scrollPane ;
   
   public QuizListView() {
      this.scrollPane = new JScrollPane();
      this.scrollPane.setLayout(new GridLayout(new File(QuizIOUtil.getAbsolutePathTo()).listFiles().length,5));
   }
}
