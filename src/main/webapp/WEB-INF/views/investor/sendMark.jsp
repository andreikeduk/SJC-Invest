<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<security:authorize access="isAuthenticated()">
	<form:form method="post" modelAttribute="mark" action="${action}">

		<form:label path="mark">Your Mark: </form:label>
		<form:input type="number" path="mark" />
		<form:errors path="mark" cssClass="errorblock"></form:errors>
		<br />
		<input type="submit" value="Send Mark" />
	</form:form>
</security:authorize>