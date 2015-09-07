<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:if test="${empty transactionsList}">
	<h4>Project do not have any investition.</h4>
</c:if>

<c:if test="${!empty transactionsList}">

	<h3>Project investitions:</h3>
	<br />

	<table id="transactionsTable" border="1"
		class="table table-striped table-bordered">

		<tr>
			<th>Date</th>
			<th>Amount</th>
		</tr>

		<c:forEach items="${transactionsList}" var="transaction">
			<c:url value="/projects/${project.id}" var="viewProjectUrl" />

			<tr>
				<td>${transaction.time.getTime()}</td>
				<td>${transaction.amount}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>