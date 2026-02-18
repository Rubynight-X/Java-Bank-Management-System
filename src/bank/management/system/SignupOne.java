package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField, emailTextField, addressTextField, pcTextField;
    JButton next;
    JRadioButton male, female, others, married, single, other;
    JDateChooser dateChooser;
    JComboBox provinceList;
    
    SignupOne() {
        // set layout to absolte positioning
        setLayout(null);
        
        // generate a random application number between 0 and 9999 inclusive
        Random rand = new Random();
        random = Math.abs((rand.nextLong() % 9000L) + 1000L);
        
        // display the application number on the page
        JLabel formNumber = new JLabel("APPLICATION FORM NO. " + random);
        formNumber.setFont(new Font("Raleway", Font.BOLD, 38));
        formNumber.setBounds(140, 20, 600, 40);
        add(formNumber);
        
        
        // create a page title
        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails); 
        
        
        // text prompt for name
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);         
        
        // user input for name
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        
        // text prompt for date of birthday
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 190, 200, 30);
        add(dob);       
        
        // create a dateChoose object to input date from a calender
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 190, 400, 30);
        add(dateChooser);
        
        
        // text prompt for gender
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 240, 100, 30);
        add(gender);   
        
        // option for male
        male = new JRadioButton("Male");
        male.setBounds(300, 240, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        // opion for female
        female = new JRadioButton("Female");
        female.setBounds(450, 240, 80, 30);
        female.setBackground(Color.WHITE);
        add(female);
        // option for others
        others = new JRadioButton("Others");
        others.setBounds(620, 240, 80, 30);
        others.setBackground(Color.WHITE);
        add(others);
        
        // group the options so only one option can be selected at a time
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(others);
        
        
        // text prompt for email address
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 290, 200, 30);
        add(email);       
        
        // user input for email address
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 290, 400, 30);
        add(emailTextField);
        
        
        // text prompt for marital status
        JLabel marry = new JLabel("Marital Status:");
        marry.setFont(new Font("Raleway", Font.BOLD, 20));
        marry.setBounds(100, 340, 200, 30);
        add(marry); 
        
        // option for married
        married = new JRadioButton("Married");
        married.setBounds(300, 340, 80, 30);
        married.setBackground(Color.WHITE);
        add(married);
        // option for single
        single = new JRadioButton("Single");
        single.setBounds(450, 340, 80, 30);
        single.setBackground(Color.WHITE);
        add(single);
        // option for others
        other = new JRadioButton("Others");
        other.setBounds(620, 340, 80, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        // group the options so only one option can be selected at a time
        ButtonGroup marrygroup = new ButtonGroup();
        marrygroup.add(married);
        marrygroup.add(single);
        marrygroup.add(other);
        
        
        // text prompt for address
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 390, 200, 30);
        add(address);   
        
        // user input for address
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 390, 400, 30);
        add(addressTextField);
        
        
        // text prompt for province
        JLabel province = new JLabel("Province:");
        province.setFont(new Font("Raleway", Font.BOLD, 20));
        province.setBounds(100, 440, 100, 30);
        add(province);  
        
        // drop down list for all province options in Canada
        String valProvince[] = {
            "Alberta", 
            "British Columbia", 
            "Manitoba", 
            "New Brunswick", 
            "Newfoundland and Labrador", 
            "Northwest Territories", 
            "Nova Scotia", 
            "Nunavut", 
            "Ontario", 
            "Prince Edward Island", 
            "Quebec", 
            "Saskatchewan", 
            "Yukon"
        };
        provinceList = new JComboBox(valProvince);
        provinceList.setBounds(300, 440, 400, 30);
        provinceList.setBackground(Color.WHITE);
        add(provinceList);
        
        
        // text prompt for postal code
        JLabel postalCode = new JLabel("Postal Code:");
        postalCode.setFont(new Font("Raleway", Font.BOLD, 20));
        postalCode.setBounds(100, 490, 200, 30);
        add(postalCode);  
        
        // user input for postal code
        pcTextField = new JTextField();
        pcTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pcTextField.setBounds(300, 490, 400, 30);
        add(pcTextField);
        
        
        // create a next button to change page
        next = new JButton("Next>");
        next.setFont(new Font("Raleway", Font.BOLD, 18));
        next.setBounds(620, 550, 90, 35);
        // call actionPerformed method with current action detected
        next.addActionListener(this);
        add(next);
        
        // set window background color, size, location
        // make all texts and components visible
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 650);
        setLocation(220, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ac) {
        // record and store all key information in variables
        String formNumber = "" + random; // long
        String name = nameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "male";
        } else if (female.isSelected()) {
            gender = "female";
        } else if (others.isSelected()) {
            gender = "others";
        }
        
        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "married";
        } else if (single.isSelected()) {
            marital = "single";
        } else if (other.isSelected()) {
            marital = "others";
        }
        
        String address = addressTextField.getText();
        String province = (String) provinceList.getSelectedItem();
        String postalCode = pcTextField.getText();  
        
        
        try {
            // give error message if there is no input for name
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                // update the database with user information by executing SQL command
                Conn c = new Conn();
                String query = "insert into signup values('"+formNumber+"', '"+name+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+province+"', '"+postalCode+"')";
                c.s.executeUpdate(query);
                
                // since next button is clicked, hide the current window and bring out the second page window
                setVisible(false);
                new SignupTwo(formNumber).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public static void main(String args[]) {
        new SignupOne();
    }
}