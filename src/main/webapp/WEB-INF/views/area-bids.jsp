<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<c:if test="${empty areabids}">
	<h4>No bids in ${area} area.</h4>
</c:if>

<c:if test="${!empty areabids}">
	<h4>Bids in ${areainfo.area.name} area :</h4>

	<security:authorize access="hasRole('ROLE_DIRECTOR')">
		<c:if test="${!empty areainfo}">
			<tr>
				<td>Projects count: ${areainfo.projectsCount}</td>
				<td>Are a balance: ${areainfo.balance}</td>
			</tr>
		</c:if>
	</security:authorize>
	<table id="projectsTable" border="1" cellpadding="10" cellspacing="0"
		class="table table-striped table-bordered">

		<tr>
			<th>Name</th>
			<th>Balance/Amount</th>
			<th>Creator</th>
		</tr>
		<c:forEach var="bid" items="${areabids}">
			<c:url value="/projects/${bid.project.id}" var="viewProjectUrl" />
			<tr>
				<td><a href="${viewProjectUrl}">${bid.project.name}</a></td>
				<td>${bid.project.requiredAmount}/
					${bid.project.account.balance}
					(${bid.project.account.balance/bid.project.requiredAmount}%)</td>
				<td>${bid.project.user.firstName}${bid.project.user.lastName}
					(${bid.project.user.login})</td>
			</tr>
		</c:forEach>
	</table>
</c:if>