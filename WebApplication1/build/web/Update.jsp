<%-- 
    Document   : Update
    Created on : 15 Jan, 2023, 11:23:36 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Update My Record</title>
    </head>
    <body>
        <sql:setDataSource var="ds" driver="org.apache.derby.jdbc.ClientDriver"
                           url="jdbc:derby://localhost:1527/Student_Table" user="neel" password="neel" />
        <sql:update var="rs" dataSource="${ds}">
            UPDATE NEEL.DETAILS SET USERNAME=? , FULLNAME = ?, SEM = ?, ROLLNO = ?, CONTACT = ?, EMAIL = ? WHERE USERNAME = ?
            <sql:param value="${param.username}" />
            <sql:param value="${param.fullname}" />
            <sql:param value="${param.sem}" />
            <sql:param value="${param.rollno}" />
            <sql:param value="${param.contact}" />
            <sql:param value="${param.email}" />
            <sql:param value="${sessionScope.uname}" />
        </sql:update>

        <c:if test="${rs > 0}">
            Record updated successfully!
            <c:redirect url="./Display.jsp" />
        </c:if>
        <c:if test="${rs <= 0}">
            Error updating record!
        </c:if>

    </body>
</html>


