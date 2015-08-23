<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<c:forEach items="${userList}" var="user">
		<tr>
			<td>${user.lastName},${user.firstName}</td>
			<td>${user.login},${user.password}</td>
			<br/>
		</tr>
	</c:forEach>
	<br/>
	<a href="<c:url value="/" />"> Another Operation</a>
	
</body>
</html>