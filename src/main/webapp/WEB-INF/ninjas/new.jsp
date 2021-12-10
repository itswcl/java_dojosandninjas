<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h1>New Ninja</h1>
		<a href="/">Home</a>

		<!-- ADD NEW CLASS FORM -->
		<form:form class="form" action="/ninjas/new" method="post"
			modelAttribute="ninja">
			<p>
				<form:label path="first_name">First Name: </form:label>
				<form:input path="first_name" />
				<form:errors path="first_name" />
			</p>
			<p>
				<form:label path="last_name">Last Name: </form:label>
				<form:input path="last_name" />
				<form:errors path="last_name" />
			</p>
			<p>
				<form:label path="age">Age: </form:label>
				<form:input path="age" />
				<form:errors path="age" />
			</p>
			<p>
				<form:label path="dojo">Dojo Location </form:label>
 				<form:select path="dojo">
					<c:forEach items="${ dojos }" var="dojo">
					<form:option value="${ dojo.id }">
						<c:out value="${ dojo.name }"/>
					</form:option>
					</c:forEach>
				</form:select> 
			</p>

			<input type="submit" value="create" />
		</form:form>

	</div>

</body>
</html>