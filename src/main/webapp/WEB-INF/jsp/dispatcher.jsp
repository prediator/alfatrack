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
		<div align=center style="margin-top: 10px">
			<form action="dispatcher" method="post">
				<table border="1">
					<c:forEach var="app" items="${apps}">
						<tr>
							<td width="100" align="center">${app.minSpeed}</td>
							<td width="100" align="center">${app.minBusLoad}</td>

							<td width="150" align="center">
								<c:choose>
									<c:when test="${app.isdone}">
										done
                                    </c:when>

									<c:otherwise>
										<select name="${app.id}" width="20">
											<c:forEach var="user" items="${users}">
												<c:if
													test="${user.bus.maxSpeed gt app.minSpeed && user.bus.busload gt app.minBusLoad && user.bus.workingOrder}">
													<option value="${user.id}"<c:if test="${app.userId == user.id}">selected</c:if>>
														<c:out value="${user.name}" />
													</option>
												</c:if>
											</c:forEach>
										</select>
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