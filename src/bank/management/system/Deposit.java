package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    String cardNumber;
    JTextField amount;
    JButton deposit, back;
    
    Deposit(String cardNumber) {
        
        this.cardNumber = cardNumber;
        
        // set absolute positioning
        setLayout(null);
        
        // set background image
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image scaledImage = image.getImage().getScaledInstance(870, 780, Image.SCALE_DEFAULT);
        JLabel finalImage = new JLabel(new ImageIcon(scaledImage));
        finalImage.setBounds(0, -30, 870, 680);
        add(finalImage);  
               
        
        // text prompt for the deposit amount
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(180, 230, 400, 30);
        finalImage.add(text);
        
        // user input for deposit amount
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 20));
        amount.setBounds(180, 270, 290, 25);
        finalImage.add(amount);
        
        
        // button for deposit
        deposit = new JButton("Deposit");
        deposit.setBounds(330, 370, 140, 25);
        deposit.setFont(new Font("System" ,Font.BOLD, 14));
        deposit.addActionListener(this);
        finalImage.add(deposit);
        
        // button for back
        back= new JButton("Back");
        back.setBounds(330, 400, 140, 25);
        back.setFont(new Font("System" ,Font.BOLD, 14));
        back.addActionListener(this);
        finalImage.add(back);

        
        // set window size and location
        setSize(870, 680);
        setLocation(210, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        // actions taken if the deposit button is clicked
        if (ae.getSource() == deposit) {
            String number = amount.getText();
            Date date = new Date();
            // if the amount is empty, give an error message
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
                try {
                    // update the database with new deposit information using SQL commands
                    Conn c = new Conn();
                    String query = "insert into bank values ('"+cardNumber+"', '"+date+"', 'Deposit', '"+number+"')";
                    c.s.executeUpdate(query);
                    // show a message after successful deposit and switch to the transaction page
                    JOptionPane.showMessageDialog(null, "$"+number+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(cardNumber).setVisible(true);
                    
                } catch (Exception e) {
                    System.out.println(e);
                }  
            }
        } else if (ae.getSource() == back) {
            // if the back button is clicked, switch to the transaction page
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
        }
    }
        
    public static void main(String args[]) {
        new Deposit("");
        
    }
    
}
