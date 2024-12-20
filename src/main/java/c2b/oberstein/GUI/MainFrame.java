package c2b.oberstein.GUI;

import c2b.oberstein.GUI.Views.*;
import lombok.*;

import javax.swing.*;
@Data

public class MainFrame {
   private JFrame frame;
   private JPanel currentPanel;
   public MainFrame() {
      this.frame = new JFrame("Vanocni Projekt - Kviz");
      this.currentPanel = new HomeViewPanel();
   }
   
}
