/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;
import java.sql.*;
/**
 *
 * @author user1
 */
public class App {
    public static void main(String[] args){}
    
/*
    SELECT * FROM VRAJ.SIGNUP
    db-name : vraj
    db-pass : 123
*/  
    public static boolean isExist(String uname, String pass){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver"); //driver-Class
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/signup", "vraj", "123");
            //Statement stm = con.createStatement();
                        
            PreparedStatement stm = con.prepareStatement("SELECT * FROM VRAJ.SIGNUP WHERE SIGNUP.UNAME = ?");
            stm.setString(1, uname);
                    
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                if(rs.getString("UPASS").equals(pass)){
                    stm.close();
                    con.close();
                    return true;
                }
                else return false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }  
        return false;
    }
    
    public static void insertOne(String uname, String pass){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver"); //driver-Class
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/signup", "vraj", "123");
            //Statement stm = con.createStatement();
                        
            PreparedStatement stm = con.prepareStatement("INSERT INTO VRAJ.SIGNUP VALUES (?, ?)");
            stm.setString(1, uname);
            stm.setString(2, pass);
                    
            int n = stm.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }       
    }
    // response.send(link);
}
