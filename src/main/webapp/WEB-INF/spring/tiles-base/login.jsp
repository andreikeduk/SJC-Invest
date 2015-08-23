<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<h3>Please sign in</h3>

<form name='loginForm' action="login" method='POST' class="form-horizontal" role="form">
	<div class="form-group">
		<label for="login" class="col-sm-4 control-label">User:</label>
		<div class="col-sm-8">
			<input type="text" id="login" name="login" class="form-control" placeholder="Enter user name">
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-4 control-label">Password:</label>
		<div class="col-sm-8">
			<input type="password" id="password" name="password" class="form-control" placeholder="Enter password">
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-4 col-sm-8">
			<input name="submit" type="submit" class="btn btn-primary" value=" Sign In " />
		</div>
	</div>
</form>
