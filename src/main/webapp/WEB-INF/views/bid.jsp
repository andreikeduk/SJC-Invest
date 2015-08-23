<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/home.css"/>" />
<html>
<head>
<title>Home</title>
</head>

<body>
	<form:form method="post" commandName = "bid" modelAttribute="bid" action="${action}" >
	<table>
		<tr>
			<td><form:label path="id">id</form:label></td>
			<td><form:input path="id" /></td>
			
		</tr>
		<tr>
			<td><form:label path="status">Status</form:label></td>
			<td><form:input path="status" /></td>
		</tr>
		<tr>
			<td><form:label path="${user.firstName}">firstName</form:label></td>
			<td><form:input path="${user.firstName}" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Add" /></td>
		</tr>
	</table>
</form:form>
	
	
</body>

</html>
