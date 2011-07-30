<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page language="java" contentType="text/html;" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Users</title>
</head>
<body>
<table border="1">
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
