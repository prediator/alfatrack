<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page language="java" contentType="text/html; charset=windows-1251"
pageEncoding="windows-1251"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Hello ${user.name}</title>
    </head>
    <body 
      <DIV ALIGN=CENTER>
        <strong>Hello nigga</strong>
      </DIV>
      
      <DIV ALIGN=CENTER>
	     <form action="/autoStation/authentication" method="post">
	            <table border="1">
	                <tr>
		                <td>name</td>
	                    <td>
	                        <input type = "text" name = "login" size = 20 >
	                    </td>
		                   
	                </tr>
	                <tr>
                        <td>password</td>
                        <td>
                            <input type = "text" name = "pass" size = 20>
                        </td>
                           
                    </tr>
	                <tr>
	                    <td>
	                        <input type=submit value="CHOOSE" />
	                    </td>
	                </tr>
	             </table>   
	             <c:if test = "${message}">
	               <strong>Wrong login or pasword</strong>
	             </c:if>
	        </form>
         </DIV>
        
    </body>
</html>
