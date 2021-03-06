<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Home</title>
</head>

<body>
	<form:form method="post" modelAttribute="project" action="${action}">

		<form:label path="name">Project name: </form:label>
		<br />
		<form:input path="name" />
		<form:errors path="name" class="alert alert-danger"></form:errors>
		<form:label path="status">Ready?: </form:label>
		<form:checkbox path="status"/>
		<br />
		<form:label path="requiredAmount">Required Amount: </form:label>
		<br />
		<form:input type = "number" path="requiredAmount" />
		<form:errors path="requiredAmount" class="alert alert-danger"></form:errors>
		<br />
		<form:label path="description">Description: </form:label>
		<br />
		<form:textarea rows="5" cols="120" path="description" />
		<br />
		<form:label path="deadline">Period implementation: </form:label>
		<br />
		<form:input type = "number" path="deadline" />
		<form:label path="deadline"> days </form:label>
		<form:errors path="deadline" class="alert alert-danger"></form:errors>
		<br />
		<form:label path="area">Area:</form:label>
		<br />
		<form:select path="area">
			<form:option value="NONE" label="--- Select ---" />
			<c:forEach var="area" items="${arealist}">
				<c:if test="${area.key eq project.area.id}">
					<option value="${area.key}" selected="selected">${area.value}</option>
				</c:if>
				<c:if test="${area.key ne project.area.id}">
					<option value="${area.key}">${area.value}</option>
				</c:if>
			</c:forEach>
		</form:select>
		<form:errors path="area" class="alert alert-danger"></form:errors>
		<br />
		<input type="submit" value="Save" class="btn btn-primary" />
	</form:form>
</body>

</html>
