<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<form name='loginForm' action="login" method='POST'
	class="form-horizontal">
	<div class="form-group">
		<label for="login" class="col-sm-4 control-label">Enter your
			claim:</label>
		<div class="col-sm-8">
			<input type="text" id="claim" name="claim" class="form-control"
				placeholder="Enter claim">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-4 col-sm-8">
			<input name="submit" type="submit" class="btn btn-primary"
				value=" Send claim " />
		</div>
	</div>
</form>