package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String ans_from_user[][] = new String[10][1];
    JLabel question_no, question;
    JRadioButton option1, option2, option3, option4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int users_score = 0;
    
    String name;
    
    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        question_no = new JLabel();
        question_no.setBounds(100, 450, 50, 30);
        question_no.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question_no);
        
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);
        
        questions[0][0] = "What is the use of final keyword in Java?";
        questions[0][1] = "When a variable is final, it can be assigned value only once.";
        questions[0][2] = "All of the above"; 
        questions[0][3] = "When a method is final, it cannot be overridden.";
        questions[0][4] = "When a class is made final, a subclass of it cannot be created.";

        questions[1][0] = "How to declare a abstract method?";
        questions[1][1] = "public abstract void method();";
        questions[1][2] = "public void abstract method()";
        questions[1][3] = "public void method();";
        questions[1][4] = "public void abstract method();";

        questions[2][0] = "Abstract class is used,";
        questions[2][1] = "When it doesn't make sense to have objects of that class.";
        questions[2][2] = "When default implementations of some methods are not desirable.";
        questions[2][3] = "To force developers to extend the class not to use its capabilities.";
        questions[2][4] = "To prevent developers from further extending the class.";

        questions[3][0] = "A class cannot be,";
        questions[3][1] = "public and abstract";
        questions[3][2] = "abstract and static";
        questions[3][3] = "abstract and final";
        questions[3][4] = "public and static";

        questions[4][0] = "How many types of polymorphism are there?";
        questions[4][1] = "1";
        questions[4][2] = "3";
        questions[4][3] = "4";
        questions[4][4] = "2";

        questions[5][0] = "Which of the following is a type of polymorphism in Java programming?";
        questions[5][1] = "Multilevel polymorphism";
        questions[5][2] = "Compile time polymorphism";
        questions[5][3] = "Execution time polymorphism";
        questions[5][4] = "Multiple polymorphism";

        questions[6][0] = "CompileTime Polymorphism can be achieved through";
        questions[6][1] = "Method Overloading";
        questions[6][2] = "Up casting"; 
        questions[6][3] = "Inheriting";
        questions[6][4] = "Method Onerriding";

        questions[7][0] = "Which of the following classes is a checked exception?";
        questions[7][1] = "java.lang.RuntimeException";
        questions[7][2] = "java.text.ParseException";
        questions[7][3] = "java.lang.IllegalStateException";
        questions[7][4] = "java.lang.Error";

        questions[8][0] = "Which exception will the following statement generate? int array[] = new int[-2];";
        questions[8][1] = "NegativeArraySizeException";
        questions[8][2] = "NullPointerException";
        questions[8][3] = "ArrayIndexOutOfBoundsException";
        questions[8][4] = "The statement executes without any exception";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";
        
        answers[0][1] = "All of the above";
        answers[1][1] = "public abstract void method();";
        answers[2][1] = "When it doesn't make sense to have objects of that class.";
        answers[3][1] = "abstract and final";
        answers[4][1] = "2";
        answers[5][1] = "Compile time polymorphism";
        answers[6][1] = "Method Overloading";
        answers[7][1] = "java.text.ParseException";
        answers[8][1] = "NegativeArraySizeException";
        answers[9][1] = "Bytecode is executed by JVM";
        
        option1 = new JRadioButton();
        option1.setBounds(170, 520, 700, 30);
        option1.setBackground(Color.WHITE);
        option1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(option1);
        
        option2 = new JRadioButton();
        option2.setBounds(170, 560, 700, 30);
        option2.setBackground(Color.WHITE);
        option2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(option2);
        
        option3 = new JRadioButton();
        option3.setBounds(170, 600, 700, 30);
        option3.setBackground(Color.WHITE);
        option3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(option3);
        
        option4 = new JRadioButton();
        option4.setBounds(170, 640, 700, 30);
        option4.setBackground(Color.WHITE);
        option4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(option4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(option1);
        groupoptions.add(option2);
        groupoptions.add(option3);
        groupoptions.add(option4);
        
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
            option4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               ans_from_user[count][0] = "";
            } else {
                ans_from_user[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                option2.setEnabled(false);
                option3.setEnabled(false);
            } else {
                option1.setEnabled(false);
                option4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                ans_from_user[count][0] = "";
            } else {
                ans_from_user[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < ans_from_user.length; i++) {
                if (ans_from_user[i][0].equals(answers[i][1])) {
                    users_score += 10;
                } else {
                    users_score += 0;
                }
            }
            setVisible(false);
            new Score(name, users_score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        if (timer > 0) { 
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }
        
        timer--; // 14
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
            option4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   ans_from_user[count][0] = "";
                } else {
                    ans_from_user[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < ans_from_user.length; i++) {
                    if (ans_from_user[i][0].equals(answers[i][1])) {
                        users_score += 10;
                    } else {
                        users_score += 0;
                    }
                }
                setVisible(false);
                new Score(name, users_score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   ans_from_user[count][0] = "";
                } else {
                    ans_from_user[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }
        
    }
    
    public void start(int count) {
        question_no.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        option1.setText(questions[count][1]);
        option1.setActionCommand(questions[count][1]);
        
        option2.setText(questions[count][2]);
        option2.setActionCommand(questions[count][2]);
        
        option3.setText(questions[count][3]);
        option3.setActionCommand(questions[count][3]);
        
        option4.setText(questions[count][4]);
        option4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz("User");
    }
}