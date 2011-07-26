<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Input</title>
</head>
<body>
<h2 align="center">INPUT DATA:</h2>
<form method="post">
    <table align="left">
        <tr>
            <td valign="top">
                NAME:
            </td>
            <td valign="top">
                <input type="text" name="name" size="20">
            </td>
        </tr>
        <tr>
            <td valign="top">
                LOGIN:
            </td>
            <td valign="top">
                <input type="text" name="login" size="20">
            </td>
        </tr>
        <tr>
            <td valign="top">
                PASSWORD:
            </td>
            <td valign="top">
                <input type="text" name="pass" size="20">
            </td>
        </tr>
        <tr>
            <td valign="top">
                do you Dispacher?
            </td>
            <td valign="top">
               <input type="checkbox" NAME="isDispatcher">
            </td>
        </tr>
        <tr>
            <td valign="top">
                <input type="submit" value="INPUT">
            </td>
        </tr>
        </td></tr>
    </table>
</form>

</body>
</html>