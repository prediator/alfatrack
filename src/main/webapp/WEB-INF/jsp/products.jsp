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
<c:url var="products_page" value="/products"/>
<table>
    <tr>
        <th width="140px">Groups</th>
        <c:if test="${productList != null}">
            <th>Products</th>
        </c:if>
    </tr>
    <tr height="480px;">
        <td align="center">
            <c:forEach var="group" items="${groups}">
                <a href="${products_page}/${group.groupId}">${group.name}</a> (${group.productCount})<br/>
            </c:forEach>
        </td>
        <c:if test="${productList != null}">
            <td valign="top">
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
                        <c:forEach var="i" begin="1" end="${productList.pageCount}">
                            <c:choose>
                                <c:when test="${i == productList.currentPage}">
                                    <strong>&nbsp;${i}&nbsp;</strong>
                                </c:when>
                                <c:otherwise>
                                    <a href="${products_page}/${productList.groupId}/${i}">&nbsp;${i}&nbsp;</a>
                                </c:otherwise>
                            </c:choose>
                            &nbsp;&nbsp;
                        </c:forEach>
                    </div>
                </c:if>
            </td>
        </c:if>
    </tr>
</table>
</body>
</html>