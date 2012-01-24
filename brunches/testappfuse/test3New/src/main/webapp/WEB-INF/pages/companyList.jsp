<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="company.title" /></title>
<meta name="heading" content="<fmt:message key='class_company.heading'/>" />
<meta name="menu" content="mainMenu" />
</head>

<input type="button" style="margin-right: 5px"
    onclick="location.href='<c:url value="/companyform?method=Add"/>'"
    value="<fmt:message key="button.add"/>"/>

<!-- url="/userform?from=list" - To read -->
<display:table name="companyList" cellspacing="0" cellpadding="0"
	requestURI="" defaultsort="1" id="companies" pagesize="25"
	class="table" export="false">
	<display:column property="name" escapeXml="true" sortable="true"
		titleKey="class_company.name" style="width: 25%" paramId="id"
		paramProperty="id" url="/companyform?"/>
	<display:column property="description" escapeXml="true" sortable="true"
		titleKey="class_company.description" style="width: 34%" />
	<display:column property="date" sortable="true" titleKey="class_company.date"
		style="width: 22%" autolink="true" media="html" />
	<display:column property="updateDate" sortable="true" titleKey="class_company.update_date"
		style="width: 22%" autolink="true" media="html" />
</display:table>

<display:table name="users" cellspacing="0" cellpadding="0"
	requestURI="" defaultsort="1" id="users" pagesize="25" class="table"
	export="false">
	<display:column property="username" titleKey="employee(s) of ${companyName}" style="width: 34%" />
</display:table>

<fmt:message key="mine.message" />

<script type="text/javascript">
	highlightTableRows("companies");
	highlightTableRows("users");
</script>
