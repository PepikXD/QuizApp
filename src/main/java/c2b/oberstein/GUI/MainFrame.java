package c2b.oberstein.GUI;

import c2b.oberstein.GUI.Views.*;
import com.sun.javafx.logging.jfr.*;
import lombok.*;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


@Data
public class MainFrame extends JFrame{
   
   private HomeView homeView = new HomeView();
   
   
   public MainFrame() {
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setSize(1000,600);
      this.setResizable(false);
      this.add(homeView);
      this.setVisible(true);
   }
}
