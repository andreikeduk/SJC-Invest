<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="header">
	<h1>Hello on our Invest Fund!!!</h1>
</div>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/home.css"/>" />

<div class="nav nav-pills" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<c:if test="${not empty user}">
			<a href="<c:url value="/login/logout"/>">Logout</a>
				You are:<a href="<c:url value="/profile/${user.id}" />">${user.role}
					${user.login} </a>
				<a class="navbar-header" href="<c:url value="/bid/list" />">Bids
					list</a>
				
			</c:if>
			<c:if test="${empty user}">
				<a href="<c:url value="/login"/>">Log In</a>
				<a href="/test/user/add" title="addUser">Register</a>
			</c:if>

		</div>
	</div>
</div>
