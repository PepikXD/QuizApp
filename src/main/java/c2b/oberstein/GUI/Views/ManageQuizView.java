package c2b.oberstein.GUI.Views;



import c2b.oberstein.*;
import c2b.oberstein.GUI.Controllers.*;
import c2b.oberstein.util.*;
import com.sun.security.auth.*;
import lombok.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
@Data
public class ManageQuizView extends JPanel {
   
   private JPanel editQuestionPanel;
   private JPanel yesOrNoPanel;
   private JRadioButton rdbtnYes;
   private JRadioButton rdbtnNo;
   private JPanel openQuestionPanel;
   private JLabel lblCorrectAnsOpenQuest;
   private JLabel lblEditQuest;
   private JLabel lblQuestion;
   private JLabel lblQuestType;
   private JPanel multipleChoicePanel;
   private JComboBox questTypeComboBox;
   private JLabel lblCorrectAnsMltpChoice;
   private JLabel lblWrongAnsMltpChoice_1;
   private JLabel lblWrongAnsMltpChoice_2;
   private JLabel lblWrongAnsMltpChoice_3;
   private JButton btnSave;
   private JButton btnSaveQuiz;
   private JLabel lblManageQuizes;
   private JComboBox quizComboBox;
   private JLabel lblChooseQuiz;
   private JLabel lblChooseQuestion;
   private JComboBox questionComboBox;
   private JButton btbDeleteSelectedQuiz;
   private JButton btnAddNewQuiz;
   private JButton btnDeleteSelectedQuestion;
   private JButton btnAddNewQuestion;
   private JPanel createQuizPanel;
   private JLabel lblCreateQuiz;
   private JLabel lblCreateQuizName;
   private JButton btnCreate;
   private JButton btnGoBack;
   private JTextField CreateQuizNameTextField;
   private JTextField questionTextField;
   private JTextField CorrectAnsMltpChoiceTextField;
   private JTextField WrongAnsMltpChoiceTextField_1;
   private JTextField WrongAnsMltpChoiceTextField_2;
   private JTextField WrongAnsMltpChoiceTextField_3;
   private JTextField correctAnsOpenQuestTextField;
   private final ButtonGroup buttonGroup = new ButtonGroup();
   
   /**
    * Create the panel.
    */
   public ManageQuizView() {
      
      initialize();
      
      setLayout(null);
      add(btnGoBack);
      add(editQuestionPanel);
      add(lblManageQuizes);
      add(quizComboBox);
      add(lblChooseQuiz);
      add(lblChooseQuestion);
      add(btnAddNewQuiz);
      add(questionComboBox);
      add(btbDeleteSelectedQuiz);
      add(btnDeleteSelectedQuestion);
      add(btnAddNewQuestion);
      add(createQuizPanel);
      
      
      editQuestionPanel.setVisible(false);
      multipleChoicePanel.setVisible(false);
      yesOrNoPanel.setVisible(false);
      openQuestionPanel.setVisible(false);

      
   }
   
