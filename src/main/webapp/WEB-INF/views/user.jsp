<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>
<body>
	<form:form method="post" action="${action}" modelAttribute="user">
		<input type="hidden" name="id" value="${user.id}">
		<table>
			<tr>
				<td><form:label path="firstName">First Name: </form:label></td>
				<td><form:input path="firstName" placeholder="firstName" /></td>
			</tr>

			<tr>
				<td><form:label path="lastName">Last Name: </form:label></td>
				<td><form:input path="lastName" placeholder="lastName" /></td>
			</tr>

			<tr>
				<td><form:label path="login">Login: </form:label></td>
				<td><form:input path="login" placeholder="login" /></td>
				<td><form:errors path="login" cssClass="alert alert-danger" /></td>
			</tr>

			<tr>
				<td><form:label path="password">Password: </form:label></td>
				<td><form:password path="password" placeholder="password" /></td>
				<td><form:errors path="password" cssClass="alert alert-danger" /></td>
			</tr>

			<tr>
				<td><form:label path="email">email: </form:label></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="alert alert-danger" /></td>
			</tr>
			<security:authorize access="isAnonymous()">
				<tr>
					<td>What do you want to be:</td>
					<!-- <td><form:radiobutton path="role" items="${roleOptions}" /></td> -->
					<td>Investor:<form:radiobutton checked="checked" path="role"
							value="INVESTOR" /></td>
					<td>Creator:<form:radiobutton path="role" value="CREATOR" /></td>
					<!-- dead block, may change - andrew  -->
					<security:authorize access="hasRole('ROLE_DIRECTOR')">
						<td>Director:<form:radiobutton path="role" value="DIRECTOR" /></td>
					</security:authorize>
					<td><form:errors path="role" cssClass="alert alert-danger" /></td>
				</tr>
			</security:authorize>
			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>