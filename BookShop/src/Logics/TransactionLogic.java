/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logics;

import Database.DatabaseConnection;
import UserInterfaces.MainFrame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Fenohasina
 */
public class TransactionLogic {
    private MainFrame frame ;
    private DatabaseConnection dataConnect;
   
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
                    frame.getTextAreaTran().append("\n Book  " + "-------------------------------" + "  20000 " + "Rp");
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

}
