<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<ul class="nav nav-pills nav-stacked">
	<c:forEach var="area" items="${arealist}">
		<li>${area.value}</li>
	</c:forEach>
	<li><a href="<c:url value="/index"/>" title="home"><spring:message
				code="label.home" /></a></li>
	<security:authorize access="isAuthenticated()">
		<security:authorize access="hasRole('ROLE_CREATOR')">
			<li><a href="<c:url value="/bid/new"/>" title="addbid"><spring:message
						code="label.addbid" /></a></li>
		</security:authorize>
		<li><a href="<c:url value="/projects"/>" title="projects"><spring:message
					code="label.projects" /></a></li>
	</security:authorize>

</ul>
