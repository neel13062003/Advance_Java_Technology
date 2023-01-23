<%-- 
    Document   : display
    Created on : Jan 27, 2020, 12:35:56 PM
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display</title>
    </head>
    
    <% 
        String username = request.getParameter("username");
        String password = request.getParameter("password");
    %>
    
    <jsp:useBean id="personBean" class="LAB_6.PersonBean" scope="page">
         <jsp:setProperty name="personBean" property="*" />
           <jsp:setProperty name="personBean" property="username" value="<%=username%>"/> 
           <jsp:setProperty name="personBean" property="password" value="<%=password%>"/>              
    </jsp:useBean>
       Name: <jsp:getProperty name = "personBean" property="username"/><br>
       Password:  <jsp:getProperty name = "personBean" property="password" />
</html>
