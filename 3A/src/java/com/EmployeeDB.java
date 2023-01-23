/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
/**
 *
 * @author HP
 */
public class EmployeeDB {
    public boolean validInsert(String uname,String city){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection cn= DriverManager.getConnection("jdbc:derby://localhost:1527/Q3A","neel","1234");
            PreparedStatement ls=cn.prepareStatement("Insert into NEEL.EMPLOYEE_DETAILS values (?,?) ");
            
            ls.setString(1, uname);
            ls.setString(2, city);
                     
            int rs = ls.executeUpdate();
            
            /*ResultSet rs= ls.executeQuery();
            boolean temp=rs.next();*/
            ls.close();
            
            if(rs>0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
