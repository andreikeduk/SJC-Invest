<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/home.css"/>" />

<h4>My balance: ${investor.account.balance}</h4>
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
	</tr>

	<c:forEach items="${projects}" var="project" varStatus="status">
		<c:url value="/projects/${project.id}" var="viewProjectUrl" />
		<tr>
			<td><a href="${viewProjectUrl}">${project.name}</a></td>
			<td>${transactions[status.index].amount}</td>
			<td>${transactions[status.index].type}</td>
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
<h4>Do you want put money in area?</h4>
<a href="<c:url value="/sendMoney/1"/>">Medicine</a>
<a href="<c:url value="/sendMoney/2"/>">Foundation</a>
<a href="<c:url value="/sendMoney/3"/>">Talents</a>
<a href="<c:url value="/sendMoney/4"/>">Education</a>
