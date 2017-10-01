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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div style="width: 40%; margin: 10px auto">
			<h1>Betalingsoversikt:</h1>
			<div style="width: 50%">
				<table class="table">
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
									<td>${user.firstname }&nbsp;${user.surname }</td>
									<td>${user.phonenumber}</td>
									<td style="text-align: center;"><c:choose>
											<c:when test="${user.paid eq true}">
												<c:out value="Betaling mottatt." />
											</c:when>

											<c:otherwise>
												<form method="post">
													<input type="submit" name="pay" value="Registrer betaling"
														class="btn btn-sm btn-default btn-block"> <input
														type="hidden" name="payer" value="${user.phonenumber}" />
												</form>
											</c:otherwise>
										</c:choose>
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
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