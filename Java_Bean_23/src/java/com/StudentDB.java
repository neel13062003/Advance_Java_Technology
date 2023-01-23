/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;
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
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3307/JavaBean","root","");
            PreparedStatement ls=cn.prepareStatement("select * from users where username=? and password=?");
            
            ls.setString(1,uname);
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
}
