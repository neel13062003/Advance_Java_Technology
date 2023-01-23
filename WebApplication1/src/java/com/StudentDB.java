/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;         //alwatys above
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author HP
 */
public class StudentDB {
   
    public boolean validateLogin(String uname,String password){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection cn= DriverManager.getConnection("jdbc:derby://localhost:1527/Student_Table","neel","neel");
            PreparedStatement ls=cn.prepareStatement("Select * from NEEL.DETAILS  where USERNAME=? and PASSWORD=? ");
            
            ls.setString(1, uname);
            ls.setString(2,password);
            
            ResultSet rs= ls.executeQuery();
            boolean temp=rs.next();
            ls.close();
            
            return temp;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean validateInsert(String uname,String password,String fname,String sem,String rollno,String contact,String email){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection cn= DriverManager.getConnection("jdbc:derby://localhost:1527/Student_Table","neel","neel");
            PreparedStatement ls=cn.prepareStatement("Insert into NEEL.DETAILS values (?,?,?,?,?,?,?) ");
            
            ls.setString(1, uname);
            ls.setString(2,password);
            ls.setString(3, fname);
            ls.setInt(4,Integer.parseInt(sem));
            ls.setString(5,rollno);
            ls.setLong(6,Long.parseLong(contact));
            ls.setString(7,email);
            
            
            int rs = ls.executeUpdate();
            
            /*ResultSet rs= ls.executeQuery();
            boolean temp=rs.next();*/
            ls.close();
            
            if(rs>0){
                return true;
            }else{
                return false;
            }
            
            //return temp;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
