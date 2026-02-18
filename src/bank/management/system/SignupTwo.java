
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    String formNumber;
    JButton next, previous;
    JRadioButton yes, no;
    JComboBox incomeList, educationList, occupationList, statusList;
    
    SignupTwo(String formNumber) {
        this.formNumber = formNumber;
        
        // set layout to absolte positioning and set window title
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
  
        
        // create a page title
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 27));
        additionalDetails.setBounds(270, 40, 400, 30);
        add(additionalDetails); 
        
        JLabel titleNote = new JLabel("*Returning to page 1 clears all data entry and generates a new form");
        titleNote.setFont(new Font("Raleway", Font.BOLD, 15));
        titleNote.setForeground(Color.red);
        titleNote.setBounds(185, 80, 500, 20);
        add(titleNote); 
   
        
        // text prompt for income
        JLabel income = new JLabel("Annual income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 140, 200, 30);
        add(income);   
        
        // drop down list for income range options 
        String valIncome[] = {"< 30k", "< 60k", "< 90k", "< 120k", "< 150k", "< 200k", ">= 200k"};
        incomeList = new JComboBox(valIncome);
        incomeList.setBounds(370, 140, 400, 30);
        add(incomeList);        
        
        
        // text prompt for date of education
        JLabel education = new JLabel("Education:");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 220, 200, 30);
        add(education);  
        
        // drop down list for education options
        String valEducation[] = {"Null", "Elementary", "Secondary", "Associate", "Bachelor", "Master", "Doctoral", "Others"};
        educationList = new JComboBox(valEducation);
        educationList.setBounds(370, 220, 400, 30);
        add(educationList);
        
        
        // text prompt for occupations
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 300, 200, 30);
        add(occupation); 
        
        // drop down list for occuaption options
        String valOccupation[] = {"Student", "Salaried", "Self-Employed", "Bussiness", "Retired", "Others"};
        occupationList = new JComboBox(valOccupation);
        occupationList.setBounds(370, 300, 400, 30);
        add(occupationList);
  
        
        // text prompt for legal status
        JLabel status = new JLabel("Legal Status:");
        status.setFont(new Font("Raleway", Font.BOLD, 20));
        status.setBounds(100, 380, 200, 30);
        add(status);   
        
        // drop down list for legal status options
        String valStatus[] = {"Student", "Visitor", "Worker", "Refugee", "Diplomatic", "Permanent Resident", "Canadian Citizen"};
        statusList = new JComboBox(valStatus);
        statusList.setBounds(370, 380, 400, 30);
        add(statusList);   
        
        
        // text prompt for an existing account
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 460, 200, 30);
        add(existingAccount);  
        
        // option for yes - account exists
        yes = new JRadioButton("Yes");
        yes.setBounds(370, 460, 100, 30);
        yes.setBackground(Color.WHITE);
        add(yes);
        // option for no - account does not exist
        no = new JRadioButton("No");
        no.setBounds(520, 460, 100, 30);
        no.setBackground(Color.WHITE);
        add(no);
        
        // group the options so only one option can be selected at a time
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(yes);
        accountGroup.add(no);
        
        
        // create a next button to change page
        next = new JButton("Next>");
        next.setFont(new Font("Raleway", Font.BOLD, 18));
        next.setBounds(680, 520, 100, 40);
        next.addActionListener(this);
        add(next);
        
        // create a previous button to go back to page 1
        previous = new JButton("<Previous");
        previous.setFont(new Font("Raleway", Font.BOLD, 18));
        previous.setBounds(500, 520, 130, 40);
        previous.addActionListener(this);
        add(previous);
        
        // set window background color, size, location
        // make all texts and components visible
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 650);
        setLocation(220, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        // actions to take if the next button is clicked
        if (ae.getSource() == next) {
            String strIncome = (String) incomeList.getSelectedItem();
            String strEducation = (String) educationList.getSelectedItem();
            String strOccupation = (String) occupationList.getSelectedItem();
            String strStatus = (String) statusList.getSelectedItem();
            String existingAccount = null;
            if (yes.isSelected()) {
                existingAccount = "Yes";
            } else if (no.isSelected()) {
                existingAccount = "No";
            }


            try {
                // update the database with new user information using SQL command
                // note information in page 2 is stored in a different table than the information in page 1
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formNumber+"', '"+strIncome+"', '"+strEducation+"', '"+strOccupation+"', '"+strStatus+"', '"+existingAccount+"')";
                c.s.executeUpdate(query);

                // hide the current window and create the third page window
                setVisible(false);
                new SignupThree(formNumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == previous) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }      
    }
    
    
    public static void main(String args[]) {
        new SignupTwo("");
    }
}