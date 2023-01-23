<%-- 
    Document   : Register
    Created on : 28 Dec, 2022, 9:34:54 PM
    Author     : Aditya_6494
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="RegisterServlet">
            Name: <input type="text" id ="name" name="name">
            Roll_no: <input type="text" id ="roll_no" name="roll_no">
            <input type="submit" value="Register">
        </form>
    </body>
</html>
