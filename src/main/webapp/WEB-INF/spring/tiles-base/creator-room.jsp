<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h1>User Room: </h1>
 
<br /><br />
<c:forEach var="project" items="${projectlist}" >
		<tr>
			<td>${project.name}---${project.requiredAmount}---${project.account.balance}---${project.account.number}</td>
			<br />
		</tr>
	</c:forEach>

<br/><br/>