<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page language="java" contentType="text/html; charset=windows-1251" pageEncoding="windows-1251" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Users</title>
</head>
<body>
<form action="/autoStation/authentication" method="post">
    <table border="1">
        <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.name}</td>
            <td><input type="radio" name="login" value=${user.login}/></td>
        </tr>
        </c:forEach>

        <tr>
            <td><input type=submit value="CHOOSE"/></td>
        </tr>
</form>
</table>
</body>
</html>
