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

        <%-- Left side - Groups --%>
        <td align="center">
            <c:forEach var="group" items="${groups}">
                <c:choose>
                    <c:when test="${group.groupId == productList.groupId}">
                        <strong>${group.name}</strong>
                    </c:when>
                    <c:otherwise>
                        <a href="${products_page}/${group.groupId}">${group.name}</a>
                    </c:otherwise>
                </c:choose>
                &nbsp;&nbsp;(${group.productCount})<br/>
            </c:forEach>
        </td>

        <%-- Right side - Products --%>
        <c:if test="${productList != null}">
            <td valign="top">
                <div style="height: 355px;">
                    <table>
                            <%-- Product table header --%>
                        <tr>
                            <th width="130px">
                                <a href="${products_page}/${productList.groupId}/1/${sort.nameUrlSuffix}">Name</a>
                                <span style="font-family: arial">&nbsp;${sort.nameSign}</span>
                            </th>

                            <th width="100px">
                                <a href="${products_page}/${productList.groupId}/1/${sort.priceUrlSuffix}">Price</a>
                                <span style="font-family: arial">&nbsp;${sort.priceSign}</span>
                            </th>
                        </tr>

                            <%-- Product table content --%>
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
                </div>

                    <%-- Pager --%>
                <c:if test="${productList.pageCount > 1}">
                    <div align="center" style="margin-top: 30px;">
                        <c:forEach var="i" begin="1" end="${productList.pageCount}">
                            <c:choose>
                                <c:when test="${i == productList.currentPage}">
                                    <strong>&nbsp;${i}&nbsp;</strong>
                                </c:when>
                                <c:otherwise>
                                    <a href="${products_page}/${productList.groupId}/${i}${productList.pagerSortUrlSuffix}">
                                        &nbsp;${i}&nbsp;</a>
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