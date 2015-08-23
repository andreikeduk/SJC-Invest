<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Home</title>
</head>

<body>
	<form:form method="post" modelAttribute="project" action="${action}">

		<form:label path="name">Project name: </form:label>
		<form:input path="name" />
		<form:errors path="name" cssClass="error"></form:errors>
		<br />
		<form:label path="requiredAmount">Required Amount: </form:label>
		<form:input path="requiredAmount" />
		<br />

		<form:label path="description">Description: </form:label>
		<form:textarea rows="5" cols="100" path="description" />
		<br />
		<form:label path="area">Area:</form:label>
		<br />
		<!-- <form:select path="area">
			<form:errors path="area" cssClass="error"></form:errors>
			<form:option value="NONE" label="--- Select ---" />

			<c:forEach var="area" items="${arealist}">
			
				
				<c:if test="${area.key eq project.area.id}">
					<option value="${area.key}" selected="selected">${area.value}</option>
				</c:if>

				<c:if test="${area.key ne project.area.id}">
					<option value="${area.key}">${area.value}</option>
				</c:if>
			</c:forEach>
		</form:select>-->

		<br />
		<input type="submit" value="Add" />


	</form:form>


</body>

</html>
