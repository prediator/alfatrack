<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>FAIL</title>
	</head>
	<body>
		<table>
			<tr><td>add user (not in DB)</td></tr>
			<tr><td>id</td><td>${user.id}</td></tr>
		    <tr><td>fullName</td><td>${user.fullName}</td></tr>
		    <tr><td>login</td><td>${user.login}</td></tr>
		    <tr><td>password</td><td>${user.password}</td></tr>  
            <tr><td>
	            <c:choose>
		            <c:when test="${user.isDispatcher}">
		                dispacher
		            </c:when>
		            
		            <c:otherwise>
	                    driver
		            </c:otherwise>
	            </c:choose>
            </td></tr>  
            
	    <table/>
	</body>
</html>