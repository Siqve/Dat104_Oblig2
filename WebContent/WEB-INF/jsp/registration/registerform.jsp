<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Påmelding</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Fest!</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
				<li><a href="./"><span class="glyphicon glyphicon-log-in"></span> Deltaker Login</a></li>
				<li><a href="./?cashier"><span class="glyphicon glyphicon-log-in"></span> Kasserer Login</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<h1 style="text-align: center">Registrer deg:</h1>
		<div style="width: 20%; margin: 20px auto">

			<form method="POST">
				<div class="form-group">
				
				<c:if test="${not empty cookie.validFirstname.value}">
					<c:set value="${cookie.validFirstname.value }" var="valFirstname"/>
				</c:if>
				
				<c:if test="${not empty cookie.validSurname.value}">
					<c:set value="${cookie.validSurname.value }" var="valSurname"/>
				</c:if>
				
				<c:if test="${not empty cookie.validPhonenumber.value}">
					<c:set value="${cookie.validPhonenumber.value }" var="valPhone"/>
				</c:if>
				
					<input name="firstname" type="text" placeholder="Fornavn"
						class="form-control" value="${valFirstname}">
				</div>
				<div class="form-group">
					<input name="surname" type="text" placeholder="Etternavn"
						class="form-control" value="${valSurname}">
				</div>
				<div class="form-group">
					<input name="phonenumber" type="text" placeholder="Mobilnummer"
						class="form-control" value="${valPhone}">
				</div>
				<label class="radio-inline"> <input checked="checked"
					type="radio" name="sex" value="true">Mann
				</label> <label class="radio-inline"> <input type="radio" name="sex" value="false">Kvinne
				</label> <input type="submit" value="Registrer meg!"
					class="btn btn-lg btn-primary btn-block" style="margin-top: 5px" />
			</form>

			<c:if test="${not empty flash}">
				<div style="margin-top: 15px"
					class="alert alert-${flash} alert-dismissable fade in">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&timesd;</a>
					${flashmessage}
					<c:remove var="flash" scope="session" />
				</div>
			</c:if>
		</div>

	</div>
</body>
</html>