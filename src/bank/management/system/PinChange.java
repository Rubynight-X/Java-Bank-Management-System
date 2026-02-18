package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField newPin, rePin;
    JButton change, back;
    String cardNumber;
        
    PinChange(String cardNumber) {
        
        this.cardNumber = cardNumber;
                
        // set absolute positioning
        setLayout(null);
        
        // set background image
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image scaledImage = image.getImage().getScaledInstance(870, 780, Image.SCALE_DEFAULT);
        JLabel finalImage = new JLabel(new ImageIcon(scaledImage));
        finalImage.setBounds(0, -30, 870, 680);
        add(finalImage);
        
        
        // text prompt for PIN change
        JLabel text = new JLabel("Change your PIN");
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(255, 240, 300, 30);
        text.setForeground(Color.WHITE);
        finalImage.add(text);
        
        // note for PIN length
        JLabel detail = new JLabel("Must be 4-digit long");
        detail.setFont(new Font("System", Font.BOLD, 14));
        detail.setBounds(264, 270, 400, 20);
        detail.setForeground(Color.WHITE);
        finalImage.add(detail);
        
        
        // text prompt for new PIN
        JLabel pinText = new JLabel("New PIN:");
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(170, 305, 200, 30);
        pinText.setForeground(Color.WHITE);
        finalImage.add(pinText);
        
        // user input for new PIN
        newPin = new JPasswordField();
        newPin.setFont(new Font("Raleway", Font.BOLD, 20));
        newPin.setBounds(345, 310, 140, 25);
        finalImage.add(newPin);
        
        
        // text prompt for re-entering the new PIN
        JLabel repinText = new JLabel("Re-enter new PIN:");
        repinText.setFont(new Font("System", Font.BOLD, 16));
        repinText.setBounds(170, 335, 700, 35);
        repinText.setForeground(Color.WHITE);
        finalImage.add(repinText);
        
        // user input for re-entering the new PIN
        rePin = new JPasswordField();
        rePin.setFont(new Font("Raleway", Font.BOLD, 20));
        rePin.setBounds(345, 340, 140, 25);
        finalImage.add(rePin);
        
        
        // button for change
        change = new JButton("Change");
        change.setBounds(345, 400, 140, 25);
        change.setFont(new Font("System" ,Font.BOLD, 14));
        change.addActionListener(this);
        finalImage.add(change);
        
        // button for back
        back = new JButton("Back");
        back.setBounds(170, 400, 140, 25);
        back.setFont(new Font("System" ,Font.BOLD, 14));
        back.addActionListener(this);
        finalImage.add(back);
        
        
        // set window size and location
        setSize(870, 680);
        setLocation(210, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        // actions taken if the change button is clicked
        if (ae.getSource() == change) {
            try {
                // store the user input PIN into variables
                String npin = newPin.getText();
                String rpin = rePin.getText();
                
                // if the PINs do not match, give an error message
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                // if the PIN is not 4-digit long, give an error message
                if (npin.length() != 4 || rpin.length() != 4) {
                    JOptionPane.showMessageDialog(null, "PIN must be 4-digit long");
                    return;
                }
                                  
                
                // connect with database and update the new PIN in bank, login, and signupthree tables using SQL commands
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from login where cardNumber = '"+cardNumber+"'");
                String pinNumber = "";
                if (rs.next()) {
                    pinNumber = rs.getString("pin");
                }
                String query1 = "update login set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
                String query2 = "update signupthree set pinNumber = '"+rpin+"' where pinNumber = '"+pinNumber+"'";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                // show a message after successful pin change
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                
                setVisible(false);
                new Transactions(cardNumber).setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == back) {
            // if the back button is clicked, switch back to the transaction page
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new PinChange("");
    }
    
}
