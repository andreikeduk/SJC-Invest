<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h4>User Room:</h4>
<table id="projectsTable" border="1" cellpadding="10" cellspacing="0"
	class="table table-striped table-bordered">
	<tr>
		<th>Name</th>
		<th>Balance/Amount</th>
		<th>Area</th>
		<th>Status</th>
	</tr>
	<c:forEach var="bid" items="${bidslist}">
		<!--<c:url value="/projects/${bid.project.id}" var="viewProjectUrl" />
		<c:url value="/bid/area/${bid.project.area.id}" var="viewAreaUrl" />
		<tr>
			<td><a href="${viewProjectUrl}">${bid.project.name}</a></td>
			<td>${bid.project.requiredAmount}/
				${bid.project.account.balance}
				(${bid.project.account.balance/bid.project.requiredAmount}%)</td>
			<td><a href="${viewAreaUrl}">${bid.project.area.name}</a></td>
			<td>${bid.status}To: ${bid.periodConsideration.getTime()}</td>
		</tr>
		<br />-->
		<tr>
			<td>${bid.id},${bid.status}</td>
			<br />
		</tr>
	</c:forEach>
</table>
<br />
<br />