<%-- 
    Document   : Update
    Created on : 15 Jan, 2023, 11:23:36 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update My Record</title>
    </head>
    <body> 
        <%@page import="java.sql.*"%>
        <%   
            HttpSession session2 = request.getSession();
            String uname =  session2.getAttribute("uname").toString(); 
           
            // Get the new data for the record
            String username = request.getParameter("username").toString();
            String fullname = request.getParameter("fullname").toString();
            String sem = request.getParameter("sem").toString();
            String rollno = request.getParameter("rollno").toString();
            String contact = request.getParameter("contact").toString();
            String email = request.getParameter("email").toString();
           

            // Load the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // Connect to the database
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Student_Table", "neel", "neel");

            // Create a statement object
            PreparedStatement st = con.prepareStatement("UPDATE NEEL.DETAILS SET USERNAME=? , FULLNAME = ?, SEM = ?, ROLLNO = ?, CONTACT = ?, EMAIL = ? WHERE USERNAME = ?");
            st.setString(1, username);
            st.setString(2, fullname);
            st.setString(3, sem);
            st.setString(4, rollno);
            st.setString(5, contact);
            st.setString(6, email);
            st.setString(7, uname);
          

            // Execute the query
            int result = st.executeUpdate();

            if(result > 0){
                // Record updated successfully
                out.println("Record updated successfully!");
                response.sendRedirect("./Display.jsp");   //same page par j reflect
            }else{
                // An error occurred
                out.println("Error updating record!");
            }

            // Close the connection
            con.close();
        %>
    </body>
</html>
