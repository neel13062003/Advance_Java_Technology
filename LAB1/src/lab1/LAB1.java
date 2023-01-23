/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;
import java.sql.*;
/**
 *
 * @author HP
 */
public class LAB1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //alt+ scroll mouse to zoom
        //System.out.println("Jay Swaminarayan");
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Student_DB","neelsoni","neelsoni");
            System.out.println(" Connect with db server");
            
             //now create table in service tab
             //it should be connected.
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("Select * from test");
            
            while(rs.next()){
            System.out.println("Name is "+ rs.getString("name"));    
            }    
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
 