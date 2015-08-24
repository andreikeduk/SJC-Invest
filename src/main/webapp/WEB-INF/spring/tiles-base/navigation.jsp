<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<ul class="nav nav-pills nav-stacked">
	<c:forEach var="area" items="${arealist}">
		<li>${area.value}</li>
	</c:forEach>
	<li><a href="<c:url value="/index"/>" title="home">HOME</a></li>
	<li><a href="<c:url value="/bid/new"/>" title="addbid">addbid</a></li>
	<li><a href="<c:url value="/projects"/>" title="projects">Projects</a></li>
	

</ul>
