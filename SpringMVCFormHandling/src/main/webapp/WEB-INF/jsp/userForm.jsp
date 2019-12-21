<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="header.jsp" />
<spring:url value="/resources/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/bootstrap.min.js" var="bootstrapJs" />

<link rel="stylesheet" type="text/css" href="${bootstrapCss}" />
<script type="text/javascript" src="${bootstrapJs}"></script>
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${userForm['new']}">
				<h1>Add User</h1>
			</c:when>
			<c:otherwise>
				<h1>Update User</h1>
			</c:otherwise>
		</c:choose>
		<br />
		<spring:url value="/users" var="userActionUrl" />

		<form:form class="form-horizontal" action="${userActionUrl}"
			method="post" modelAttribute="userForm">
			<form:hidden path="id" />
			<spring:bind path="name">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Name</label>
					<div class="col-sm-10">
						<form:input path="name" type="text" class="form-control" id="name"
							placeholder="Name" />
						<form:errors path="name" class="control-label" />
					</div>
				</div>
			</spring:bind>

			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<form:input path="email" class="form-control" id="email"
							placeholder="Email" />
						<form:errors path="email" class="control-label" />
					</div>
				</div>
			</spring:bind>

			<spring:bind path="address">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Address</label>
					<div class="col-sm-10">
						<form:textarea path="address" rows="5" class="form-control"
							id="address" placeholder="address" />
						<form:errors path="address" class="control-label" />
					</div>
				</div>
			</spring:bind>

			<spring:bind path="frameworks">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Web Frameworks</label>
					<div class="col-sm-10">
						<form:checkboxes path="frameworks" items="${frameworkList}"
							element="label class='checkbox-inline'" />
						<br />
						<form:errors path="frameworks" class="control-label" />
					</div>
				</div>
			</spring:bind>

			<spring:bind path="country">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Country</label>
					<div class="col-sm-5">
						<form:select path="country" class="form-control">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${countryList}" />
						</form:select>
						<form:errors path="country" class="control-label" />
					</div>
					<div class="col-sm-5"></div>
				</div>
			</spring:bind>

			<spring:bind path="skills">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Java Skills</label>
					<div class="col-sm-5">
						<form:select path="skills" items="${javaSkillList}"
							multiple="true" size="5" class="form-control" />
						<form:errors path="skills" class="control-label" />
					</div>
					<div class="col-sm-5"></div>
				</div>
			</spring:bind>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<c:choose>
						<c:when test="${userForm['new']}">
							<button type="submit" class="btn-lg btn-primary pull-right">Add
							</button>
						</c:when>
						<c:otherwise>
							<button type="submit" class="btn-lg btn-primary pull-right">Update
							</button>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>