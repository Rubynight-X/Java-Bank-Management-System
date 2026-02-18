package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit, withdraw, miniStatement, pinChange, fastCash, balance, exit;
    String cardNumber;
    
    Transactions(String cardNumber) {
        
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
        JLabel text = new JLabel("Please select your transaction");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(210, 240, 700, 35);
        text.setForeground(Color.WHITE);
        finalImage.add(text);
        
        
        // button for deposit
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 310, 140, 25);
        deposit.setFont(new Font("System" ,Font.BOLD, 14));
        deposit.addActionListener(this);
        finalImage.add(deposit);
        
        // button for withdraw
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(345, 310, 140, 25);
        withdraw.setFont(new Font("System" ,Font.BOLD, 14));
        withdraw.addActionListener(this);
        finalImage.add(withdraw);
        
        // button for fast cash
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170, 340, 140, 25);
        fastCash.setFont(new Font("System" ,Font.BOLD, 14));
        fastCash.addActionListener(this);
        finalImage.add(fastCash);
        
        // button for mini statement
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(345, 340, 140, 25);
        miniStatement.setFont(new Font("System" ,Font.BOLD, 14));
        miniStatement.addActionListener(this);
        finalImage.add(miniStatement);
        
        // button for PIN change
        pinChange = new JButton("PIN Change");
        pinChange.setBounds(170, 370, 140, 25);
        pinChange.setFont(new Font("System" ,Font.BOLD, 14));
        pinChange.addActionListener(this);
        finalImage.add(pinChange);
        
        // button for checking balance
        balance = new JButton("Balance");
        balance.setBounds(345, 370, 140, 25);
        balance.setFont(new Font("System" ,Font.BOLD, 14));
        balance.addActionListener(this);
        finalImage.add(balance);
        
        // button for exiting the page
        exit = new JButton("Exit");
        exit.setBounds(345, 400, 140, 25);
        exit.setFont(new Font("System" ,Font.BOLD, 14));
        exit.addActionListener(this);
        finalImage.add(exit);
        
        // set window size and location
        setSize(870, 680);
        setLocation(210, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        // if a certain button (other than exit) is clicked, switch to the corresponding window and class
        if (ae.getSource() == exit) {
            // if the exit button is clicked, exit the window
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(cardNumber).setVisible(true);
        } else if (ae.getSource() == withdraw) {
            setVisible(false); 
            new Withdraw(cardNumber).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(cardNumber).setVisible(true);
        } else if (ae.getSource() == miniStatement) {
            new MiniStatement(cardNumber).setVisible(true);
        } else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(cardNumber).setVisible(true);
        } else if (ae.getSource() == balance) {
            setVisible(false);
            new Balance(cardNumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Transactions("");
    }
}
