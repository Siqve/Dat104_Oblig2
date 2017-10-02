<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deltakerliste</title>
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
		</div>
	</nav>
	<div class="container">
		<div style="width: 40%; margin: 10px auto">
			<h1 style="text-align: center">Betalingsoversikt:</h1>
			<div>
				<table class="table" style="width: auto; margin: auto">
					<thead class="thead-default">
						<tr bgcolor="#cccccc">
							<th>Navn</th>
							<th>Mobil</th>
							<th>Betalingsstatus</th>
						</tr>
					</thead>

					<tbody>
						<c:if test="${not empty requestScope.participants }">
							<c:forEach items="${requestScope.participants }" var="user">

								<tr>
									<td style="vertical-align: middle">${user.firstname }&nbsp;${user.surname }</td>
									<td style="vertical-align: middle">
										<c:set var="nr" value="${user.phonenumber}" /> 
										${fn:substring(nr, 0, 3) }&nbsp;${fn:substring(nr, 3, 5) }&nbsp;${fn:substring(nr, 5, 8) }
									</td>
									<td style="text-align: center;">
										<form method="post">
												<input type="hidden" name="payer"
													value="${user.phonenumber}">
											<c:choose>
												<c:when test="${user.paid eq false}">
													<input type="submit" name="pay" value="Registrer betaling"
														class="btn btn-sm btn-danger btn-block">
												</c:when>
												<c:otherwise>
													<input type="submit" name="pay" value="Betaling registrert"
														class="btn btn-sm btn-success btn-block">
												</c:otherwise>
											</c:choose>
										</form>
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
				<form method="post" style="margin: 10px auto; width: 50%">
					<input type="submit" name="logout" value="Ferdig"
						class="btn btn-md btn-primary btn-block" />
				</form>
			</div>

		</div>
	</div>
</body>
</html>