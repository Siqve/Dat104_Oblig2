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
			<ul class="nav navbar-nav navbar-right">
				<li><p class="navbar-text">${activeUser.firstname } ${activeUser.surname }</p></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div style="width: 40%; margin: 10px auto">
			<h3 style="text-align: center">Dette er deltakerene så langt:</h3>
			<div style="width: 50%; margin: auto">
				<table class="table" style="width: 100%">
					<thead class="thead-default">
						<tr bgcolor="#cccccc">
							<th>Kjønn</th>
							<th>Navn</th>
						</tr>
					</thead>
					<c:if test="${not empty requestScope.users }">
						<c:forEach items="${requestScope.users }" var="user">
							<!-- 			tr if-else  -->
							<c:choose>
								<c:when test="${user.phonenumber == activeUser.phonenumber}">
									<c:choose>
										<c:when test="${user.paid==true}">
											<tr bgcolor="#b1ffaa">
										</c:when>
										<c:otherwise>
											<tr bgcolor="#ffaaaa">
											</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<tr>
								</c:otherwise>
							</c:choose>
							<!-- 				td if-else -->
							<c:choose>
								<c:when test="${user.sex=='male'}">
									<td align="center">&#9792;</td>
								</c:when>
								<c:otherwise>
									<td align="center">&#9794;</td>
								</c:otherwise>
							</c:choose>
							<td style="padding-left: 10px">${user.firstname} ${user.surname }</td>
							</tr>
						</c:forEach>
					</c:if>

				</table>
				<form method="post" style="margin-top: 10px;">
					<input type="submit" name="logout" value="Ferdig"
						class="btn btn-md btn-primary btn-block" />
				</form>
			</div>

		</div>
	</div>
</body>
</html>