<%-- 
    Document   : Delete
    Created on : 15 Jan, 2023, 11:16:13 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Record</title>
    </head>
    <body>
        <%@page import="java.sql.*"%>
        <%
            
            HttpSession session1 = request.getSession();
            String uname =  session1.getAttribute("uname").toString();   
            
            // Get the id of the record to be deleted
            //String id = request.getParameter("id").toString();

            // Load the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // Connect to the database
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Student_Table", "neel", "neel");

            // Create a statement object
            PreparedStatement st = con.prepareStatement("DELETE FROM NEEL.DETAILS WHERE USERNAME = ?");
            st.setString(1, uname);

            // Execute the query
            int result = st.executeUpdate();

            if(result > 0){
                // Record deleted successfully
                out.println("Record deleted successfully!");
                response.sendRedirect("index.html");
            }else{
                // An error occurred
                out.println("Error deleting record!");
            }

            // Close the connection
            con.close();
        %>
        
    </body>
</html>
