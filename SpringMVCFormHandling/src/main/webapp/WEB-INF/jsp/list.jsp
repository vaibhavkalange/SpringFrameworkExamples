<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/bootstrap.min.css" var="bootstrapCss"/>
<spring:url value="/resources/bootstrap.min.js" var="bootstrapJs"/>
	
<link rel="stylesheet" type="text/css" href="${bootstrapCss}"/>
<script type="text/javascript" src="${bootstrapJs}"></script>

<jsp:include page="header.jsp"/>
</head>

<body>
	<div class="container">
		<c:if test="${not empty msg}">
		    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" 
                                aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		    </div>
		</c:if>
		<h1>All Users</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>User Name</th>
					<th>Email</th>
					<th>Address</th>
					<th>Frameworks</th>
					<th>Actions</th>
				</tr>
			</thead>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.address}</td>
					<td><c:forEach var="framework" items="${user.frameworks}"
							varStatus="loop"> 
							${framework}<c:if test="${not loop.last}">, </c:if>
						</c:forEach></td>
					<td><spring:url value="users/${user.id}" var="userUrl" /> <spring:url
							value="users/${user.id}/delete" var="userDelete" /> <spring:url
							value="users/${user.id}/update" var="userUpdate" />
						<button class="btn btn-info" onclick="location.href='${userUrl}'">Query</button>
						<button class="btn btn-primary"
							onclick="location.href='${userUpdate}'">Update</button>
						<button class="btn btn-danger"
							onclick="location.href='${userDelete}'">Delete</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>