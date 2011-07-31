<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page language="java" contentType="text/html; charset=windows-1251" pageEncoding="windows-1251" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Driver</title>
</head>
<body>
<div align=center style="margin-top: 70px">
    Logged user: ${user.name} (login:${user.login})&nbsp;&nbsp;&nbsp;&nbsp;<a href="logout">logout</a>
</div>
<div align=center style="margin-top: 10px">
<table border="1">
    <tr>
        <td>
            <c:choose>
                <c:when test="${user.bus.isWorkingOrder}">
                    bus is in working order
                    <a href="/changeWorkingOrder">CRASH</a>
                </c:when>

                <c:otherwise>
                    bus NOT in working order
                    <a href="/changeWorkingOrder">REPAIR</a>
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
</table>
</div>
</body>
</html>