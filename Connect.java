/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.system;

/**
 *
 * @author A. Yitzkak
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {

    public static Connection Connect() {
        try {
            //Your database url string,ensure it is correct
            String url = "jdbc:mysql://localhost:3306/school";
            String user = "root";
            String password = "";
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
            return conn;

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Not Connected");
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
}
