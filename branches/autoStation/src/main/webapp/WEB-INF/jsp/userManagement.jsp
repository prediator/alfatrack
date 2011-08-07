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
		<div align=center style="margin-top: 70px">
			<form>
				<table border="1">
					<tr>
						<td colspan = "3" align="center">
							<span style="color: red;">USERS:</span>
						</td>
					</tr>
					<tr>
						<td width="100" align="center">
						      <span style="color: blue;">LOGIN</span>
						</td>
						<td width="100" align="center">
                              <span style="color: blue;">NAME</span>
                        </td>
                        <td width="100" align="center">
                              <span style="color: blue;">dispatcher/driver</span>
                        </td>
					</tr>
					<c:forEach var="user" items="${users}">

						<tr>
							<td width="100" align="center">${user.login}</td>
							<td width="100" align="center">${user.name}</td>
							<td width="150" align="center">
								<c:choose>
									<c:when test="${user.isDispatcher}">
										dispatcher
					                </c:when>
									<c:otherwise>
										driver
					                </c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="3" align="center">
							<input type="button" onClick="location.href='register'"
								value="register new user">
						</td>
					</tr>
					<tr>
						<td colspan="3" align="center">
							<input type="button" onClick="location.href='dispatcher'"
								value="to driver page">
						</td>
					</tr>
				</table>
			</form>

		</div>


	</body>
</html>