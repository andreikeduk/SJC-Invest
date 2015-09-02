<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3>Registration transaction</h3>
<form:form method="post" modelAttribute="transaction" action="${action}">
	<form:label path="type">Choose Type of Transaction:</form:label>
	<select id="actSelect" class="Validate_Required " name="actSelect"
		aria-required="true" onChange="Selected(this)">
		<option value="" selected="selected">-</option>
		<option value="1">DATACHECK</option>
		<option value="2">TRANSFER</option>
		<option value="3">BANKCARD</option>
	</select>
	<br />
	<form:label path="amount">Enter amount: </form:label>
	<form:input path="amount" />
	<input type="submit" value="Next Step" />

	<div id='DATACHECK' style='display: none;'>
		Выберите ещё что-нибудь: <select>
			<option value="" selected="selected">-</option>
			<option value="a">Вариант 1</option>
			<option value="b">Вариант 2</option>
			<option value="c">Вариант 3</option>
		</select>
	</div>

	<div id='TRANSFER' style='display: none;'>Текст обычного скрытого
		блока</div>

	<p></p>
	<div>Текст не в скрытом блоке</div>
	<form:label path="amount">Enter amount: </form:label>
	<input type="submit" value="Next Step" />
</form:form>



<script>
	function Selected(a) {
		var label = a.value;
		if (label == 1) {
			document.getElementById("DATACHECK").style.display = 'block';
			document.getElementById("TRANSFER").style.display = 'none';
			document.getElementById("BANKCARD").style.display = 'none';
		} else if (label == 2) {
			document.getElementById("DATACHECK").style.display = 'none';
			document.getElementById("TRANSFER").style.display = 'block';
			document.getElementById("BANKCARD").style.display = 'none';
		} else {
			document.getElementById("DATACHECK").style.display = 'none';
			document.getElementById("TRANSFER").style.display = 'none';
			document.getElementById("BANKCARD").style.display = 'block';
		}

	}
</script>


