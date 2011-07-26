<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Details</title>
</head>
<body>
    <table>
        <tr><td>id</td><td>${user.id}</td></tr>
        <tr><td>fullName</td><td>${user.fullName}</td></tr>
     -   <tr><td>login</td><td>${user.login}</td></tr>
        <tr><td>password</td><td>${user.password}</td></tr>
    </table>
</body>
</html>