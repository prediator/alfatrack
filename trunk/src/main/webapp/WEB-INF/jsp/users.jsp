<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <c:forEach items="${userList}" var="user">
        <a href="user/${user.id}">${user.fullName}</a><br/>
    </c:forEach>
</body>
</html>