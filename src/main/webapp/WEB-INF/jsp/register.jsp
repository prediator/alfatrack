<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page language="java" contentType="text/html; charset=windows-1251"
	pageEncoding="windows-1251"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Register</title>
</head>
<body>
	<div align=center style="margin-top: 70px">
		Logged user: ${user.name}
		(login:${user.login})&nbsp;&nbsp;&nbsp;&nbsp; <a href="logout">logout</a>
	</div>
	<div align=center style="margin-top: 70px">
		<form action="register" method="post" align=left>
			<table align=left>
				<tr>
					<td><input type="button" onClick="location.href='dispatcher'"
						value="to dispatcher page" /></td>
				</tr>
				<tr>
					<td><input type="button" onClick="location.href='users'"
						value="to users list" /></td>
				</tr>
			</table>

			<table align=center>
				<c:if test="${loginTaken}">
					<tr>
						<td><span style="color: red;">Login not free</span></td>
					</tr>
				</c:if>
				<tr>
					<td>login</td>
					<td><input type="text" name="login" value="${login}" size=20 />
					</td>
				</tr>
				<c:if test="${isPassWrong}">
					<tr>
						<td><span style="color: red;">Wrong password repeat</span></td>
					</tr>
				</c:if>
				<tr>
					<td>password</td>
					<td><input type="password" name="pass1" size=20 /></td>
				</tr>
				<tr>
					<td>repeat password</td>
					<td><input type="password" name="pass2" size=20 /></td>
				</tr>
				<c:if test="${notNameInputted}">
					<tr>
						<td><span style="color: red;">Input name</span></td>
					</tr>
				</c:if>
				<tr>
					<td>name</td>
					<td><input type="text" name="name" value="${name}" size=20 />
					</td>
				</tr>
				<tr>
					<td>Driver</td>
					<td><input type="radio" name="isDispatcher" value="driver"
						onClick="changeHide('show')" /></td>
				</tr>
				<tr>
					<td>Dispatcher</td>
					<td><input type="radio" name="isDispatcher" value="dispatcher"
						checked onClick="changeHide('hide')" /></td>
				</tr>
				<tr id="businfo"  style="display:none">
					<td colspan="2">
						<table>
							<tr>
								<td>bus load</td>
								<td><input type="text" name="busload" size=20 /></td>
							</tr>
							<tr>
								<td>bus max speed</td>
								<td><input type="text" name="maxspeed" size=20 /></td>
							</tr>
							<tr>
								<td>does it work?</td>
								<td><input type="checkbox" name="busworking" value="true" />
								</td>
							</tr>
						</table></td>
				</tr>
				<tr>
					<td><input type="submit" value="REGISTER"></td>
				</tr>
			</table>
		</form>
	</div>


</body>

<script language="JavaScript">
	var businfo = document.getElementById("businfo");

	function changeHide(action) {
		if (action == 'show') {
			businfo.style.display = '';
		} else {
			businfo.style.display = 'none';
		}
	}
</script>
</html>