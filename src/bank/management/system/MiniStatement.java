package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    
    MiniStatement(String cardNumber) {
             
        // set window title and absolute positioning
        setTitle("Mini Statement");
        setLayout(null);
        
        // set the frame for the mini statements
        JLabel mini = new JLabel();
        mini.setBounds(20, 110, 400, 400);
        mini.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(mini);
        
        // create a page title
        JLabel bank = new JLabel("CS Bank");
        bank.setBounds(150, 20, 100, 20);
        bank.setFont(new Font("Raleway", Font.BOLD, 24));
        add(bank);
        
        // set the frame for reporting card number
        JLabel card = new JLabel();
        card.setBounds(20, 80, 400, 15);
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        add(card);
        
        // set the frame for reporting the current account balance
        JLabel balance = new JLabel();
        balance.setBounds(20, 500, 400, 20);
        balance.setFont(new Font("Raleway", Font.BOLD, 16));
        add(balance);
        
        
        // report card number in the mini statement
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where cardNumber = '"+cardNumber+"'");
            // only write out the last 4 digits of the card number for privacy
            if (rs.next()) {
                card.setText("Card Number: XXXX-XXXX-XXXX-"+cardNumber.substring(12, 16));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        // report the mini statements
        try {
            Conn c = new Conn();
            int balanceVal = 0;
            int statementCount = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where cardNumber = '"+cardNumber+"'");
            while (rs.next()) {
                if (statementCount >= 10) {
                    JOptionPane.showMessageDialog(null, "Can only display up to 10 statements");
                    break;
                }
                // write out each transaction history
                mini.setText(mini.getText() + "<html>" + " " + rs.getString("date") + "     " + rs.getString("type") + "          " + rs.getString("amount") + "<br><br><html>");
                // calculate the balance based on transaction type (deposit or withdraw)
                if (rs.getString("type").equals("Deposit")) {
                        balanceVal += Integer.parseInt(rs.getString("amount"));
                    } else if (rs.getString("type").equals("Withdraw")){
                        balanceVal -= Integer.parseInt(rs.getString("amount"));
                    }
                statementCount += 1;
            }
            balance.setText("Your current account balance is $" + balanceVal);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        // set the window size, location, and background color
        setSize(400, 600);
        setLocation(450, 30);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String args[]) {
        new MiniStatement("");
    }
    
}
