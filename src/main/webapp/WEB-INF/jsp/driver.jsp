<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page language="java" contentType="text/html; charset=windows-1251"
pageEncoding="windows-1251"%>

<%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Driver</title>
	</head>
	<body>
      <div align=left>
	      <c:choose>
	            <c:when test="${user.bus.workingOrder}">
		            bus is in working order &nbsp;&nbsp;&nbsp;
		            <a href="driver?workingOrder=0">CRASH</a>
	            </c:when>

	           <c:otherwise>
		          bus NOT in working order &nbsp;&nbsp;&nbsp;
		          <a href="driver?workingOrder=1">REPAIR</a>
	         </c:otherwise>
	     </c:choose>
     </div>

     <div align=center>
     <form action="driver" method="post">
            <table border="1">
                <c:forEach var="app" items="${apps}">
                    <tr>
                        <td>${app.minSpeed}</td>
                        <td>${app.minBusLoad}</td>

                        <td>
                            <c:choose>
                                <c:when test="${app.isdone}">
                                    done
                                </c:when>

                                <c:otherwise>
                                    <input type="checkbox" name="doapp" value=${app.id} />
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>
                        <input type=submit value="DONE" />
                    </td>
                </tr>
        </form>
		</div>
	</body>
</html>
