package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Withdraw extends JFrame implements ActionListener{
    String cardNumber;
    JTextField amount;
    JButton withdraw, back;
    
    Withdraw(String cardNumber) {
        
        this.cardNumber = cardNumber;
        
        // set absolute positioning
        setLayout(null);
        
        // set background image
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image scaledImage = image.getImage().getScaledInstance(870, 780, Image.SCALE_DEFAULT);
        JLabel finalImage = new JLabel(new ImageIcon(scaledImage));
        finalImage.setBounds(0, -30, 870, 680);
        add(finalImage);  
               
        
        // text prompt for the withdrawal amount
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(180, 230, 400, 30);
        finalImage.add(text);
        
        // user input for the withdrawal amount
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 20));
        amount.setBounds(180, 270, 290, 25);
        finalImage.add(amount);
        
        
        // button for withdraw
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(330, 370, 140, 25);
        withdraw.setFont(new Font("System" ,Font.BOLD, 14));
        withdraw.addActionListener(this);
        finalImage.add(withdraw);
        
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
        // actions taken if the withdraw button is clicked
        if (ae.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();
            // if the amount is empty, give an error message
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            } else {
                try {
                    // among all rows in the bank table, retrieve all transactions with the same pin number
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bank where cardNumber = '"+cardNumber+"'");
                    int balance = 0;
                    
                    while (rs.next()) {                     
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else if (rs.getString("type").equals("Withdraw")){
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }   
                    
                    if (balance < Integer.parseInt(amount.getText())) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    
                    // update the database with new withdrawal information using SQL commands
                    String query = "insert into bank values ('"+cardNumber+"', '"+date+"', 'Withdraw', '"+number+"')";
                    c.s.executeUpdate(query);
                    // show a message after successful withdrawal and switch to the transaction page
                    JOptionPane.showMessageDialog(null, "$"+number+" Withdrawn Successfully");
                    setVisible(false);
                    new Transactions(cardNumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            }
        } else if (ae.getSource() == back) {
            // if the back button is clicked, switch back to the transaction page
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
        }
    }
        
    public static void main(String args[]) {
        new Withdraw("");
        
    }
    
}

