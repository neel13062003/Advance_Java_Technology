/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg3;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class MyFrame extends Frame implements ActionListener{
    MyDialog md;
    
    TextField tele, name, address, delTele, searchBar;
    Button insert, delete, search;
    PreparedStatement st, st2, st3;
    Panel p1,p2,p3;
    
    MyFrame(String t){
        super(t);
        setSize(700, 400);
        setLayout(new FlowLayout());
        
        tele = new TextField(10);
        delTele = new TextField(10);
        name = new TextField(20);
        address = new TextField(30);
        searchBar = new TextField(10);
        
        insert = new Button("Insert");
        delete = new Button("Delete");
        search = new Button("Serach");
        
        insert.addActionListener(this);
        delete.addActionListener(this);
        search.addActionListener(this);
        
        p1 = new Panel();
        p1.add(insert);
        p1.add(tele);
        p1.add(name);
        p1.add(address);
        
        p2 = new Panel();
        p2.add(delete);
        p2.add(delTele);
        
        p3 = new Panel();
        p3.add(search);
        p3.add(searchBar);
        
        add(p1);
        add(p2);
        add(p3);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == insert){
            String t = tele.getText().trim();
            String n = name.getText().trim();
            String a = address.getText().trim();
            insertData(t, n, a);
        }
        else if(ae.getSource() == delete){
            String dt = delTele.getText().trim();
            deleteData(dt);
        }
        else if(ae.getSource() == search){
            String t = searchBar.getText().trim();
            searchQuery(t);
        }
    }
    
    public void createConnection(MyDialog md){
            try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/DirLab3", "vraj", "123");
                String query = "INSERT INTO VRAJ.LAB3TABLE VALUES (?,?,?)";
                String queryDel = "DELETE FROM VRAJ.LAB3TABLE WHERE TELENO = ?";
                String querySearch = "Select * FROM VRAJ.LAB3TABLE WHERE TELENO = ?";
                st = con.prepareStatement(query);
                st2 = con.prepareStatement(queryDel);
                st3 = con.prepareStatement(querySearch);
                
                this.md = md;
                this.setVisible(true);
                md.dispose();
                
            }catch(Exception e){
                e.printStackTrace();
            };
    }
    
    public void insertData(String tele, String name, String address){
        try{
            st.setString(1, tele);
            st.setString(2, name);
            st.setString(3, address);
            int n = st.executeUpdate();

            System.out.println("Inserted Successfully ...");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void deleteData (String tele){
        try{
            st2.setString(1, tele);
            int n = st2.executeUpdate();
            System.out.println("Deleted Successfully ... "+tele);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void searchQuery(String tele){
        try{
            System.out.println("Display : \n");
            st3.setString(1, tele);
            ResultSet rs = st3.executeQuery();
            
            System.out.println("Display : ");
            while(rs.next()){
                System.out.println(rs.getString("teleno") +" | "+rs.getString("name") +" | "+rs.getString("address") +" | ");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class MyDialog extends Dialog implements ActionListener{
    
    Button connection;
    MyFrame f;
    MyDialog(MyFrame f, String name, Boolean modal){
        super(f,name,modal);
        this.f = f;
        setVisible(true);
        setSize(200,100);
        setLayout(new FlowLayout());
        
        connection = new Button("Connection....");
        connection.addActionListener(this);
        
        add(connection);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == connection){
            f.createConnection(this);
        }
    }
}
/**
 *
 * @author user1
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyFrame f = new MyFrame("Get Data");
        MyDialog md = new MyDialog(f, "Connection-Box", false);
    }
    
}
