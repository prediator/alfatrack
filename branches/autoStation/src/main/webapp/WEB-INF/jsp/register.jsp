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
	           	<c:if test="${loginTaken == 1}">
	           	   <td>
	           	       <span style="color: red;">Login not free</span>
	           	   </td></tr><tr>
	           	</c:if>
	           	<td>login</td>        
		        <td><input type="text" name="login" value="${userAdded.login}" size=20/></td>
		        </tr><tr>
		        <c:if test="${isPassWrong == 1}">
                   <td>
                       <span style="color: red;">Wrong password repeat</span>
                   </td></tr><tr>
                </c:if>
		        <td>password</td>        
                <td><input type="password" name="pass1" size=20/></td>
                </tr><tr>
                <td>repeat password</td>        
                <td><input type="password" name="pass2" size=20/></td>
                </tr><tr>
                <c:if test="${notNameInputted == 1}">
                   <td>
                       <span style="color: red;">Input name</span>
                   </td></tr><tr>
                </c:if>
                <td>name</td>        
                <td><input type="text" name="name" value="${userAdded.name}" size=20/></td>
                </tr><tr>
                <td>Driver</td>        
                <td><input type="radio" name="isDispatcher" value="driver" 
                            <c:if test="${!user.isDispatcher}">CHECKED</c:if>/>
                </td>
                </tr><tr>
                <td>Dispatcher</td>        
                <td><input type="radio" name="isDispatcher" value="dispatcher"
                                        <c:if test="${user.isDispatcher}">CHECKED</c:if>/></td>
                </tr><tr>
		        <td><input type="submit" value="NEXT"></td>
		        
		            
		        </tr>
		        </table>
	        </form>
        </div>
         
        
    </body>
</html>