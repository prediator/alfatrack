<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Product Groups</title>
    <style type="text/css">
        table {
            margin: 2em;
        }

        td, th {
            padding: 1em;
            padding-top: .3em;
            padding-bottom: .3em;
            border: 1px #ccc solid;
            min-width: 200px;
        }
    </style>
</head>
<body>
<c:url var="products" value="/products"/>
<table>
    <tr>
        <th width="140px">Groups</th>
        <c:if test="${productList != null}">
            <th>Products</th>
        </c:if>
    </tr>
    <tr height="480px;">
        <td rowspan="2" align="center">
            <c:forEach var="group" items="${groups}">
                <a href="${products}/${group.groupId}">${group.name}</a> (${group.productCount})<br/>
            </c:forEach>
        </td>
        <c:if test="${productList != null}">
            <td>
                <table>
                    <tr>
                        <th width="130px">Name</th>
                        <th width="100px">Price</th>
                    </tr>
                    <c:forEach var="product" items="${productList.list}">
                        <tr>
                            <td>${product.name}</td>
                            <td align="right">
                                <fmt:formatNumber value="${product.price}" type="number" minFractionDigits="2"
                                                  maxFractionDigits="2"/>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

                <c:if test="${productList.pageCount > 1}">
                    <div align="center" style="margin-top: 30px;">
                        pager
                    </div>
                </c:if>
            </td>
        </c:if>
    </tr>
</table>
</body>
</html>