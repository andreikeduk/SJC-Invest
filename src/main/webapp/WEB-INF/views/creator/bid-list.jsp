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
	<c:forEach items="${bidslist}" var="bid">
		<tr>
			<td>${bid.id},${bid.status}</td>
			<br />
		</tr>
	</c:forEach>

</body>
</html>
