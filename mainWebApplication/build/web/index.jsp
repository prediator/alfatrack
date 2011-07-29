<%-- 
    Document   : index
    Created on : 28.07.2011, 21:58:52
    Author     : elias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="http://localhost:8084/mainwebapplication/loginuser" method="post">
            <table align="center">
                <tr>
                    <td colspan="2">
                        <h1>Welcome!</h1>
                        <br/><h3>input your username and password</h3>
                    </td>
                </tr>
                <tr>
                    <td>
                        Login
                    </td>
                    <td>
                        <input type="text" name="login" size="15">
                    </td>
                </tr>
                <tr>
                    <td>
                        Password
                    </td>
                    <td>
                        <input type="password" name="password" size="15">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="LOGIN">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
