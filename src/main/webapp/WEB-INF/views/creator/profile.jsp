<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h1>User Profile:</h1>
<c:if test="${not empty user}">
	<ul>
		<li>firstName: ${user.firstName}</li>
		<li>
		<br />
		<li>lastName: ${user.lastName}</li>
		<br />
		<li>login: ${user.login}</li>
		<br />
		<li>email: ${user.email}</li>
		
	</ul>
</c:if>
<br />
<br />

