<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page language="java" contentType="text/html; charset=windows-1251" pageEncoding="windows-1251" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>Driver</head>
<body>
<title>
    <div align=center>
        <h1>Hello ${user.name}</h1>
    </div>
</title>
<table>
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
<table border=1>
    <tr>
        <td>

        </td>
    </tr>
</table>
</body>
</html>