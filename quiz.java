import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class quiz implements ActionListener {
    String[] questions = {   // Add all question to questions array
                            "Who invented Java Programming?",
                            "Number of primitive data types in Java are?",
                            "What is the size of float and double in java?",
                            "When is the object created with new keyword?",
                            "Total constructor string class have?",
                            "Output of Math.floor(3.6)?",
                            "Which package contains the Random class?",
                            "What is Runnable?",
                            "Where is System class defined?",
                            "What does the operator >>>> do?"
                        };

    String[][] options = {   // Add all options to options array
                            {"Guido van Rossum", "Dennis Ritchie", "James Gosling", "Bjarne Stroustrup"},
                            {"6", "8", "7", "9"},
                            {"32 and 64", "32 and 32", "64 and 64", "64 and 32"},
                            {"At compile time", "At run time", "Depends on the code", "None"},
                            {"3", "7", "20", "13"},
                            {"3", "4.0", "3.0", "4"},
                            {"java.awt.package", "java.util.package", "java.lang.package", "java.io.package"},
                            {"Abstract class", "Interface", "Class", "Method"},
                            {"java.lang.package", "java.util.package", "java.io.package", "None"},
                            {"Right shift operator", "Left shift operator", "Zero fill left shift", "Zero fill right shift"}
                        };

    char[] answers = {'C', 'B', 'A', 'B', 'D', 'C', 'B', 'B', 'A', 'D'};   // Add all answer to answers array

    int queNumber;
    int correctGuess;
    int totalQuestions = questions.length;
    int getscored;
    int seconds = 10;
    
    JFrame frame = new JFrame("Quiz");   // Create a frame

    JTextField textField = new JTextField();   // Add textField for text questions

    JTextArea textArea = new JTextArea();   // Add textArea for questions & increment queNumber

    JButton buttonA = new JButton();   // Add buttons for options
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();

    JLabel labelA = new JLabel();   // Add labels for options
    JLabel labelB = new JLabel();
    JLabel labelC = new JLabel();
    JLabel labelD = new JLabel();
    JLabel secondsLeft = new JLabel();
    
    JTextField message = new JTextField();   // Add textField for extra message
    JTextField textField1 = new JTextField();   // Add textfields for display results
    JTextField textField2 = new JTextField();
    JTextField textField3 = new JTextField();
    JTextField textField4 = new JTextField();
    JTextField textField5 = new JTextField();
    JTextField question = new JTextField();
    JTextField correctAnswer = new JTextField();
    JTextField wrongAnswer = new JTextField();
    JTextField percentage = new JTextField();
    JTextField status = new JTextField();

    Timer timer = new Timer(1000, new ActionListener() {   // Add timer countdown
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            secondsLeft.setText(seconds + " seconds left");

            if(seconds <= 0) {
                displayAnswer();
            }
        }
    });

    quiz() {   // Construcor of quiz class
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Add design to frame
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);
        
        textField.setBounds(0, 0, 650, 50);   // Add design to textField
        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(0, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textArea.setBounds(0, 50, 650, 50);   // Add design to textArea
        textArea.setBackground(new Color(25, 25, 25));
        textArea.setForeground(new Color(255, 69, 0));
        textArea.setFont(new Font("MV Boli", Font.BOLD, 25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        buttonA.setBounds(10, 140, 100, 100);   // Add design to buttonA
        buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.setText("A");
        buttonA.addActionListener(this);

        buttonB.setBounds(10, 250, 100, 100);   // Add design to buttonB
        buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.setText("B");
        buttonB.addActionListener(this);

        buttonC.setBounds(10, 360, 100, 100);   // Add design to buttonC
        buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.setText("C");
        buttonC.addActionListener(this);

        buttonD.setBounds(10, 470, 100, 100);   // Add design to buttonD
        buttonD.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.setText("D");
        buttonD.addActionListener(this);

        labelA.setBounds(125, 140, 500, 100);   // Add design to labelA
        labelA.setForeground(new Color(0, 255, 0));
        labelA.setFont(new Font("MV Boli", Font.PLAIN, 35));

        labelB.setBounds(125, 250, 500, 100);   // Add design to labelB
        labelB.setForeground(new Color(0, 255, 0));
        labelB.setFont(new Font("MV Boli", Font.PLAIN, 35));

        labelC.setBounds(125, 360, 500, 100);   // Add design to labelC
        labelC.setForeground(new Color(0, 255, 0));
        labelC.setFont(new Font("MV Boli", Font.PLAIN, 35));

        labelD.setBounds(125, 470, 500, 100);   // Add design to labelD
        labelD.setForeground(new Color(0, 255, 0));
        labelD.setFont(new Font("MV Boli", Font.PLAIN, 35));

        secondsLeft.setBounds(520, 100, 115, 30);   // Add design to secondsLeft
        secondsLeft.setForeground(new Color(255, 255, 255));
        secondsLeft.setFont(new Font("MV Boli", Font.BOLD, 15));
        // secondsLeft.setOpaque(true);
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);
        secondsLeft.setText(seconds + " seconds left");
        
        message.setBounds(0, 50, 650, 50);   // Add design to message
        message.setBackground(new Color(25, 25, 25));
        message.setForeground(new Color(0, 255, 0));
        message.setFont(new Font("Ink Free", Font.BOLD, 30));
        message.setBorder(BorderFactory.createBevelBorder(1));
        message.setHorizontalAlignment(JTextField.CENTER);
        message.setEditable(false);

        textField1.setBounds(40, 180, 300, 70);   // Add design to textField1
        textField1.setBackground(new Color(25, 25, 25));
        textField1.setForeground(new Color(218, 165, 32));
        textField1.setFont(new Font("MV Boli", Font.BOLD, 30));
        textField1.setBorder(BorderFactory.createBevelBorder(1));
        textField1.setHorizontalAlignment(JTextField.CENTER);
        textField1.setEditable(false);

        question.setBounds(350, 180, 250, 70);   // Add design to question
        question.setBackground(new Color(25, 25, 25));
        question.setForeground(new Color(218, 165, 32));
        question.setFont(new Font("MV Boli", Font.BOLD, 30));
        question.setBorder(BorderFactory.createBevelBorder(1));
        question.setHorizontalAlignment(JTextField.CENTER);
        question.setEditable(false);

        textField2.setBounds(40, 250, 300, 70);   // Add design to textField2
        textField2.setBackground(new Color(25, 25, 25));
        textField2.setForeground(new Color(0, 225, 0));
        textField2.setFont(new Font("MV Boli", Font.BOLD, 30));
        textField2.setBorder(BorderFactory.createBevelBorder(1));
        textField2.setHorizontalAlignment(JTextField.CENTER);
        textField2.setEditable(false);

        correctAnswer.setBounds(350, 250, 250, 70);   // Add design to correctAnswer
        correctAnswer.setBackground(new Color(25, 25, 25));
        correctAnswer.setForeground(new Color(0, 225, 0));
        correctAnswer.setFont(new Font("MV Boli", Font.BOLD, 30));
        correctAnswer.setBorder(BorderFactory.createBevelBorder(1));
        correctAnswer.setHorizontalAlignment(JTextField.CENTER);
        correctAnswer.setEditable(false);

        textField3.setBounds(40, 320, 300, 70);   // Add design to textField3
        textField3.setBackground(new Color(25, 25, 25));
        textField3.setForeground(new Color(255, 0, 0));
        textField3.setFont(new Font("MV Boli", Font.BOLD, 30));
        textField3.setBorder(BorderFactory.createBevelBorder(1));
        textField3.setHorizontalAlignment(JTextField.CENTER);
        textField3.setEditable(false);

        wrongAnswer.setBounds(350, 320, 250, 70);   // Add design to wrongAnswer
        wrongAnswer.setBackground(new Color(25, 25, 25));
        wrongAnswer.setForeground(new Color(255, 0, 0));
        wrongAnswer.setFont(new Font("MV Boli", Font.BOLD, 30));
        wrongAnswer.setBorder(BorderFactory.createBevelBorder(1));
        wrongAnswer.setHorizontalAlignment(JTextField.CENTER);
        wrongAnswer.setEditable(false);

        textField4.setBounds(40, 420, 300, 70);   // Add design to textField4
        textField4.setBackground(new Color(25, 25, 25));
        textField4.setForeground(new Color(70, 130, 180));
        textField4.setFont(new Font("MV Boli", Font.BOLD, 30));
        textField4.setBorder(BorderFactory.createBevelBorder(1));
        textField4.setHorizontalAlignment(JTextField.CENTER);
        textField4.setEditable(false);

        percentage.setBounds(350, 420, 250, 70);   // Add design to percentage
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(70, 130, 180));
        percentage.setFont(new Font("MV Boli", Font.BOLD, 30));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        textField5.setBounds(40, 490, 300, 70);   // Add design to textField5
        textField5.setBackground(new Color(25, 25, 25));
        textField5.setForeground(new Color(70, 130, 180));
        textField5.setFont(new Font("MV Boli", Font.BOLD, 30));
        textField5.setBorder(BorderFactory.createBevelBorder(1));
        textField5.setHorizontalAlignment(JTextField.CENTER);
        textField5.setEditable(false);

        status.setBounds(350, 490, 250, 70);   // Add design to status
        status.setBackground(new Color(25, 25, 25));
        status.setForeground(new Color(70, 130, 180));
        status.setFont(new Font("MV Boli", Font.BOLD, 30));
        status.setBorder(BorderFactory.createBevelBorder(1));
        status.setHorizontalAlignment(JTextField.CENTER);
        status.setEditable(false);

        frame.add(textField);   // Add all objects to frame
        frame.add(textArea);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(labelA);
        frame.add(labelB);
        frame.add(labelC);
        frame.add(labelD);
        frame.add(secondsLeft);

        frame.setVisible(true);   // Visible frame
        
        nextQuestion();   // Call nextQuestion() method 
    }

    public void nextQuestion() {
        if(queNumber >= totalQuestions) {
            result();   // Display result when all questions are completed
        }
        else {
            textField.setText("Questions");   // Set a text
            textArea.setText((queNumber+1) + "- " + questions[queNumber]);   // Increment queNumber by 1 & fetch question from questions array
            labelA.setText(options[queNumber][0]);   // Fetch options from options array
            labelB.setText(options[queNumber][1]);
            labelC.setText(options[queNumber][2]);
            labelD.setText(options[queNumber][3]);

            timer.start();   // During a question timer will countdown from 10 seconds
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {   // Button will action performed when clicked
        buttonA.setEnabled(false);   // Make all buttons disabled
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(e.getSource() == buttonA) {   // Match the current button clicked
            if('A' == answers[queNumber]) {   // Increment correctGuess if current button match to 'A'
                correctGuess++;
            }
        }

        if(e.getSource() == buttonB) {
            if('B' == answers[queNumber]) {   // Increment correctGuess if current button match to 'B'
                correctGuess++;
            }
        }

        if(e.getSource() == buttonC) {
            if('C' == answers[queNumber]) {   // Increment correctGuess if current button match to 'C'
                correctGuess++;
            }
        }

        if(e.getSource() == buttonD) {
            if('D' == answers[queNumber]) {   // Increment correctGuess if current button match to 'D'
                correctGuess++;
            }
        }

        displayAnswer();   // Call displayAnswer() method
    }

    public void displayAnswer() {
        timer.stop();   // Timer will countdown from 10 after display the correct answer

        buttonA.setEnabled(false);   // Make all buttons disabled
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[queNumber] != 'A') {   // Set the options to red if current button not match to 'A'
            labelA.setForeground(new Color(70, 130, 180));
        }

        if(answers[queNumber] != 'B') {   // Set the options to red if current button not match to 'B'
            labelB.setForeground(new Color(70, 130, 180));
        }

        if(answers[queNumber] != 'C') {   // Set the options to red if current button not match to 'C'
            labelC.setForeground(new Color(70, 130, 180));
        }

        if(answers[queNumber] != 'D') {   // Set the options to red if current button not match to 'D'
            labelD.setForeground(new Color(70, 130, 180));
        }

        Timer pause = new Timer(1000, new ActionListener() {   // Timer pause
            @Override
            public void actionPerformed(ActionEvent e) {   // Set the options to green when move to the next question
                labelA.setForeground(new Color(25, 255, 0));
                labelB.setForeground(new Color(25, 255, 0));
                labelC.setForeground(new Color(25, 255, 0));
                labelD.setForeground(new Color(25, 255, 0));

                seconds = 10;   // Timer will start from 10 seconds for each question
                secondsLeft.setText(seconds + " seconds left");   // Display timer in dynamically

                buttonA.setEnabled(true);   // Make all buttons enabled
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);

                queNumber++;   // Increment question number

                nextQuestion();   // Call nextQuestion() method
            }
        });

        pause.setRepeats(false);
        pause.start();   // Timer will start from 10 seconds
    }

    public void result() {
        textField.setText("You Scored !!!");   // Set a text in the textField
        message.setText("***Thank you for participating the Quiz***");   // Set an extra text in the message

        buttonA.setVisible(false);   // Make all buttons invisible
        buttonB.setVisible(false);
        buttonC.setVisible(false);
        buttonD.setVisible(false);

        labelA.setText("");   // Make all label options to null
        labelB.setText("");
        labelC.setText("");
        labelD.setText("");

        secondsLeft.setVisible(false);   // Make the timer to invisible

        getscored = (int)((correctGuess/(double)totalQuestions)*100);   // Calculate percentage(%)

        textField1.setText("Total Questions");   // Set a text to textField1
        question.setText(String.valueOf(totalQuestions));   // Set a text to question
        
        textField2.setText("Correct Answers");   // Set a text to textField2
        correctAnswer.setText(String.valueOf(correctGuess));   // Set a text to correctAnswer

        textField3.setText("Wrong Answers");   // Set a text to textField3
        wrongAnswer.setText(String.valueOf(totalQuestions-correctGuess));   // Set a text to wrongAnswer

        textField4.setText("Percentage");   // Set a text to textField4
        percentage.setText(getscored + "%");   // Set a text to percentage

        textField5.setText("Status");   // Set a text to textField5
        if(getscored > 70) {   // Set a text to status
            status.setText("PASS");
        }
        else {
            status.setText("FAIL");
        }

        frame.add(message);   // Add all objects to frame

        frame.add(textField1);
        frame.add(question);

        frame.add(textField2);
        frame.add(correctAnswer);

        frame.add(textField3);
        frame.add(wrongAnswer);

        frame.add(textField4);
        frame.add(percentage);

        frame.add(textField5);
        frame.add(status);

        quizOver();   // Call quizOver() method
    }

    public void quizOver() {
        Object[] option = {"Yes", "No"};   // Choose an option from a pop-up window
        int n = JOptionPane.showOptionDialog(frame, "Do you want to play the Quiz again?", "Quiz",   // Create a pop-up window
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);

        if(n == 0) {   // Restart Quiz
            frame.dispose();
            new quiz();
        }
        else {   // Exit Quiz
            frame.dispose();
        }
    }

    public static void main(String[] args) {
        new quiz();   // Instance of quiz
    }
}