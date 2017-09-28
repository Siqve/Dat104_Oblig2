<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Påmeldingsbekreftelse</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 style="text-align: center">Påmeldingsbekreftelse</h2>
		<div style="width: 20%; margin: 20px auto">
		<p>Påmeldingen er mottatt for</p>

		<c:if test="${not empty participant}">
			<p>
				<c:out value="${participant.firstname }" />
				<c:out value="${participant.surname }" />
				<br />
			<p>
				<c:out value="${participant.phonenumber }" />
			</p>
		</c:if>

		<p>
			<b>NB! Husk å betale til kassereren før festen!</b>
		</p>
		<a href="deltagerliste.html">Gå til deltagerlisten</a>
		</div>
	</div>
</body>
</html>