<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
<spring:url value="/resource/bootstrap.min.css" var="bootstrapCss" />
<link rel="stylesheet" href="${bootstrapCss}">
</head>
<body>
	<spring:url value="/" var="homeUrl" />
	<spring:url value="/users/add" var="addUserUrl" />

	<div class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="${homeUrl}">Spring MVC Form</a>
			</div>
			<div id="navbar">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="${addUserUrl}">Add User</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>