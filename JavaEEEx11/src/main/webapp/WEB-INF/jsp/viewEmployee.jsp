<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Employee</title>
</head>
<body>
	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Designation</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.id}</td>
				<td>${list.name}</td>
				<td>${list.salary}</td>
				<td>${list.designation}</td>
				<td><a href="editemp/${list.id}">Edit</a></td>
				<td><a href="deleteemp/${list.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="employeeform">Add New Employee</a>
</body>
</html>