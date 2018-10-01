<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sign in</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.min.css">
</head>
<body>
	<div style="width: 300px; margin-left: 300px; padding-top: 200px;">
		<form action="/login" method="post">
			<h1 class="h3 mb-3 font-weight-normal">Sign in</h1>
			<label for="inputEmail" class="sr-only">Email</label> <input
				type="email" id="email" name="email" class="form-control"
				placeholder="Email" required autofocus> <label
				for="inputPassword" class="sr-only">Password</label> <input
				type="password" id="password" name="password" class="form-control"
				placeholder="Password" required>
			<div class="checkbox mb-3">
				<label> <input type="checkbox" name="remember-me" />
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
			<div class="margin-top20 text-center">
				Don't have an account? <a th:href="@{/signup}">Create an account</a>
			</div>
		</form>
	</div>



</body>
</html>