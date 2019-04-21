<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<h1 style="padding-left: 106px;">CSV Data</h1>
	<input class="form-control" id="myInput" type="text" placeholder="Search..">
	<table
		class="table table-striped table-bordered table-hover table-condensed"
		style="margin-left: 106px; margin-top: 45px; width: 64%">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>ID1</th>
			<th>ID2</th>
		</tr>
		<tbody>
			<c:forEach items="${csvfile}" var="filedata">
				<tr>
					<td>${filedata.firstName}</td>
					<%-- <th>${filedata.lastName}</th>
					<td>${filedata.id}</td>
					<th>${filedata.id2}</th> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>