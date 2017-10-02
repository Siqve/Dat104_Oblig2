<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Velkommen</title>
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
				<c:choose>
					<c:when test="${requestScope.loginmethod eq 'participant'}">
						<li><a href="register"><span class="glyphicon glyphicon-user"></span>
								Meld deg på</a></li>
						<li><a href="?cashier"><span
								class="glyphicon glyphicon-log-in"></span> Kasserer Login</a></li>
					</c:when>

					<c:when test="${requestScope.loginmethod eq 'cashier'}">
						<li><a href="."><span class="glyphicon glyphicon-log-in"></span>
								Deltaker Login</a></li>
					</c:when>
				</c:choose>
			</ul>
		</div>
	</nav>
	<div class="container">
		<h1 style="text-align: center">
		
		<c:out value="${requestScope.logintext}" />
		
		</h1>
		<div style="width: 20%; margin: 20px auto">
			<form action="./" method="POST">
				<input type="hidden" name="cashier" value="${requestScope.loginmethod eq 'cashier'}">
				<div class="form-group">
					<input name="${requestScope.inputtype}" type="password"
						placeholder="${requestScope.inputplaceholder}"
						class="form-control">
				</div>
				<div class="checkbox">
					<label><input type="checkbox" name="remember" value="1">Husk
						meg</label>
				</div>
				<input type="submit" value="Logg inn"
					class="btn btn-lg btn-primary btn-block" />
			</form>
			<c:if test="${not empty flash}">
				<div style="margin-top: 10px"
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