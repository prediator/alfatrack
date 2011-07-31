<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page language="java" contentType="text/html; charset=windows-1251"
         pageEncoding="windows-1251" %>

<%@taglib prefix="c"
          uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Driver</title>
</head>
<body>

<div align=center style="padding-top: 100px;">
    <table border="1">
        <tr>
            <td colspan="3">
                <c:choose>
                    <c:when test="${user.bus.workingOrder}">
                        bus is in working order &nbsp;&nbsp;&nbsp;
                        <a href="driver?workingOrder=0">CRASH</a>
                    </c:when>

                    <c:otherwise>
                        bus is NOT in working order &nbsp;&nbsp;&nbsp;
                        <a href="driver?workingOrder=1">REPAIR</a>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>

        <form action="driver" method="post">
            <c:forEach var="app" items="${apps}">
                <tr>
                    <td width="15">
                        <c:choose>
                            <c:when test="${app.isdone}">
                                done
                            </c:when>

                            <c:otherwise>
                                <input type="checkbox" name="doapp" value="${app.id}"/>
                            </c:otherwise>
                        </c:choose>
                    </td>

                    <td width="100" align="center">${app.minSpeed}</td>
                    <td width="100" align="center">${app.minBusLoad}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="3" align="center">
                    <input type=submit value="Set is done"/>
                </td>
            </tr>
        </form>
    </table>
</div>
</body>
</html>
