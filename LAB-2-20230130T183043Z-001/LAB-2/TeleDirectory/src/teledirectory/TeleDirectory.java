/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teledirectory;
import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

/**
 *
 * @author user1
 */

class MyFrame extends Frame implements ActionListener{
        
        Button connect;
        Scanner sc = new Scanner(System.in);
        MyFrame(String t){
            super(t);
            setLayout(new FlowLayout());
            setSize(100, 100);
            setVisible(true);
            
            connect = new Button("Connect...");
            connect.addActionListener(this);
      
            this.add(connect);
        }
        
        public void actionPerformed(ActionEvent ae){
            
            
            if(ae.getSource() == connect){
                try{
                    Class.forName("org.apache.derby.jdbc.ClientDriver"); //driver-Class
                    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/TELE_DIRECTORY", "VRAJ_PATEL", "VR@JP@TEL123");
//                    Statement stm = con.createStatement();
                        
                    System.out.println("Enter phone-no :  ");
                    String phone = sc.next();
                    PreparedStatement stm = con.prepareStatement("SELECT * FROM VRAJ_PATEL.TELEPHONEDIR WHERE TELEPHONEDIR.TELEPHONE_NO = ?");
                    stm.setString(1, phone);
                    
                    ResultSet rs = stm.executeQuery();
                    while(rs.next()){
                        System.out.println(rs.getString("NAME") + "\t" + rs.getString("SUR_NAME") + "\t" +rs.getInt("NUMBER"));
                    }

                    stm.close();
                    con.close();
                }
                catch(Exception e){
                   e.printStackTrace();
                }         
            }
        }
    }

public class TeleDirectory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyFrame f = new MyFrame("Get Connection");
    }
}
