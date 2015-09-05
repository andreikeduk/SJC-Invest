<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>



<h3>Registration transaction using transfer</h3>
<security:authorize
	access="hasRole('ROLE_INVESTOR') and isAuthenticated()">
	<form:form method="post" modelAttribute="transfer" action="${action}">
		<form:label path="amount">Amount: </form:label>
		<br />
		<form:input type="number" path="amount" />
		<br />
		<form:label path="numbertransfer">Number of transfer: </form:label>
		<br />
		<form:input type="number" path="numbertransfer" />
		
		<input type="submit" value="Invest" />
	</form:form>
</security:authorize>