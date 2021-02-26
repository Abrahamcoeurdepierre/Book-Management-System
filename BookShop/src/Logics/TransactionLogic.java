/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logics;

import Database.DatabaseConnection;
import UserInterfaces.MainFrame;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Fenohasina
 */
public class TransactionLogic {
    private MainFrame frame ;
    private DatabaseConnection dataConnect;
    public int totalPrice;
   
    public TransactionLogic(MainFrame view) {
        this.frame = view;
        connectDataBase();
        frame.getTextAreaTran().append(" Book Name  -------------------------------  Book Price ");

        this.frame.getBtnAdd().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 if(frame.getBookIdField().getText().equalsIgnoreCase("")){
                    JOptionPane.showMessageDialog(view, "Please input an ID", "Information", JOptionPane.INFORMATION_MESSAGE);
                 }
                 else{
                    addBookToBill(frame.getBookIdField().getText().toString());
                    frame.getBookIdField().setText("");
                 }             
             }            
         });      
        this.frame.getBtnTransaction().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {                            
             }          
         }); 
    }
    
    public void connectDataBase(){
        dataConnect = new DatabaseConnection();
    }
    public void addBookToBill(String book_Id){
        try {
            Statement stmt= (Statement) dataConnect.con.createStatement();
            String strSelect = "select book_name, book_price, book_author from book where book_id = " + book_Id ;
            
            
            System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
            
            
            ResultSetImpl rset =(ResultSetImpl) stmt.executeQuery(strSelect);
            System.out.println("The records selected are:");
            
            
            int rowCount = 0;
             while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                String book_name = rset.getString("book_name");
                int book_price = rset.getInt("book_price");
                String    book_author   = rset.getString("book_author");
                frame.getTextAreaTran().append("\n" + book_name + " By " + book_author + " ---------------- " + book_price + "Rp");
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);
        } catch (SQLException ex) {
            Logger.getLogger(TransactionLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
