<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page language="java" contentType="text/html; charset=windows-1251"
pageEncoding="windows-1251"%>

<%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Hello ${user.name}</title>
	</head>
	<body 
	  <DIV ALIGN=CENTER>
        <strong>Hello nigga</strong>
      </DIV>
      
     <form action="/autoStation/doapp" method="post">
            <table border="1">
                <c:forEach var="app" items="${sessionScope.sessionManager.apps}">
                    <tr>
                        <td>${app.minSpeed}</td>
                        <td>${app.busLoad}</td>
                        <td>
                            <input type="checkbox" name=${app.id} value=${app.id} />
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>
                        <input type=submit value="CHOOSE" />
                    </td>
                </tr>
        </form>
		
	</body>
</html>
