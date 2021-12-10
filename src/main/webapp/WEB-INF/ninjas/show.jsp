<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- Bootstrap JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>Dojos and Ninjas</title>
</head>
<body>
	
	<div class="container">
	<a href="/dojos/new">Add Dojo</a>
	<a href="/ninjas/new">Add Ninja</a>
		<!-- SHOW DATA WITH EDIT ROUTE / DELETE FORM-->
			<table class="table">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
					<th>Location</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ninja" items="${ ninjas }">
					<tr>
						<td><c:out value="${ ninja.first_name }" /></td>
						<td><c:out value="${ ninja.last_name }" /></td>
						<td><c:out value="${ ninja.age }" /></td>
						<td><c:out value="${ ninja.dojo.name }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	
</body>
</html>