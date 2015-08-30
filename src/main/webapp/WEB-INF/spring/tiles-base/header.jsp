<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<div id="header">
	<h1>Hello on our Invest Fund!!!</h1>
</div>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/home.css"/>" />

<div class="nav nav-pills">
	<div class="container">
		<div class="navbar-header">
			<security:authorize access="isAuthenticated()">
				<c:set var="login">
					<security:authentication property="principal.username" />
				</c:set>
				<c:url var="logoutUrl" value='/j_spring_security_logout' />
				<a href="${logoutUrl}">Logout</a>
				<a href="<c:url value="/profile/"/>">${login}</a>
				<a href="<c:url value="/redirector" />">User projects</a>
			</security:authorize>
			<security:authorize access="isAnonymous()">
				<a href="<c:url value="/login"/>">Log In</a>
				<a href="<c:url value="/user/add"/>" title="addUser">Register</a>
			</security:authorize>
		</div>
	</div>
</div>
