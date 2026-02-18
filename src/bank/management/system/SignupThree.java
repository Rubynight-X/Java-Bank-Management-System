package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {
    
    String formNumber;
    JRadioButton savings, chequing, joint, moneyMarket, cd, student;
    JCheckBox atm, online, mobile, chequeBook, agreement;
    JButton previous, submit, cancel;
    
    SignupThree(String formNumber) {
        this.formNumber = formNumber;
        
        // set window title and absolute positioning
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        setLayout(null);
        
        
        // create a page title
        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Baleway", Font.BOLD, 27));
        accountDetails.setBounds(300, 35, 400, 40);
        add(accountDetails);
        
        JLabel titleNote = new JLabel("*Returning to page 1 clears all data entry and generates a new form");
        titleNote.setFont(new Font("Raleway", Font.BOLD, 15));
        titleNote.setForeground(Color.red);
        titleNote.setBounds(210,80, 500, 16);
        add(titleNote); 
        
        
        // text prompt for account type
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Baleway", Font.BOLD, 20));
        type.setBounds(100, 120, 200, 30);
        add(type);
        
        // option for saving account
        savings = new JRadioButton("Savings Account");
        savings.setFont(new Font("Raleway", Font.BOLD, 16));
        savings.setBackground(Color.WHITE);
        savings.setBounds(100, 160, 220, 30);
        add(savings);
        // option for chequing account
        chequing = new JRadioButton("Chequing Account");
        chequing.setFont(new Font("Raleway", Font.BOLD, 16));
        chequing.setBackground(Color.WHITE);
        chequing.setBounds(370, 160, 220, 30);
        add(chequing);
        // option for join account
        joint = new JRadioButton("Joint Account");
        joint.setFont(new Font("Raleway", Font.BOLD, 16));
        joint.setBackground(Color.WHITE);
        joint.setBounds(620, 160, 220, 30);
        add(joint);
        // option for money market account
        moneyMarket = new JRadioButton("Money Market Account");
        moneyMarket.setFont(new Font("Raleway", Font.BOLD, 16));
        moneyMarket.setBackground(Color.WHITE);
        moneyMarket.setBounds(100, 210, 220, 30);
        add(moneyMarket);
        // option for certificate of deposit
        cd = new JRadioButton("Certificate of Deposit");
        cd.setFont(new Font("Raleway", Font.BOLD, 16));
        cd.setBackground(Color.WHITE);
        cd.setBounds(370, 210, 220, 30);
        add(cd);
        // option for student account
        student = new JRadioButton("Student Account");
        student.setFont(new Font("Raleway", Font.BOLD, 16));
        student.setBackground(Color.WHITE);
        student.setBounds(620, 210, 220, 30);
        add(student);
        
        // group the options so that only one option can be selected at a time
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(savings);
        accountGroup.add(chequing);
        accountGroup.add(joint);
        accountGroup.add(moneyMarket);
        accountGroup.add(cd);
        accountGroup.add(student);
        
        
        // text prompt for card number
        JLabel cardNumber = new JLabel("Card Number:");
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        cardNumber.setBounds(100, 280, 200, 30);
        add(cardNumber);
        
        // text prompt for card number format
        JLabel number = new JLabel("XXXX-XXXX-XXXX-XXXX");
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        number.setBounds(330, 280, 300, 30);
        add(number);
        
        JLabel cardDetail = new JLabel("Your 16-Digit Card Number");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBounds(100, 310, 300, 20);
        add(cardDetail);
        
        
        // text prompt for PIN
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 350, 200, 30);
        add(pin);
        
        // text prompt for PIN format
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        pinNumber.setBounds(330, 350, 300, 30);
        add(pinNumber);
        
        JLabel pinDetail = new JLabel("Your 4-Digit Password");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetail.setBounds(100, 380, 300, 20);
        add(pinDetail);
                
        
        // text prompt for required services
        JLabel service = new JLabel("Services Required:");
        service.setFont(new Font("Raleway", Font.BOLD, 20));
        service.setBounds(100, 430, 200, 30);
        add(service);
        
        // option for ATM banking
        atm = new JCheckBox("ATM Banking");
        atm.setBackground(Color.WHITE);
        atm.setFont(new Font("Raleway", Font.BOLD, 16));
        atm.setBounds(100, 480, 200, 30);
        add(atm);
        // option for online banking
        online = new JCheckBox("Online Banking");
        online.setBackground(Color.WHITE);
        online.setFont(new Font("Raleway", Font.BOLD, 16));
        online.setBounds(290, 480, 200, 30);
        add(online);
        // option for mobile banking
        mobile = new JCheckBox("Mobile Banking");
        mobile.setBackground(Color.WHITE);
        mobile.setFont(new Font("Raleway", Font.BOLD, 16));
        mobile.setBounds(480, 480, 200, 30);
        add(mobile);
        // option for cheque book
        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setFont(new Font("Raleway", Font.BOLD, 16));
        chequeBook.setBounds(670, 480, 300, 30);
        add(chequeBook);       
        
        
        // check box for agreement
        agreement = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
        agreement.setBackground(Color.WHITE);
        agreement.setFont(new Font("Raleway", Font.BOLD, 16));
        agreement.setBounds(100, 530, 700, 20);
        add(agreement);
        
        
        // create a previous button to go back to page 1
        previous = new JButton("<Previous");
        previous.setFont(new Font("Raleway", Font.BOLD, 18));
        previous.setBounds(370, 580, 130, 35);
        previous.setBackground(Color.BLUE);
        previous.setForeground(Color.WHITE);
        previous.addActionListener(this);
        add(previous);        
                
        // create a sumbit button to submit and update data in database
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 20));
        submit.setBounds(555, 580, 120, 35);
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        // create a cancel button to clear page
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 20));
        cancel.setBounds(730, 580, 120, 35);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        
        // set window background color, window size, and window location
        getContentPane().setBackground(Color.WHITE);
        setSize(920, 680);
        setLocation(190, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        // actions taken if the submit button is clicked
        if (ae.getSource() == submit) {
            String accountType = "";
            if (savings.isSelected()) {
                accountType = "Savings Account";
            } else if (chequing.isSelected()) {
                accountType = "Chequing Account";
            } else if (joint.isSelected()) {
                accountType = "Joint Account";
            } else if (moneyMarket.isSelected()) {
                accountType = "Money Market Account";
            } else if (cd.isSelected()) {
                accountType = "Certificate of Deposit";
            } else if (student.isSelected()) {
                accountType = "Student Account";
            }
            
            // generate a random 16-digit number as the card number and a 4-digit number as the PIN 
            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 1000000000000000L) + 4000000000000000L);
            String pinNumber = "" + (1000 + random.nextInt(9000));
            
            String facility = "";
            if (atm.isSelected()) {
                facility += "ATMBanking ";
            }
            if (online.isSelected()) {
                facility += "OnlineBanking ";
            }
            if (mobile.isSelected()) {
                facility += "MobileBanking ";
            }
            if (chequeBook.isSelected()) {
                facility += "ChequeBook ";
            }
            
            
            try {
                // give an error message if accountType is empty 
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is required");
                } else {
                    // update the database with new user information using SQL commands
                    Conn c = new Conn();
                    // create two new tables: one for storing data from page 3, the other for login info including form number, card number, and PIN
                    String query = "insert into signupthree values ('"+formNumber+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
                    String query2 = "insert into login values ('"+formNumber+"', '"+cardNumber+"', '"+pinNumber+"')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);
                    
                    // display the generated card number and PIN in a pop up window
                    JOptionPane.showMessageDialog(null, "Card Number " + cardNumber + "\n Pin: " + pinNumber);
                
                    setVisible(false);
                    new Deposit(cardNumber).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
        } else if (ae.getSource() == previous) {
            // if the previous button is clicked, go back to page 2, but all data entry will be cleared
            setVisible(false);
            new SignupTwo(formNumber).setVisible(true);
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new SignupThree("");
    }
}
