<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page language="java" contentType="text/html; charset=windows-1251" pageEncoding="windows-1251" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>LOGIN</title>
</head>
<body>
<div align=center>
    <c:if test="${wrong_credentials}">
        <span style="color: red;">Wrong login or password</span>
        <br/>
        <br/>
    </c:if>

    <form action="j_security_check" method="post">
        <table border="1">
            <tr>
                <td>name</td>
                <td><input type="text" name="j_username" value="admin" size=20></td>
            </tr>
            <tr>
                <td>password</td>
                <td><input type="password" name="j_password" value="admin" size=20></td>
            </tr>
            <tr>
                <td colspan = "2" align = "center"><input type=submit value="LOGIN"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>