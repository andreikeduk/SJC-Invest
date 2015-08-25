<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3>Registration transfer</h3>

<form name='loginForm' action="login" method='POST'
	class="form-horizontal">
	<div class="form-group">
		<label for="login" class="col-sm-4 control-label">Amount:</label>
		<div class="col-sm-8">
			<input type="text" id="amount" name="amount" class="form-control"
				placeholder="Enter amount">
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-4 control-label">Password:</label>
		<div class="col-sm-8">
			<input type="text" id="password" name="password" class="form-control"
				placeholder="Enter password">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-4 col-sm-8">
			<input name="submit" type="submit" class="btn btn-primary"
				value=" Sign In " />
		</div>
	</div>
</form>

