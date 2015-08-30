<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
				<a href="${logoutUrl}"><spring:message
						code="label.logout" /></a>
				<a href="<c:url value="/profile/"/>">${login}</a>
				<a href="<c:url value="/redirector" />"><spring:message
						code="label.userroom" /></a>
			</security:authorize>
			<security:authorize access="isAnonymous()">
				<a href="<c:url value="/login"/>"><spring:message
						code="label.login" /></a>
				<a href="<c:url value="/user/add"/>" title="addUser"><spring:message
						code="label.registration" /></a>
			</security:authorize>
			<span style="float: right"> <a href="?lang=en">en</a> | <a
				href="?lang=ru">ru</a>
			</span>
		</div>
	</div>
</div>
