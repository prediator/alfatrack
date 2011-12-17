<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Product Groups</title>
    <style type="text/css">
        table {
            margin: 5em;
        }

        td, th {
            padding: 1em;
            padding-top: .5em;
            padding-bottom: .5em;
            border: 1px #ccc solid;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th width="140px">Groups</th>
        <th>Products</th>
    </tr>
    <tr>
        <td rowspan="2" align="center">
            <c:forEach var="group" items="${groups}">
                <a href="products/${group.groupId}">${group.name}</a> (${group.productsCount})<br/>
            </c:forEach>
        </td>
        <td>
            <c:if test="productList">
                <table>
                    <tr>
                        <th width="130px">Name</th>
                        <th width="100px">Price</th>
                    </tr>
                    <c:forEach var="product" items="${productList}">
                        <tr>
                            <td>${product.name}</td>
                            <td align="right">
                                <fmt:formatNumber value="${product.price}" type="number" minFractionDigits="2"
                                                  maxFractionDigits="2"/>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

                <c:if test="productList.pageCount > 1">
                    <div align="center" style="margin-top: 30px;">
                        pager
                    </div>
                </c:if>
            </c:if>
        </td>
    </tr>
</table>
</body>
</html>