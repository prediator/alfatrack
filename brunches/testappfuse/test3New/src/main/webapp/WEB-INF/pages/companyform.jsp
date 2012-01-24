<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="userProfile.title" /></title>
<meta name="heading" content="<fmt:message key='userProfile.heading'/>" />
<meta name="menu" content="UserMenu" />
<script type="text/javascript"
	src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>

<spring:bind path="company.*">
	<c:if test="${not empty status.errorMessages}">
		<div class="error"><c:forEach var="error"
			items="${status.errorMessages}">
			<img src="<c:url value="/images/iconWarning.gif"/>"
				alt="<fmt:message key="icon.warning"/>" class="icon" />
			<c:out value="${error}" escapeXml="false" />
			<br />
		</c:forEach></div>
	</c:if>
</spring:bind>

<form:form commandName="company" method="post" action="companyform"
	onsubmit="return onFormSubmit(this)" id="companyForm">
	<form:hidden path="id" />
	<input type="hidden" name="from" value="<c:out value="${param.from}"/>" />

	<ul>
		<li class="buttonBar right"><input type="submit" class="button"
			name="save" onclick="bCancel=false"
			value="<fmt:message key="button.save"/>" />
			 <c:if test="${param.from == 'list' and param.method != 'Add'}">
					<input type="submit" class="button" name="delete"
						onclick="bCancel=true;return confirmDelete('company')"
						value="<fmt:message key="button.delete"/>" />
			</c:if> 
		<input type="submit" class="button" name="cancel"
			onclick="bCancel=true" value="<fmt:message key="button.cancel"/>" />
		</li>
		<li class="info">
		<c:choose>
			<c:when test="${param.from == 'list'}">
				<p><fmt:message key="userProfile.admin.message" /></p>
			</c:when>
			<c:otherwise>
				<p><fmt:message key="userProfile.message" /></p>
			</c:otherwise>
		</c:choose></li>
		<li><appfuse:label styleClass="desc" key="class_company.name" />
		 <form:errors path="name" cssClass="fieldError" />
		<form:input path="name" id="name" cssClass="text large" cssErrorClass="text large error" />
		</li>
		<li>
			<appfuse:label styleClass="desc" key="class_company.description" />
			<form:errors path="description" cssClass="fieldError" />
			<form:input path="description" id="description" cssClass="text large" cssErrorClass="text large error" />
		</li>
		
		<li class="buttonBar bottom"><input type="submit" class="button"
			name="save" onclick="bCancel=false"
			value="<fmt:message key="button.save"/>" /> <c:if
			test="${param.from == 'list' and param.method != 'Add'}">
			<input type="submit" class="button" name="delete"
				onclick="bCancel=true;return confirmDelete('user')"
				value="<fmt:message key="button.delete"/>" />
		</c:if> <input type="submit" class="button" name="cancel"
			onclick="bCancel=true" value="<fmt:message key="button.cancel"/>" />
		</li>
	</ul>
</form:form>

<script type="text/javascript">
    Form.focusFirstElement($('userForm'));
    highlightFormElements();

    function passwordChanged(passwordField) {
        if (passwordField.id == "password") {
            var origPassword = "${user.password}";
        } else if (passwordField.id == "confirmPassword") {
            var origPassword = "${user.confirmPassword}";
        }

        if (passwordField.value != origPassword) {
            createFormElement("input", "hidden",  "encryptPass", "encryptPass",
                              "true", passwordField.form);
        }
    }

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
<c:if test="${param.from == 'list'}">
    selectAll('userRoles');
</c:if>
    return validateUser(theForm);
}
</script>

<v:javascript formName="user" staticJavascript="false" />
<script type="text/javascript"
	src="<c:url value="/scripts/validator.jsp"/>"></script>

