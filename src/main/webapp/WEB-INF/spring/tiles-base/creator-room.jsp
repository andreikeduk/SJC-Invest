<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h1>User Room:</h1>
<table border="1" cellpadding="10" cellspacing="0"
	class="table table-striped table-bordered">
	<tr>
		<th>Name</th>
		<th>AccNum</th>
		<th>Required</th>
		<th>Balance</th>
		<th>Status</th>
		<th>Complete</th>
	</tr>
	<c:forEach var="bid" items="${bidslist}">
		<tr>
			<td>${bid.project.name}</td>
			<td>${bid.project.account.number}</td>
			<td>${bid.project.requiredAmount}</td>
			<td>${bid.project.account.balance}</td>
			<td>${bid.status}</td>
			<td>${bid.project.account.balance/bid.project.requiredAmount}%</td>
		</tr>
		<br />
	</c:forEach>
</table>
<br />
<br />