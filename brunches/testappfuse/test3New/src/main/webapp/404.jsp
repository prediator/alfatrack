<%@ include file="/common/taglibs.jsp"%>

<page:applyDecorator name="default">

<head>
    <title><fmt:message key="404.title"/></title>
    <meta name="heading" content="<fmt:message key='404.title'/>"/>
</head>

<p>
    <fmt:message key="404.message">
        <fmt:param><c:url value="/mainMenu"/></fmt:param>
    </fmt:message>
</p>
<p style="text-align: center; margin-top: 20px">
    <a href="/mainMenu"
        title="HellyTrollolo">
    <img  src="<c:url value="http://img340.imageshack.us/img340/9366/trololo.gif"/>" alt="Emerald Lake - Western Canada" /></a>
</p>
</page:applyDecorator>