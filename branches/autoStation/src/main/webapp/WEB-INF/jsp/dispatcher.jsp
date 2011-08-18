<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page language="java" contentType="text/html; charset=windows-1251"
pageEncoding="windows-1251" %>
<%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Dispatcher</title>
	</head>
	<body>
		<div align=center style="margin-top: 70px">
			Logged user: ${user.name} (login:${user.login})&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="logout">logout</a>
		</div>
		<div align=center style="margin-top: 5px">
			<p>
				<font size="5">Applications:</font>
			</p>
		</div>
		<div align=left>
			<form>
				<table>
					<tr>
						<td>
							<input type="button" onClick="location.href='users'" value="show all users" />
						</td>
					</tr>
					<tr>
                        <td>
                            <input type="button" onClick="location.href='trips'" value="show trips" />
                        </td>
                    </tr>
					<tr>
						<td>
							<input type="button" onClick="location.href='register'"
								value="add new user" />
						</td>
					</tr>
				</table>
			</form>
		</div>

		<div align=center style="margin-top: 10px">
			<form action="dispatcher" method="post">
				<table border="1">
					<c:forEach var="app" items="${apps}" varStatus="appVar">
						<tr>
							<td width="100" align="center">${app.minspeed}</td>
							<td width="100" align="center">${app.minbusload}</td>
							<td width="150" align="center">
								<select name="${app.id}" width="20">
									<option value="0" selected>nobody</option>
									<c:forEach var="user" items="${applist[appVar.index]}">
										<option value="${user.id}">
											${user.name}
										</option>
									</c:forEach>
								</select>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div align="center" style="padding-top: 10px">
					<input type=submit value="Assign drivers to Applications" />
				</div>
			</form>
		</div>
	</body>
</html>