<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%
	if ("1".equals(request.getParameter("deactivated"))) {
	%>
	<div class="alert alert-warning text-center">Your account has
		been deactivated.</div>
	<%
	}
	%>

	<%
	String uname = request.getParameter("username");
	if ("1".equals(request.getParameter("registered")) && uname != null) {
	%>
	<div class="alert alert-success text-center">
		Registration successful! Your username is: <b><%=uname%></b>
	</div>
	<%
	}

	if ("1".equals(request.getParameter("reset"))) {
	%>
	<div class="alert alert-success text-center">Password reset
		successful. Please login.</div>
	<%
	}
	%>

	<div class="container mt-5" style="max-width: 400px;">
		<h3 class="text-center mb-3">Login</h3>

		<form action="login" method="post" class="card p-4 shadow">

			<div class="mb-3">
				<label class="form-label">Email</label> <input type="email"
					name="email" class="form-control" required>
			</div>

			<div class="mb-3">
				<label class="form-label">Password</label> <input type="password"
					name="password" class="form-control" required>
			</div>

			<button class="btn btn-primary w-100">Login</button>
		</form>

		<div class="text-center mt-3">
			<a href="forgot-password.jsp">Forgot Password?</a>
		</div>

		<div class="text-center mt-2">
			<a href="register.jsp">New Student? Register here</a>
		</div>
	</div>

</body>
</html>
