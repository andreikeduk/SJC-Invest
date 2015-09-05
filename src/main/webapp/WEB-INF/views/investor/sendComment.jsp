<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<security:authorize access="isAuthenticated()">
	<form:form method="post" modelAttribute="comment" action="${action}">
		<form:label path="comment">Your Comment: </form:label>
		<br />
		<form:textarea rows="5" cols="50" path="comment" />
		<form:errors path="comment" cssClass="errorblock"></form:errors>
		<br />
		<input type="submit" value="Send Comment" />
	</form:form>
</security:authorize>