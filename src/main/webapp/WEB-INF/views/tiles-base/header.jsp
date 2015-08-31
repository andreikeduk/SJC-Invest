<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="nav nav-pills nav-stacked">
	<security:authorize access="isAuthenticated()">
		<c:set var="login">
			<security:authentication property="principal.username" />
		</c:set>
		<c:url var="logoutUrl" value='/j_spring_security_logout' />
		<a href="${logoutUrl}"><spring:message code="label.logout" /></a>
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
	<a href="<c:url value="/index"/>" title="home"><spring:message
			code="label.home" /></a>
	<security:authorize access="isAuthenticated()">
		<security:authorize access="hasRole('ROLE_CREATOR')">
			<a href="<c:url value="/bid/new"/>" title="addbid"><spring:message
					code="label.addbid" /></a>
		</security:authorize>
		<a href="<c:url value="/projects"/>" title="projects"><spring:message
				code="label.projects" /></a>
	</security:authorize>
	<a href="<c:url value="/aboutUs"/>" title="aboutUs"><spring:message
			code="label.aboutUs" /></a>
	<div style="float: right">
		<a href="?lang=en">en</a> | <a href="?lang=ru">ru</a> </span>
	</div>
</div>