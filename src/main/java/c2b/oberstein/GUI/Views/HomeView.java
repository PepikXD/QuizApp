package c2b.oberstein.GUI.Views;

import c2b.oberstein.GUI.Controllers.*;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JPanel {
   
   private JLabel mainTextLabel;
   private JLabel pictureLabel;
   private JButton manageQuizesButton;
   private JButton chooseQuizButton;
   
   
   public HomeView() {
      
      initialize();
      
      setLayout(null);
      add(mainTextLabel);
      add(pictureLabel);
      add(manageQuizesButton);
      add(chooseQuizButton);
      
   }
   
   private void initialize() {
      mainTextLabel = new JLabel("Quiz App");
      mainTextLabel.setBounds(350, 75, 300, 100);
      mainTextLabel.setFont(new Font("Unispace", Font.PLAIN, 50));
      mainTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
      
      pictureLabel = new JLabel("");
      pictureLabel.setBounds(400, 175, 200, 200);
      pictureLabel.setIcon(new ImageIcon("src/main/resources/quizImg.png"));
      
      manageQuizesButton = new JButton("Manage Quizes");
      manageQuizesButton.setBounds(150, 400, 300, 100);
      manageQuizesButton.setFont(new Font("Unispace", Font.PLAIN, 30));
      manageQuizesButton.addActionListener(ae -> HomeViewController.goToManageView());
      
      chooseQuizButton = new JButton("Choose Quiz");
      chooseQuizButton.setBounds(550, 400, 300, 100);
      chooseQuizButton.setFont(new Font("Unispace", Font.PLAIN, 30));
      chooseQuizButton.addActionListener(ae -> HomeViewController.goToQuizChooseView());
   }
}

