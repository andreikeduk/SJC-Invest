<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3>Registration transaction</h3>
<form:form method="post" modelAttribute="transaction" action="${action}">
	<form:label path="type">Choose Type of Transaction:</form:label>
	<br />
	<form:select path="type">
		<form:option value="NONE" label="--- Select ---" />
		<c:forEach var="type" items="${typelist}">
			<c:if test="${type.key eq transaction.type.id}">
				<option value="${type.key}" selected="selected">${type.value}</option>
			</c:if>
		</c:forEach>
	</form:select>
	<br />
	<input type="submit" value="Next Step" />
</form:form>
