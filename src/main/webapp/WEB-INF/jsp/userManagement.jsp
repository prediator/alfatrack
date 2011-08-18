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
						<td colspan="3" align="center">
							<span style="color: red;">DISPATCHERS:</span>
						</td>
					</tr>
					<tr>
						<td width="100" align="center">
							<span style="color: blue;">LOGIN</span>
						</td>
						<td width="100" align="center">
							<span style="color: blue;">NAME</span>
						</td>
					</tr>
					<c:forEach var="disp" items="${disps}">

						<tr>
							<td width="100" align="center">${disp.login}</td>
							<td width="100" align="center">${disp.name}</td>
						</tr>
					</c:forEach>
				</table>
				<div align=center style="margin-top: 70px">
					<table border="1">
						<tr>
							<td colspan="6" align="center">
								<span style="color: red;">DISPATCHERS:</span>
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
								<span style="color: blue;">Bus number</span>
							</td>
							<td width="100" align="center">
								<span style="color: blue;">Bus MAX speed</span>
							</td>
							<td width="100" align="center">
								<span style="color: blue;">Bus MAX load</span>
							</td>
							<td width="100" align="center">
								<span style="color: blue;">Bus workingOrder</span>
							</td>
						</tr>
						<c:forEach var="driver" items="${drivers}">
							<tr>
								<td width="100" align="center">${driver.login}</td>
								<td width="100" align="center">${driver.name}</td>
								<td width="150" align="center">${driver.bus.id}</td>
								<td width="150" align="center">${driver.bus.maxspeed}</td>
								<td width="150" align="center">${driver.bus.busload}</td>
								<td width="150" align="center">
									<c:choose>
										<c:when test="${driver.bus.workingorder}">
											works
								    </c:when>
										<c:otherwise>
											<span style="color: red;">crashed</span>
										</c:otherwise>
									</c:choose>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="6" align="center">
								<input type="button" onClick="location.href='register'"
									value="register new user">
							</td>
						</tr>
						<tr>
							<td colspan="6" align="center">
								<input type="button" onClick="location.href='dispatcher'"
									value="to dispatcher page">
							</td>
						</tr>
					</table>
				</div>
			</form>

		</div>


	</body>
</html>