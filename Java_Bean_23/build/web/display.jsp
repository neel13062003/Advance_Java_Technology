<%-- 
    Document   : display
    Created on : 23 Jan, 2023, 10:19:13 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String username = request.getParameter("username");
            String password = request.getParameter("password");
        %>
    
        <jsp:useBean id="personBean" class="com.UserBean" scope="page">
               <jsp:setProperty name="personBean" property="*" />
               <jsp:setProperty name="personBean" property="username" value="<%=username%>"/> 
               <jsp:setProperty name="personBean" property="password" value="<%=password%>"/>              
        </jsp:useBean>
           Name: <jsp:getProperty name = "personBean" property="username"/><br>
           Password:  <jsp:getProperty name = "personBean" property="password" />
    </body>
</html>
