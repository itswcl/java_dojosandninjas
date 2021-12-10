<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

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
		<h1>New Dojo</h1>
		<a href="/">Home</a>
		<!-- ADD NEW CLASS FORM -->
		<form:form class="form" action="/dojos/new" method="post" modelAttribute="dojo">
    		<p>
       			<form:label path="name">Name: </form:label>
     			<form:input path="name"/>
      			<form:errors path="name"/>
    		</p>

    		<input type="submit" value="create"/>
		</form:form>

	</div>
	
</body>
</html>