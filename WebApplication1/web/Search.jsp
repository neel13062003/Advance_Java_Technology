<%-- 
    Document   : Search
    Created on : 15 Jan, 2023, 10:29:46 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
            <%@page import="java.sql.*"%>
            <%@page import="javax.servlet.http.HttpSession" %>
        <table align="center" cellpadding="5" cellspacing="5" border="1">    
            <tr bgcolor="#A52A2A">
                <td><b>Username</b></td>
                <td><b>Full Name</b></td>
                <td><b>Sem</b></td>
                <td><b>Roll No</b></td>
                <td><b>Contact</b></td>
                <td><b>Email</b></td>
            </tr>
            
            <%
                // Get the search text from the input field
                String searchText = request.getParameter("search_field");

                // Load the JDBC driver
                Class.forName("org.apache.derby.jdbc.ClientDriver");

                // Connect to the database
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Student_Table", "neel", "neel");

                // Create a statement object
                PreparedStatement st = con.prepareStatement("SELECT * FROM NEEL.DETAILS where USERNAME=?");
                
                
                st.setString(1, searchText);
                // Execute the query
                ResultSet rs = st.executeQuery();

                // Process the results
                while(rs.next()){
                    // Code to process the data
                    // out.println(rs.getString("column_name"));
                    %>
                    <tr bgcolor="#DEB887">
                        <td><%= rs.getString("USERNAME") %></td>
                        <td><%= rs.getString("FULLNAME") %></td>
                        <td><%= rs.getString("SEM")      %> </td>
                        <td><%= rs.getString("ROLLNO")   %></td>
                        <td><%= rs.getString("CONTACT")  %></td>
                        <td><%= rs.getString("EMAIL")    %></td>
                    </tr>
                        <% 
                    }

                // Close the connection
                con.close();
            %>
            </table>
    </body>
</html>
