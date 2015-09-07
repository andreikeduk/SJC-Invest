<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/home.css"/>" />
<h1>
	<spring:message code="label.transactions" />
	:
</h1>

<table id="transactionsTable" border="1"
	class="table table-striped table-bordered">
	<tr>
		<th><spring:message code="label.projectName" /></th>
		<th><spring:message code="label.amount" /></th>
		<th><spring:message code="label.typeTransaction" /></th>
	</tr>

	<c:forEach items="${transactions}" var="transaction" varStatus="status">
		<c:url value="/projects/${projects.get[status.index].id}" var="viewProjectUrl" />
		<tr>
			<td><a href="${viewProjectUrl}">${projects[status.index].name}</a></td>
			<td>${transaction.amount}</td>
			<td>${transaction.type}</td>
		</tr>
	</c:forEach>

</table>

<a href="<c:url value="/sendMoney/1"/>">Medicine</a>
<a href="<c:url value="/sendMoney/2"/>">Foundation</a>
<a href="<c:url value="/sendMoney/3"/>">Talents</a>
<a href="<c:url value="/sendMoney/4"/>">Education</a>
