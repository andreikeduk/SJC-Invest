<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>



<h3>Registration transaction using datachek</h3>
<security:authorize
	access="hasRole('ROLE_INVESTOR') and isAuthenticated()">
	<form:form method="post" modelAttribute="datachek" action="${action}">
		<form:label path="amount">Amount: </form:label>
		<br />
		<form:input type="number" path="amount" />
		<form:errors path="amount" cssClass="errorblock"></form:errors>
		<br />
		<form:label path="numberchek">Number of chek: </form:label>
		<br />
		<form:input type="number" path="numberchek" />
		<form:errors path="numberchek" cssClass="errorblock"></form:errors>
		<br />
		<input type="submit" value="Invest" class="btn btn-primary"/>
	</form:form>
</security:authorize>