<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<security:authorize access="isAuthenticated() and hasRole('ROLE_CREATOR')">
	<a href="<c:url value="/projects/edit/${project.id}"/>" title="projects">Edit</a>
</security:authorize>
<h1>Name: ${project.name}</h1>
Description: ${project.description}
<br /></br>
Status: ${project.status.toString()}
<br /></br>
Deadline: ${project.deadline}
<br /></br>
Required Amount: ${project.requiredAmount.toString()}
<br /></br>
Creator: ${project.user.firstName} ${project.user.lastName}
<br /></br>
Area: ${project.area.name}
<br /></br>
<security:authorize
	access="hasRole('ROLE_INVESTOR') and isAuthenticated()">
	<form>
		<input type="button" value="Send Money"
			onClick='location.href="/invest/projects/${project.id}/sendMoney"'>
	</form>
</security:authorize>
<br /></br>
<security:authorize access="isAuthenticated()">
	<form>
		<input type="button" value="Complain"
			onClick='location.href="/invest/projects/${project.id}/sendClaim"'>
	</form>
</security:authorize>
<br /></br>
<h2>Comments:</h2>
<security:authorize access="isAuthenticated()">
	<form:form method="post" commandName="comment" modelAttribute="comment" action="${action}">

		<form:label path="comment">Your Comment: </form:label>
		<form:input path="comment" />
		<br />
		<input type="submit" value="Add" />
	</form:form>
</security:authorize>

