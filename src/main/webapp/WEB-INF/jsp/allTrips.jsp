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
				<font size="5">TRIPs:</font>
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
							<input type="button" onClick="location.href='register'"
								value="add new user" />
						</td>
					</tr>
					<tr>
                        <td>
                            <input type="button" onClick="location.href='dispatcher'"
                                value="back to dispatcher page" />
                        </td>
                    </tr>
				</table>
			</form>
		</div>

		<div align=center style="margin-top: 10px">
			<form action="dispatcher" method="post">
				<table border="1">
					<tr>
						<td width="100" align="center">
							<span style="color: blue;">ID</span>
						</td>
						<td width="100" align="center">
							<span style="color: blue;">LOGIN</span>
						</td>
						<td width="100" align="center">
							<span style="color: blue;">NAME</span>
						</td>
						<td width="100" align="center">
							<span style="color: blue;">BUS speed</span>
						</td>
						<td width="100" align="center">
							<span style="color: blue;">BUS load</span>
						</td>
						<td width="100" align="center">
							<span style="color: blue;">NeeD speed</span>
						</td>
						<td width="100" align="center">
							<span style="color: blue;">NeeD load</span>
						</td>
						<td width="100" align="center">
							<span style="color: blue;">completeness</span>
						</td>
					</tr>
					<c:forEach var="trip" items="${trips}">

						<tr>
							<td width="100" align="center">${trip.id}</td>
							<td width="100" align="center">${trip.bus.driver.login}</td>
							<td width="100" align="center">${trip.bus.driver.name}</td>
							<td width="100" align="center">${trip.bus.maxspeed}</td>
							<td width="100" align="center">${trip.bus.busload}</td>
							<td width="100" align="center">${trip.busapp.minspeed}</td>
							<td width="100" align="center">${trip.busapp.minbusload}</td>
							<td width="100" align="center">
								<c:choose>
									<c:when test="${trip.isdone}">
										DONE!
                                    </c:when>
									<c:otherwise>
										<span style="color: red;">NOT</span>DONE
									</c:otherwise>
								</c:choose>
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