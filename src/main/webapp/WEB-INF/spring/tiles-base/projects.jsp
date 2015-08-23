<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/home.css"/>" />
<h1>Projects: </h1>

<br/><br/>

<table id="projectsTable" border="1" cellpadding="10" cellspacing="0" class="table table-striped table-bordered">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th></th>
	</tr>

	<c:forEach items="${projectslist}" var="project" >
		<c:url value="/projects/${project.id}" var="viewProjectUrl" />
		
		<tr id="project${project.id}">
		    <td>${project.id}</td>		    
		    <td><a href="${viewProjectUrl}">${project.name}</a></td> 		    
		    <!--
		    <td>
		    	<a href="<c:url value="/client/edit/${client.id}" />"> Edit </a> &nbsp;
		    	<a href="<c:url value="/client/delete/${client.id}" />"> Delete </a>
		   	</td>
		   	<td>
		    	<span onclick="clientInfo(${client.id})">Client Info (ajax)</span> <br/>
		    	<span onclick="clientDelete(${client.id})">Client Delete (ajax)</span> 
		   	</td>  
		    -->
	   	</tr>
	</c:forEach>
</table>