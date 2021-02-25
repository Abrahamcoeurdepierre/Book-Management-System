/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import UserInterfaces.MainFrame;
import java.sql.*;  
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Fenohasina
 */
public class DatabaseConnection {
    MainFrame mainFrame;
    public DatabaseConnection(){
             
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
            Connection con=DriverManager.getConnection( 
                    "jdbc:mysql://localhost/db_bookshop","root","Fenohasina");
            System.out.println("Feno");
            
        } catch (SQLException ex) {
           Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void main(String[] args) {
        DatabaseConnection data = new DatabaseConnection();
    }
    
}  


