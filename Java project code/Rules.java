package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{

    String name;
    JButton start_btn, back_btn;
    
    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome " + name + " to Simple Minds");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
            "<html>"+ 
                "1. All questions are compulsory." + "<br><br>" +
                "2. There are only 15 Seconds for each question." + "<br><br>" +
                "3. The quiz consists of multiple-choice questions" + "<br><br>" +
                "4. candidate gets 10 marks for every correct answer and 0 for inncorrect" + "<br><br>" +
                "5. Each questions appears for only 15 sec on screen" + "<br><br>" +
                "6. There are no negative marking " + "<br><br>" +
                "7. Do not open any tab or press back_btn button" + "<br><br>" +
                
            "<html>"
        );
        add(rules);
        
        back_btn = new JButton("Back");
        back_btn.setBounds(250, 500, 100, 30);
        back_btn.setBackground(new Color(30, 144, 254));
        back_btn.setForeground(Color.WHITE);
        back_btn.addActionListener(this);
        add(back_btn);
        
        start_btn = new JButton("Start");
        start_btn.setBounds(400, 500, 100, 30);
        start_btn.setBackground(new Color(30, 144, 254));
        start_btn.setForeground(Color.WHITE);
        start_btn.addActionListener(this);
        add(start_btn);
        
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start_btn) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args) {
        new Rules("User");
    }
}

