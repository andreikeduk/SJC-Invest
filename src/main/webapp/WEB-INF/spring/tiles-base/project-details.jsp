<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1>Name: ${project.name}</h1>
Description: ${project.description}
<br /></br>
Status: ${project.status.toString()}
<br /></br>
Deadline: ${project.deadline}
<br /></br>
Required Amount: ${project.requiredAmount.toString()}
<br /></br>
Creator: ${project.user.firstName} ${project.user.lastName}
<br /></br>
Area: ${project.area.name}
<br /></br>
<form>
	<input type="button" value="Send Money"
		onClick='location.href="/invest/projects/${project.id}/sendMoney"'>
</form>
<form>
	<input type="button" value="Complain"
		onClick='location.href="/invest/projects/${project.id}/sendClaim"'>
</form>