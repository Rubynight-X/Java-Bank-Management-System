package bank.management.system;

import java.sql.*;

public class Conn {
    
    // initiate connection object and statement object
    Connection c;
    Statement s;
    
    public Conn() {
        try {
            // register driver and create connection
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "ayhy.ys287baiqi0721");
            // create statement to communicate with database
            s = c.createStatement();
        
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
