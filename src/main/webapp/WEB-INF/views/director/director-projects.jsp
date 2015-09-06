<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<security:authorize
	access="isAuthenticated() and hasRole('ROLE_DIRECTOR')">
	<a href="<c:url value="/director/all"/>" title="deniedBids">All</a>
	<a href="<c:url value="/director/underconsideration"/>" title="ucProjects">Under consideration</a>
	<a href="<c:url value="/director/accepted"/>" title="acceptedBids">Accepted</a>
	<a href="<c:url value="/director/denied"/>" title="deniedBids">Denied</a>
	<a href="<c:url value="/director/ready"/>" title="readyProjects">Ready</a>
</security:authorize>

<c:if test="${empty projectslist}">
	<h4>There is no projects.</h4>
</c:if>

<c:if test="${!empty projectslist}">
	<h4>
		<spring:message code="label.userroom" />
	</h4>
	<table id="projectsTable" class="table table-striped table-bordered">
		<tr>
			<th><spring:message code="label.projectName" /></th>
			<th><spring:message code="label.balance" /></th>
			<th><spring:message code="label.area" /></th>
			<th><spring:message code="label.status" /></th>
		</tr>
		<c:forEach var="project" items="${projectslist}">
			<c:url value="/projects/${project.id}" var="viewProjectUrl" />
			<c:url value="/bid/area/${project.area.id}" var="viewAreaUrl" />
			<tr>
				<td><a href="${viewProjectUrl}">${project.name}</a></td>
				<td>${project.requiredAmount}/
					${project.account.balance}
					(${project.account.balance/project.requiredAmount}%)</td>
				<td><a href="${viewAreaUrl}">${project.area.name}</a></td>
				<td>${status}To:${periodConsideration.getTime()}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>