<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<security:authorize access="isAuthenticated()">
	<form:form method="post" modelAttribute="claim" action="${claimaction}">

		<form:label path="claim">Your Claim: </form:label>
		<br />
		<form:textarea rows="5" cols="50" path="claim" />
		<form:errors path="claim" cssClass="errorblock"></form:errors>
		<br />
		<input type="submit" value="Send Claim" />
	</form:form>
</security:authorize>