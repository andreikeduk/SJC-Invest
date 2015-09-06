<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3>Choose Type of Transaction:</h3>

<select id="actSelect" class="Validate_Required " name="actSelect"
	aria-required="true" onChange="Selected(this)">
	<option value="" selected="selected">-</option>
	<option value="1">DATACHEK</option>
	<option value="2">TRANSFER</option>
	<option value="3">BANKCARD</option>
</select>
<br />

<div id='DATACHEK' style='display: none;'>
	In the next step you have to provide data chek <br /> <input
		type="button" value="Enter data chek"
		onClick='location.href="/invest/sendMoney/${account.id}/datachek"'
		class="btn btn-primary">
</div>

<div id='TRANSFER' style='display: none;'>
	In the next step you have to provide details of transfer money <br />
	<input type="button" value="Enter details of transfer"
		onClick='location.href="/invest/sendMoney/${account.id}/transfer"'
		class="btn btn-primary">
</div>

<div id='BANKCARD' style='display: none;'>
	In the next step you have to provide details of bank card <br /> <input
		type="button" value="Enter details of bank card"
		onClick='location.href="/invest/sendMoney/${account.id}/bankcard" '
		class="btn btn-primary">
</div>
<br />



<script>
	function Selected(a) {
		var label = a.value;
		if (label == 1) {
			document.getElementById("DATACHEK").style.display = 'block';
			document.getElementById("TRANSFER").style.display = 'none';
			document.getElementById("BANKCARD").style.display = 'none';
		} else if (label == 2) {
			document.getElementById("DATACHEK").style.display = 'none';
			document.getElementById("TRANSFER").style.display = 'block';
			document.getElementById("BANKCARD").style.display = 'none';
		} else {
			document.getElementById("DATACHEK").style.display = 'none';
			document.getElementById("TRANSFER").style.display = 'none';
			document.getElementById("BANKCARD").style.display = 'block';
		}

	}
</script>


