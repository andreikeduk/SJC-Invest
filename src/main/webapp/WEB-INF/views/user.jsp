<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<form:form method="post" action="${action}" modelAttribute="user">
		<table>
			<tr>
				<td><form:label path="firstName">firstName</form:label></td>
				<td><form:input path="firstName" placeholder="firstName" /></td>
			</tr>

			<tr>
				<td><form:label path="lastName">lastName</form:label></td>
				<td><form:input path="lastName" placeholder="lastName" /></td>
			</tr>

			<tr>
				<td><form:label path="login">login</form:label></td>
				<td><form:input path="login" placeholder="login" /></td>
				<td><form:errors path="login" cssClass="errorblock" /></td>
			</tr>

			<tr>
				<td><form:label path="password">password</form:label></td>
				<td><form:password path="password" placeholder="password" /></td>
				<td><form:errors path="password" cssClass="errorblock" /></td>
			</tr>

			<tr>
				<td><form:label path="email">email</form:label></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="errorblock" /></td>
			</tr>

			<tr>
				<td>What do you want to be:</td>
				<!-- <td><form:radiobutton path="role" items="${roleOptions}" /></td> -->
				<td>Investor:<form:radiobutton onfocus="true" path="role" value="INV" /></td>
				<td>Creator:<form:radiobutton path="role" value="CRE" /></td>
				<security:authorize
					access="isAuthenticated() and hasRole('ROLE_DIRECTOR')">
					<td>Director:<form:radiobutton  path="role" value="DIR" /></td>
				</security:authorize>



			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>