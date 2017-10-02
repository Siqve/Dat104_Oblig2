<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deltakerliste</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Fest!</a>
			</div>
		</div>
	</nav>
	<div class="container">
		<div style="width: 40%; margin: 10px auto">
			<h1 style="text-align: center">Heisann ${activeUser.firstname }!</h1>
			<h3 style="text-align: center">Dette er deltakerene så langt:</h3>
			<div style="width: 50%; margin: auto">
				<table border="1" style="width: 100%">
					<tr bgcolor="#cccccc">
						<th>Kjønn</th>
						<th align="left">Navn</th>
					</tr>

					<c:if test="${not empty requestScope.users }">
						<c:forEach items="${requestScope.users }" var="user">
							<!-- 			tr if-else  -->
							<c:choose>
								<c:when test="${user.paid==true}">
									<tr bgcolor="#ffaaaa">
								</c:when>
								<c:otherwise>
									<tr bgcolor="#b1ffaa">
								</c:otherwise>
							</c:choose>
							<!-- 				td if-else -->
							<c:choose>
								<c:when test="${user.sex=='male'}">
									<td align="center">&#9794;</td>
								</c:when>
								<c:otherwise>
									<td align="center">&#9792;</td>
								</c:otherwise>
							</c:choose>
							<td>${user.firstname }${user.surname }</td>
							</tr>
						</c:forEach>
					</c:if>

				</table>
				<form method="post" style="margin-top: 10px;">
					<input type="submit" name="logout" value="Ferdig"
						class="btn btn-lg btn-primary btn-block" />
				</form>
			</div>

		</div>
	</div>
</body>
</html>