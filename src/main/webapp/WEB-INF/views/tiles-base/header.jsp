<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<ul class="nav nav-tabs">
	<security:authorize access="isAuthenticated()">
		<c:set var="login">
			<security:authentication property="principal.username" />
		</c:set>
		<c:url var="logoutUrl" value='/j_spring_security_logout' />

		<li><a href="${logoutUrl}"><spring:message
					code="label.logout" /></a></li>
		<li><a href="<c:url value="/profile/"/>">${login}</a></li>
		<li><a href="<c:url value="/redirector" />"><spring:message
					code="label.userroom" /></a></li>
	</security:authorize>
	<security:authorize access="isAnonymous()">

		<li><a href="<c:url value="/login"/>"><spring:message
					code="label.login" /></a></li>

		<li><a href="<c:url value="/user/add"/>" title="addUser"><spring:message
					code="label.registration" /></a></li>
	</security:authorize>
	<li><a href="<c:url value="/index"/>" title="home"><spring:message
				code="label.home" /></a></li>
	<security:authorize access="isAuthenticated()">
		<security:authorize access="hasRole('ROLE_CREATOR')">
			<li><a href="<c:url value="/bid/new"/>" title="addbid"><spring:message
						code="label.addbid" /></a></li>
		</security:authorize>
	</security:authorize>

	<security:authorize access="isAuthenticated()">
		<security:authorize access="hasRole('ROLE_DIRECTOR')">
			<li><a href="<c:url value="/director/verdictTransactions"/>"><spring:message
						code="label.verdictTransactions" /></a></li>
		</security:authorize>
	</security:authorize>


	<li><a href="<c:url value="/aboutUs"/>" title="aboutUs"><spring:message
				code="label.aboutUs" /></a></li>
</ul>
