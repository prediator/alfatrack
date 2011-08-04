<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page language="java" contentType="text/html; charset=windows-1251"
pageEncoding="windows-1251" %>
<%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Register</title>
    </head>
    <body>
        <div align=center style="margin-top: 70px">
            Logged user: ${user.name} (login:${user.login})&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="logout">logout</a>
        </div>
        <div align= center style="margin-top: 70px">
            <form action="register" method="post">
		        <table>
	           	<tr>
	           	<td>login</td>        
		        <td><input type="text" name="login" value="${user.login}" size=20/></td>
		        
		        <td>password</td>        
                <td><input type="password" name="pass1" size=20/></td>
                
                <td>repeat password</td>        
                <td><input type="password" name="pass2" size=20/></td>
                
                <td>name</td>        
                <td><input type="text" name="name" value="${user.name}" size=20/></td>
                
                <td>Driver</td>        
                <td><input type="radio" name="isDriver" value="driver" 
                            <c:if test="${!user.isDispatcher}">CHECKED</c:if>/>
                </td>
                
                <td>Dispatcher</td>        
                <td><input type="radio" name="isDriver" value="dispatcher"
                                        <c:if test="${user.isDispatcher}">CHECKED</c:if>/></td>
                
                <c:if test="${!user.isDipatcher}">
	                <td>BusSpeed</td>        
	                <td><input type="text" name="maxSpeed" value="${bus.maxSpeed}"/></td>
	                
	                <td>BusLoad</td>        
	                <td><input type="text" name="busload" value="${bus.busload}" /></td>
	                
                </c:if>
		            
		        <td><input type="submit" value="NEXT"></td>
		        
		            
		        </tr>
		        </table>
	        </form>
        </div>
         
        
    </body>
</html>