<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/home.css"/>" />

<h1>
	<spring:message code="label.transactions" />
	to projects:
</h1>

<table id="transactionsTableProjects" border="1"
	class="table table-striped table-bordered">
	<tr>
		<th><spring:message code="label.projectName" /></th>
		<th><spring:message code="label.amount" /></th>
		<th><spring:message code="label.typeTransaction" /></th>
		<th><spring:message code="label.status" /></th>
	</tr>

	<c:forEach items="${projects}" var="project" varStatus="status">
		<c:url value="/projects/${project.id}" var="viewProjectUrl" />
		<c:url value="/director/transactions/${transaction.id}" var="viewTransactionUrl" />
		<tr>
			<td><a href="${viewProjectUrl}">${project.name}</a></td>
			<td>${transactions[status.index].amount}</td>
			<td>${transactions[status.index].type}</td>
			<td><a href="${viewTransactionUrl}">Change Status</a></td>
		</tr>
	</c:forEach>

</table>

<h1>
	<spring:message code="label.transactions" />
	to areas:
</h1>
<table id="transactionsTableAreas" border="1"
	class="table table-striped table-bordered">
	<tr>
		<th><spring:message code="label.area" /></th>
		<th><spring:message code="label.amount" /></th>
		<th><spring:message code="label.typeTransaction" /></th>
	</tr>

	<c:forEach items="${areas}" var="area" varStatus="status">
		<tr>
			<td>${area.name}</td>
			<td>${transactions[status.index].amount}</td>
			<td>${transactions[status.index].type}</td>
		</tr>
	</c:forEach>

</table>
