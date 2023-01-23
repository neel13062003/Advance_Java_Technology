/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdbproject;
import java.sql.*;
/**
 *
 * @author HP
 */
public class FirstDBProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
   
            Class.forName("org.apache.derby.jdbc.ClientDriver"); // driver class
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dummyDB", "abc", "abc"); // db-url, usrname, password
           
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ABC.SAMPLETABLE");

            while(rs.next()){
                System.out.println(rs.getString("USR"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
