package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login() {
        // set window title, window size, absolute positioning
        setTitle("AUTOMATED TELLER MACHINE");
        setSize(900, 550);
        setLayout(null);
        
        
        // customize the background image
        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("icons/background.jpg"));
        Image scaledBg = background.getImage().getScaledInstance(960, 560, Image.SCALE_DEFAULT);
        JLabel bgLabel = new JLabel(new ImageIcon(scaledBg));
        bgLabel.setBounds(-15, -25, 900, 550);
        add(bgLabel);
     
        
        // add a welcoming text
        JLabel text = new JLabel("Welcome to CS ATM");
        text.setFont(new Font("Osward", Font.BOLD, 46));
        text.setForeground(Color.WHITE);
        text.setBounds(385, 100, 500, 40);
        bgLabel.add(text);
        
        // add a text prompt for card number
        JLabel cardNumber = new JLabel("Card No. :");
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 30));
        cardNumber.setForeground(Color.WHITE);
        cardNumber.setBounds(390, 210, 150, 40);
        bgLabel.add(cardNumber);
        
        // add a text field to ask for user input card number
        cardTextField = new JTextField();
        cardTextField.setBounds(550, 215, 280, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 16));
        bgLabel.add(cardTextField);
        
        // add a text prompt for PIN
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 30));
        pin.setForeground(Color.WHITE);
        pin.setBounds(390, 290, 250, 40);
        bgLabel.add(pin);
        
        //add a text field to ask for user input pin
        pinTextField = new JPasswordField();
        pinTextField.setBounds(550, 295, 160, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 16));
        bgLabel.add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(390, 390, 120, 40);
        login.addActionListener(this);
        bgLabel.add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(550, 390, 120, 40);
        clear.addActionListener(this);
        bgLabel.add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(710, 390, 120, 40);
        signup.addActionListener(this);
        bgLabel.add(signup);
       
        
        // make all components visible on window and set window position on screen
        setVisible(true);
        setLocation(200, 80);
    }
    
    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == clear) {
            // if the clear button is clicked, empty the text field
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ac.getSource() == login) {
            // if the login in button is clicked, check if card number and PIN match with those in the database
            Conn c = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where cardNumber = '"+cardNumber+"' and pin = '"+pinNumber+"'";
            try {
                // retrieve the row where card number and PIN are the same as the inputs
                ResultSet rs = c.s.executeQuery(query);
                // if such row exists, meaning correct card number and PIN, then switch to the transaction page
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(cardNumber).setVisible(true);
                } else {
                    // if no such exists, give an error message
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ac.getSource() == signup) {
            // if the signup button is clicked, switch to the application form page 1
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Login();
    }
}
