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
		<div align=center style="margin-top: 5px">
			register Bus for ${login}
			<a href="logout">logout</a>
		</div>
		<div align=center style="margin-top: 70px">
			<form action="register" method="post">
				<table>
					<tr>
						<td>bus load</td>
						<td>
							<input type="text" name="busload" size=20 />
						</td>
					</tr>
					<tr>
						<td>bus max speed</td>
						<td>
							<input type="text" name="bmaxSpeed" size=20 />
						</td>
					</tr>
					<tr>
                        <td>does it work?</td>
                        <td>
                            <input type="checkbox" name="isWorkingOrder" value="true" />
                        </td>
                    </tr>
					<tr>
						<td>
							<input type="submit" value="FINISH">
						</td>

					</tr>
				</table>
			</form>
		</div>


	</body>
</html>