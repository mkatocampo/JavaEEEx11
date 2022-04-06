<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="edu.nbcc.model.*"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit employee</title>
</head>
<body>
<title>Edit Employee</title>
</head>
<body>
	<%Employee emp = (Employee)request.getAttribute("employee"); %>
	<form:form method="post" action="save" modelAttribute="employee">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" value="${emp.id}"/></td>
			</tr>
			<tr>
				<td><form:errors path="id" /></td>
			</tr>

			<tr>
				<td>Name:</td>
				<td><form:input path="name" value="${emp.name}"/></td>
			</tr>
			<tr>
				<td><form:errors path="name" /></td>
			</tr>

			<tr>
				<td>Salary:</td>
				<td><form:input path="salary"  value="${emp.salary}"/></td>
			</tr>
			<tr>
				<td><form:errors path="salary" /></td>
			</tr>

			<tr>
				<td>Designation:</td>
				<td><form:input path="designation"  value="${emp.designation}"/></td>
			</tr>
			<tr>
				<td><form:errors path="designation" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Save"/></td>
			</tr>
			
		</table>
	</form:form>
</body>
</html>