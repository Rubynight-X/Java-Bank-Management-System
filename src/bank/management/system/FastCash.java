package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton ten, twenty, thirty, fifty, eighty, hundred, back;
    String cardNumber;
    
    FastCash(String cardNumber) {
        
        this.cardNumber = cardNumber;
        
        // set absolute positioning
        setLayout(null);
            
        // set the background image and scale as needed
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image scaledImage = image.getImage().getScaledInstance(870, 780, Image.SCALE_DEFAULT);
        JLabel finalImage = new JLabel(new ImageIcon(scaledImage));
        finalImage.setBounds(0, -30, 870, 680);
        add(finalImage);
        
        
        // text prompt for transaction
        JLabel text = new JLabel("Selected withdrawal amount");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(220, 240, 700, 35);
        text.setForeground(Color.WHITE);
        finalImage.add(text);
        
        
        // button for deposit
        ten = new JButton("$10");
        ten.setBounds(170, 310, 140, 25);
        ten.setFont(new Font("System" ,Font.BOLD, 14));
        ten.addActionListener(this);
        finalImage.add(ten);
        
        // button for withdraw
        twenty = new JButton("$20");
        twenty.setBounds(345, 310, 140, 25);
        twenty.setFont(new Font("System" ,Font.BOLD, 14));
        twenty.addActionListener(this);
        finalImage.add(twenty);
        
        // button for fast cash
        thirty = new JButton("$30");
        thirty.setBounds(170, 340, 140, 25);
        thirty.setFont(new Font("System" ,Font.BOLD, 14));
        thirty.addActionListener(this);
        finalImage.add(thirty);
        
        // button for mini statement
        fifty = new JButton("$50");
        fifty.setBounds(345, 340, 140, 25);
        fifty.setFont(new Font("System" ,Font.BOLD, 14));
        fifty.addActionListener(this);
        finalImage.add(fifty);
        
        // button for PIN change
        eighty = new JButton("$80");
        eighty.setBounds(170, 370, 140, 25);
        eighty.setFont(new Font("System" ,Font.BOLD, 14));
        eighty.addActionListener(this);
        finalImage.add(eighty);
        
        // button for checking balance
        hundred = new JButton("$100");
        hundred.setBounds(345, 370, 140, 25);
        hundred.setFont(new Font("System" ,Font.BOLD, 14));
        hundred.addActionListener(this);
        finalImage.add(hundred);
        
        // button for exiting the page
        back = new JButton("Back");
        back.setBounds(345, 400, 140, 25);
        back.setFont(new Font("System" ,Font.BOLD, 14));
        back.addActionListener(this);
        finalImage.add(back);
        
        // set window size and location
        setSize(870, 680);
        setLocation(210, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            // if the exit button is clicked, exit the window
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
        } else {
            // store the numerical value into the amount variable
            String amount = ((JButton) ae.getSource()).getText().substring(1);
            Conn c = new Conn();
            try {
                // select all rows with the same given PIN
                ResultSet rs = c.s.executeQuery("select * from bank where cardNumber = '"+cardNumber+"'");
                int balance = 0;
                
                // add or subtract values to the balance based on type of transaction (deposit and withdraw)
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else if (rs.getString("type").equals("Withdraw")){
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            
                // if the amount withdrawn is larger than the balance, give an error message
                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                 
                // update the database with new withdrawal information using SQL commands
                Date date = new Date();
                String query = "insert into bank values ('"+cardNumber+"', '"+date+"', 'Withdraw', '"+amount+"')";
                c.s.executeUpdate(query);
                // show a message after the transaction is successful
                JOptionPane.showMessageDialog(null, "$"+amount+" Withdrawn Successfully");

               
                setVisible(false);
                new Transactions(cardNumber).setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
    }
    
    public static void main(String args[]) {
        new FastCash( "");
    }
}