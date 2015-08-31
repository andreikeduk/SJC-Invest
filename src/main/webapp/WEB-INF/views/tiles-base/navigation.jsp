<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<ul class="nav nav-pills nav-stacked">
	<c:forEach var="area" items="${arealist}">
		<li><a href="<c:url value="/bid/area/${area.key}"/>">${area.value}</a></li>
	</c:forEach>
	
</ul>
