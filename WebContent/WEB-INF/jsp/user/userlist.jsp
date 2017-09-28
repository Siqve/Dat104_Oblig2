<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table border="1">
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
				<td>${user.firstname } ${user.surname }</td>
				</tr>
			</c:forEach>
		</c:if>

	</table>
	<p>
		<a href="ferdig.html">Ferdig</a>
	</p>
</body>
</html>