   private void initialize(){
      editQuestionPanel = new JPanel();
      editQuestionPanel.setBounds(375, 175, 600, 400);
      editQuestionPanel.setLayout(null);
      
      yesOrNoPanel = new JPanel();
      yesOrNoPanel.setBounds(25, 170, 550, 150);
      editQuestionPanel.add(yesOrNoPanel);
      yesOrNoPanel.setLayout(null);
      
      rdbtnYes = new JRadioButton("Yes");
      buttonGroup.add(rdbtnYes);
      rdbtnYes.setFont(new Font("Unispace", Font.PLAIN, 20));
      rdbtnYes.setBounds(0, 0, 75, 30);
      yesOrNoPanel.add(rdbtnYes);
      
      rdbtnNo = new JRadioButton("No");
      rdbtnNo.setVerticalAlignment(SwingConstants.CENTER);
      rdbtnNo.setHorizontalAlignment(SwingConstants.LEADING);
      buttonGroup.add(rdbtnNo);
      rdbtnNo.setFont(new Font("Unispace", Font.PLAIN, 20));
      rdbtnNo.setBounds(0, 40, 75, 30);
      yesOrNoPanel.add(rdbtnNo);
      
      openQuestionPanel = new JPanel();
      openQuestionPanel.setBounds(25, 170, 550, 150);
      editQuestionPanel.add(openQuestionPanel);
      openQuestionPanel.setLayout(null);
      
      lblCorrectAnsOpenQuest = new JLabel("Correct Answer:");
      lblCorrectAnsOpenQuest.setFont(new Font("Unispace", Font.PLAIN, 20));
      lblCorrectAnsOpenQuest.setBounds(0, 0, 180, 30);
      openQuestionPanel.add(lblCorrectAnsOpenQuest);
      
      correctAnsOpenQuestTextField = new JTextField();
      correctAnsOpenQuestTextField.setBounds(190, 0, 360, 30);
      openQuestionPanel.add(correctAnsOpenQuestTextField);
      correctAnsOpenQuestTextField.setColumns(10);
      
      lblEditQuest = new JLabel("Edit Question");
      lblEditQuest.setHorizontalAlignment(SwingConstants.CENTER);
      lblEditQuest.setBounds(150, 10, 300, 50);
      lblEditQuest.setFont(new Font("Unispace", Font.PLAIN, 30));
      editQuestionPanel.add(lblEditQuest);
      
      lblQuestion = new JLabel("Question:");
      lblQuestion.setHorizontalAlignment(SwingConstants.LEFT);
      lblQuestion.setFont(new Font("Unispace", Font.PLAIN, 20));
      lblQuestion.setBounds(25, 75, 110, 30);
      editQuestionPanel.add(lblQuestion);
      
      questionTextField = new JTextField();
      questionTextField.setBounds(145, 75, 430, 30);
      questionTextField.setFont(new Font("Unispace", Font.PLAIN, 20));
      editQuestionPanel.add(questionTextField);
      questionTextField.setColumns(10);
      
      lblQuestType = new JLabel("Question Type:");
      lblQuestType.setHorizontalAlignment(SwingConstants.LEFT);
      lblQuestType.setFont(new Font("Unispace", Font.PLAIN, 20));
      lblQuestType.setBounds(25, 115, 170, 30);
      editQuestionPanel.add(lblQuestType);
      
      questTypeComboBox = new JComboBox<>(QuestionType.getEnumValuesAsStrings());
      questTypeComboBox.setFont(new Font("Unispace", Font.PLAIN, 15));
      questTypeComboBox.setBounds(205, 115, 200, 30);
      questTypeComboBox.setSelectedIndex(0);
      editQuestionPanel.add(questTypeComboBox);
      
      multipleChoicePanel = new JPanel();
      multipleChoicePanel.setBounds(25, 170, 550, 150);
      editQuestionPanel.add(multipleChoicePanel);
      multipleChoicePanel.setLayout(null);
      
      lblCorrectAnsMltpChoice = new JLabel("Correct Answer:");
      lblCorrectAnsMltpChoice.setHorizontalAlignment(SwingConstants.LEFT);
      lblCorrectAnsMltpChoice.setFont(new Font("Unispace", Font.PLAIN, 20));
      lblCorrectAnsMltpChoice.setBounds(0, 0, 180, 30);
      multipleChoicePanel.add(lblCorrectAnsMltpChoice);
      
      CorrectAnsMltpChoiceTextField = new JTextField();
      CorrectAnsMltpChoiceTextField.setColumns(10);
      CorrectAnsMltpChoiceTextField.setBounds(190, 0, 360, 30);
      multipleChoicePanel.add(CorrectAnsMltpChoiceTextField);
      
      lblWrongAnsMltpChoice_1 = new JLabel("Wrong Answer:");
      lblWrongAnsMltpChoice_1.setHorizontalAlignment(SwingConstants.LEFT);
      lblWrongAnsMltpChoice_1.setFont(new Font("Unispace", Font.PLAIN, 20));
      lblWrongAnsMltpChoice_1.setBounds(0, 40, 180, 30);
      multipleChoicePanel.add(lblWrongAnsMltpChoice_1);
      
      WrongAnsMltpChoiceTextField_1 = new JTextField();
      WrongAnsMltpChoiceTextField_1.setColumns(10);
      WrongAnsMltpChoiceTextField_1.setBounds(190, 40, 360, 30);
      multipleChoicePanel.add(WrongAnsMltpChoiceTextField_1);
      
      lblWrongAnsMltpChoice_2 = new JLabel("Wrong Answer:");
      lblWrongAnsMltpChoice_2.setHorizontalAlignment(SwingConstants.LEFT);
      lblWrongAnsMltpChoice_2.setFont(new Font("Unispace", Font.PLAIN, 20));
      lblWrongAnsMltpChoice_2.setBounds(0, 80, 180, 30);
      multipleChoicePanel.add(lblWrongAnsMltpChoice_2);
      
      WrongAnsMltpChoiceTextField_2 = new JTextField();
      WrongAnsMltpChoiceTextField_2.setColumns(10);
      WrongAnsMltpChoiceTextField_2.setBounds(190, 80, 360, 30);
      multipleChoicePanel.add(WrongAnsMltpChoiceTextField_2);
      
      lblWrongAnsMltpChoice_3 = new JLabel("Wrong Answer:");
      lblWrongAnsMltpChoice_3.setHorizontalAlignment(SwingConstants.LEFT);
      lblWrongAnsMltpChoice_3.setFont(new Font("Unispace", Font.PLAIN, 20));
      lblWrongAnsMltpChoice_3.setBounds(0, 120, 180, 30);
      multipleChoicePanel.add(lblWrongAnsMltpChoice_3);
      
      WrongAnsMltpChoiceTextField_3 = new JTextField();
      WrongAnsMltpChoiceTextField_3.setColumns(10);
      WrongAnsMltpChoiceTextField_3.setBounds(190, 120, 360, 30);
      multipleChoicePanel.add(WrongAnsMltpChoiceTextField_3);
      
      btnSave = new JButton("Save");
      btnSave.setFont(new Font("Unispace", Font.PLAIN, 20));
      btnSave.setBounds(225, 335, 150, 50);
      btnSave.addActionListener(actionEvent -> {
         Question question = null;
         switch (questTypeComboBox.getSelectedIndex()){
            case 0:
               question = new Question(
                       getQuestionTextField().getText(),
                       getCorrectAnsMltpChoiceTextField().getText(),
                       getWrongAnsMltpChoiceTextField_1().getText(),
                       getWrongAnsMltpChoiceTextField_2().getText(),
                       getWrongAnsMltpChoiceTextField_3().getText());
               break;
            case 1:
               question = new Question(
                       getQuestionTextField().getText(),
                       getRdbtnYes().isSelected()); //Yes and No rdbtn are in btn group --> if yes is selected, no cant be annd vice versa
               break;
            case 2:
               question = new Question(
                       getQuestionTextField().getText(),
                       getCorrectAnsOpenQuestTextField().getText());
         }
         ManageQuizController.saveQuestion(question,quizComboBox.getSelectedIndex());
      });
      editQuestionPanel.add(btnSave);
      
      lblManageQuizes = new JLabel("Manage Quizes");
      lblManageQuizes.setHorizontalAlignment(SwingConstants.CENTER);
      lblManageQuizes.setFont(new Font("Unispace", Font.PLAIN, 50));
      lblManageQuizes.setBounds(250, 25, 500, 100);
      
      quizComboBox = new JComboBox<>(QuizApp.getQuizzesNames());
      quizComboBox.setFont(new Font("Unispace", Font.PLAIN, 15));
      quizComboBox.setBounds(60, 230, 250, 30);
      quizComboBox.setSelectedIndex(0);
      
      lblChooseQuiz = new JLabel("Choose Quiz");
      lblChooseQuiz.setHorizontalAlignment(SwingConstants.CENTER);
      lblChooseQuiz.setFont(new Font("Unispace", Font.PLAIN, 25));
      lblChooseQuiz.setBounds(60, 185, 250, 40);
      
      lblChooseQuestion = new JLabel("Choose Question");
      lblChooseQuestion.setHorizontalAlignment(SwingConstants.CENTER);
      lblChooseQuestion.setFont(new Font("Unispace", Font.PLAIN, 25));
      lblChooseQuestion.setBounds(60, 385, 250, 40);
      
      questionComboBox = new JComboBox<>(QuizApp.getQuizzes().get(getQuizComboBox().getSelectedIndex()).getQuestionsAsArray());
      questionComboBox.setFont(new Font("Unispace", Font.PLAIN, 15));
      questionComboBox.setBounds(60, 430, 250, 30);
      
      btbDeleteSelectedQuiz = new JButton("Delete Selected Quiz");
      btbDeleteSelectedQuiz.setFont(new Font("Unispace", Font.PLAIN, 20));
      btbDeleteSelectedQuiz.setBounds(20, 275, 330, 30);
      btbDeleteSelectedQuiz.addActionListener(actionEvent -> ManageQuizController.deleteSelecetedQuiz(getQuizComboBox().getSelectedIndex()));
      
      btnAddNewQuiz = new JButton("Add New Quiz");
      btnAddNewQuiz.setFont(new Font("Unispace", Font.PLAIN, 20));
      btnAddNewQuiz.setBounds(20, 320, 330, 30);
      btnAddNewQuiz.addActionListener(actionEvent -> ManageQuizController.showPanelToCreateQuiz());
      
      btnDeleteSelectedQuestion = new JButton("Delete Selected Question");
      btnDeleteSelectedQuestion.setFont(new Font("Unispace", Font.PLAIN, 20));
      btnDeleteSelectedQuestion.setBounds(20, 475, 330, 30);
      btnDeleteSelectedQuestion.addActionListener(actionEvent -> ManageQuizController.deleteSelecetedQuestion(getQuestionComboBox().getSelectedIndex(),getQuizComboBox().getSelectedIndex()));
      
      btnAddNewQuestion = new JButton("Add New Question");
      btnAddNewQuestion.setFont(new Font("Unispace", Font.PLAIN, 20));
      btnAddNewQuestion.setBounds(20, 520, 330, 30);
      btnAddNewQuestion.addActionListener(actionEvent -> ManageQuizController.showPanelToCrateQuestion());
      
      createQuizPanel = new JPanel();
      createQuizPanel.setBounds(375, 175, 600, 400);
      createQuizPanel.setLayout(null);
      
      lblCreateQuiz = new JLabel("Edit Quiz");
      lblCreateQuiz.setHorizontalAlignment(SwingConstants.CENTER);
      lblCreateQuiz.setBounds(200, 10, 200, 50);
      lblCreateQuiz.setFont(new Font("Unispace", Font.PLAIN, 30));
      createQuizPanel.add(lblCreateQuiz);
      
      lblCreateQuizName = new JLabel("Name:");
      lblCreateQuizName.setHorizontalAlignment(SwingConstants.CENTER);
      lblCreateQuizName.setFont(new Font("Unispace", Font.PLAIN, 20));
      lblCreateQuizName.setBounds(25, 100, 75, 40);
      createQuizPanel.add(lblCreateQuizName);
      
      CreateQuizNameTextField = new JTextField();
      CreateQuizNameTextField.setBounds(110, 100, 465, 40);
      createQuizPanel.add(CreateQuizNameTextField);
      CreateQuizNameTextField.setColumns(10);
      
      btnCreate = new JButton("Create");
      btnCreate.setFont(new Font("Unispace", Font.PLAIN, 20));
      btnCreate.setBounds(225, 325, 150, 50);
      btnCreate.addActionListener(actionEvent -> ManageQuizController.createQuiz(CreateQuizNameTextField.getText()));
      createQuizPanel.add(btnCreate);
      btnCreate.setVisible(false);
      
//      btnSaveQuiz = new JButton("Save");
//      btnSaveQuiz.setFont(new Font("Unispace", Font.PLAIN, 20));
//      btnSaveQuiz.setBounds(225, 325, 150, 50);
//      btnSaveQuiz.addActionListener(actionEvent -> ManageQuizController.saveQuiz(CreateQuizNameTextField.getText(), getQuizComboBox().getSelectedIndex()));
//      createQuizPanel.add(btnSaveQuiz);
//      btnSaveQuiz.setVisible(true);
//
//      btnGoBack = new JButton("Back");
//      btnSaveQuiz.setFont(new Font("Unispace", Font.PLAIN, 15));
//      btnSaveQuiz.setBounds(100, 100, 300, 200);
//      btnGoBack.setHorizontalAlignment(SwingConstants.CENTER);
//      btnGoBack.addActionListener(actionEvent -> ManageQuizController.goBack());
//      btnGoBack.setVisible(true);
//      btnGoBack.setBorder(new LineBorder(Color.BLACK,50));
      
   }
   
}