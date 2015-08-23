<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<form:form method="post" action="adduser" commandName="user">
	<table>
		<tr>
			<td><form:label path="firstName"></form:label></td>
			<td><form:input path="firstName" /></td>
		</tr>
		<tr>
			<td><form:label path="lastName">
			
			</form:label></td>
			<td><form:input path="lastName" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Add" /></td>
		</tr>
	</table>
</form:form>

</body>
</html>