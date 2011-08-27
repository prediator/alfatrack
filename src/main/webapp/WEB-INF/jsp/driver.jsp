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
            <td colspan="3" align="center">
                <c:choose>
                    <c:when test="${user.bus.workingorder}">
                        bus is in working order &nbsp;&nbsp;&nbsp;
                        <a href="driver?workingorder=0">CRASH</a>
                    </c:when>

                    <c:otherwise>
                        bus is <span style="color: red;">NOT</span> in working order &nbsp;&nbsp;
                        <a href="driver?workingorder=1">REPAIR</a>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>

        <form action="driver" method="post">
            <c:forEach var="trip" items="${trips}">
                <tr>
                    <td width="40" align="center">
                        <c:choose>
                            <c:when test="${trip.isdone}">
                                done
                            </c:when>

                            <c:otherwise>
                                <input type="checkbox" name="dotrip" value="${trip.id}"/>
                            </c:otherwise>
                        </c:choose>
                    </td>

                    <td width="100" align="center">${trip.busapp.minSpeed}</td>
                    <td width="100" align="center">${trip.busapp.minBusLoad}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="3" align="center">
                    <input type=submit value="Set"/>
                </td>
            </tr>
        </form>
    </table>
</div>
</body>
</html>