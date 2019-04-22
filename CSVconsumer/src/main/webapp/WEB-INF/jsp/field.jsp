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
<title>CSV Details</title>
</head>
<body>
	<h1 style="padding-left: 106px;">CSV Details</h1>
	<input class="form-control" id="myInput" type="text"
		placeholder="Search.." style="width: 150px; margin-left: 104px;">
	<table
		class="table table-striped table-bordered table-hover table-condensed"
		style="margin-left: 106px; margin-top: 45px; width: 64%">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>ID</th>
			<th>ID2</th>
		</tr>
		<tbody id="myTable">
			<c:forEach items="${csvdatalist}" var="csvdata">
				<tr>

					<th>${csvdata.firstName}</th>
					<td>${csvdata.lastName}</td>
					<td>${csvdata.id}</td>
					<th>${csvdata.id2}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		$(document).ready(function(){
		  $("#myInput").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#myTable tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
</script>
</body>

</html>