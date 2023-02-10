<%-- 
    Document   : Display
    Created on : 10 Jan, 2023, 10:00:43 PM
    Author     : HP
--%>

<!https://www.roseindia.net/jsp/how-to-retrieve-data-from-database-in-jsp.shtml#google_vignette>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Data of Login Page</title>
    </head>
    <body>
        <!--h1><!Hello World!></h1-->
        <%@page import="java.sql.DriverManager"%>
        <%@page import="java.sql.ResultSet"%>
        <%@page import="java.sql.Statement"%>
        <%@page import="java.sql.Connection"%>
        <%@page import="javax.servlet.http.HttpSession" %>

        <%
            
        //request.getSession().setAttribute("currentUser", username);   
            
        //String id = request.getParameter("username"); this give me input tag name.
        
        HttpSession session1 = request.getSession();
        String s1 =  session1.getAttribute("uname").toString();          //because getattrubute give object.
        
        //System.out.println("username: " + s1);
        
        String driverName = "org.apache.derby.jdbc.ClientDriver";
        String connectionUrl = "jdbc:derby://localhost:1527/Student_Table";
        String dbName = "Student_Table";
        String userId = "neel";
        String password = "neel";

        try{
            Class.forName(driverName);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        %>
        <h2 align="center"><font><strong>Retrieve Your Information from database in JSP</strong></font></h2>
        <table align="center" cellpadding="5" cellspacing="5" border="1">
            <tr>
                <a href="logout.jsp"><button>Logout</button></a>
            </tr>
            <br><br>
            <tr>
                <a href="Delete.jsp"><button>Delete My Record</button></a>
            </tr>
            
            
            <tr>

            </tr>
            <tr bgcolor="#A52A2A">
                <td><b>Username</b></td>
                <td><b>Full Name</b></td>
                <td><b>Semester</b></td>
                <td><b>Roll No</b></td>
                <td><b>Contact</b></td>
                <td><b>Email</b></td>
            </tr>
        
            <%
            try{ 
                //connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Student_Table","neel","neel");
                statement=connection.createStatement();
                 
                String sql ="SELECT * FROM NEEL.DETAILS where USERNAME='"+s1+"' ";

                resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
            %>
            <tr bgcolor="#DEB887">
                <td><%= resultSet.getString("USERNAME") %></td>
                <td><%= resultSet.getString("FULLNAME") %></td>
                <td><%= resultSet.getString("SEM")      %> </td>
                <td><%= resultSet.getString("ROLLNO")   %></td>
                <td><%= resultSet.getString("CONTACT")  %></td>
                <td><%= resultSet.getString("EMAIL")    %></td>
            </tr>
            <% 
                }   

            }catch(Exception e) {
                e.printStackTrace();
            }
        %>
        </table>
        
        <br><br>
        
        <table align="center" cellpadding="5" cellspacing="5" border="1">
            <form action="Update.jsp" >
                <tr bgcolor="#A52A2A">
                    <td><b>Username</b><input type="text"  name="username"></td>
                    <td><b>Full Name</b><input type="text"  name="fullname"></td>
                    <td><b>Semester</b><input type="text"  name="sem"></td>
                    <td><b>Roll No</b><input type="text"  name="rollno"></td>
                    <td><b>Contact</b><input type="text"  name="contact"></td>
                    <td><b>Email</b><input type="text"  name="email"></td>
                    <tr>
                        <td><input name="Update" type="submit" value="Update"></input></td>
                    </tr>
                </tr> 
            </form>
        </table>    

    </body>
</html>

<!---
https://youtu.be/CzlZGHAGHbk

    public class SecondServlet extends HttpServlet{
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOExceptions{
            String str=request.getParameter("uname");   //whatever enter in index.html name field
            System.out.println(str);
            PrintWriter out= response.getWrite();
            out.print("In Second Servlet");
        }
    }
>

