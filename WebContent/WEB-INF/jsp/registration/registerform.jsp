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
	<div class="container">
		<h1 style="text-align: center">Registrer deg:</h1>
		<div style="width: 20%; margin: 20px auto">

			<form method="POST">
				<div class="form-group">
					<input name="firstname" type="text" placeholder="Fornavn"
						class="form-control">
				</div>
				<div class="form-group">
					<input name="surname" type="text" placeholder="Etternavn"
						class="form-control">
				</div>
				<div class="form-group">
					<input name="phonenumber" type="text" placeholder="Mobilnummer"
						class="form-control">
				</div>
				<label class="radio-inline">
					<input checked="checked" type="radio" name="sex">Mann
				</label> 
				<label class="radio-inline">
					<input type="radio" name="sex">Kvinne
				</label> 
				<input type="submit" value="Registrer meg!" class="btn btn-lg btn-primary btn-block" style="margin-top: 5px"/>
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