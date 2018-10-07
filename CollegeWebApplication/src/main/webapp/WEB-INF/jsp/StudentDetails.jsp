<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>StudentDetails</title>
</head>
<body>
	<h1 style="padding-left: 106px;">Student Data</h1>
	<table
		class="table table-striped table-bordered table-hover table-condensed"
		style="margin-left: 106px; margin-top: 45px; width: 64%">
		<tr>
			<th>Student Id</th>
			<th>Student Firstname</th>
			<th>Student Lastname</th>
			<th>Student Address</th>
		</tr>
		<tbody>
			<c:forEach items="${student}" var="studentdata">
				<tr>
					<td>${studentdata.id}</td>
					<th>${studentdata.firstname}</th>
					<td>${studentdata.lastname}</td>
					<th>${studentdata.address}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>