<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="login">
	<security:authentication property="principal.username" />
</c:set>
<security:authorize access="${project.user.login == login } ">
	<a href="<c:url value="/projects/edit/${project.id}"/>"
		title="projects">Edit</a>
</security:authorize>
<h1>Name: ${project.name}</h1>
Description: ${project.description}
<br>
Status: ${project.status.toString()}
<br>
Deadline: ${project.deadline}
<br>
Required Amount: ${project.requiredAmount.toString()}
<br>
Creator: ${project.user.firstName} ${project.user.lastName}
<br>
Area: ${project.area.name}
<br>
<security:authorize
	access="hasRole('ROLE_INVESTOR') and isAuthenticated()">
	<form>
		<input type="button" value="Send Money"
			onClick='location.href="/invest/projects/${project.id}/sendMoney"'>
	</form>
</security:authorize>
<br>
<security:authorize access="isAuthenticated()">
	<form>
		<input type="button" value="Complain"
			onClick='location.href="/invest/projects/${project.id}/sendClaim"'>
	</form>
	<form>
		<input type="button" value="Add Comment"
			onClick='location.href="/invest/projects/${project.id}/sendComment"'>
	</form>
</security:authorize>
<br>
<h2>Comments:</h2>
<c:forEach items="${comments}" var="comment">
	<b>${comment.user.firstName} ${comment.user.lastName}</b>
	<br>
	${comment.comment}
	<hr />
</c:forEach>

