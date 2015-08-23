<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/home.css"/>" />
<html>
<head>
<title>Home</title>
</head>

<body>
	<h1>Hello on our Invest Fund!!!</h1>

	<ul>
		<li><h1>
				<a href="<c:url value="/bid/new"/>">add bid</a>
			</h1></li>
		<li><h1>
				<a href="<c:url value="/bid/list"/>">list bids</a>
			</h1></li>
		<li><h1>
				<a href="<c:url value="/transaction"/>">transaction</a>
			</h1></li>
		<li><h1>
				<a href="<c:url value="/creator"/>">creator page</a>
			</h1></li>
	</ul>
</body>

</html>
