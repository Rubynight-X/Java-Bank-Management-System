package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Balance extends JFrame implements ActionListener {
    
    String cardNumber;
    JButton back;
    
    Balance(String cardNumber) {

        this.cardNumber = cardNumber;
        
        // set absolute positioning
        setLayout(null);
        
        // set background image
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image scaledImage = image.getImage().getScaledInstance(870, 780, Image.SCALE_DEFAULT);
        JLabel finalImage = new JLabel(new ImageIcon(scaledImage));
        finalImage.setBounds(0, -30, 870, 680);
        add(finalImage);
        
        
        // button for back
        back = new JButton("Back");
        back.setBounds(345, 400, 140, 25);
        back.setFont(new Font("System" ,Font.BOLD, 14));
        back.addActionListener(this);
        finalImage.add(back);
        
        
        // retrieve data from the bank table in database to calculate the total balance
        int balance = 0;
        Conn c = new Conn();
        try {
            // select all rows with the same given PIN
            ResultSet rs = c.s.executeQuery("select * from bank where cardNumber = '"+cardNumber+"'");
               
            // add or subtract values to the balance based on type of transaction (deposit and withdraw)
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else if (rs.getString("type").equals("Withdraw")){
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
                System.out.println(e);
        }
        
        
        // text prompt for the current account balance
        JLabel text = new JLabel("Your current account balance is");
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(185, 240, 500, 30);
        text.setForeground(Color.WHITE);
        finalImage.add(text);
        
        // text to show the account balance
        JLabel amount = new JLabel("$" + balance);
        amount.setFont(new Font("System", Font.BOLD, 24));
        amount.setBounds(280, 280, 500, 35);
        amount.setForeground(Color.WHITE);
        finalImage.add(amount);
        
        
        // set window size and location
        setSize(870, 680);
        setLocation(210, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        // if the back button is clicked, switch back to the transaction page
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Balance("");
    }
    
}
