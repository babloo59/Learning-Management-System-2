<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%
	if ("email".equals(request.getParameter("error"))) {
	%>
	<div class="alert alert-danger text-center">Email already
		registered</div>
	<%
	}
	%>
	<%
	if ("pass".equals(request.getParameter("error"))) {
	%>
	<div class="alert alert-danger text-center">Passwords do not
		match</div>
	<%
	}
	%>

	<div class="container mt-5" style="max-width: 450px;">
		<h3 class="text-center mb-3">Student Registration</h3>

		<form action="register" method="post" class="card p-4 shadow">

			<select name="role" class="form-select mb-3" required>
				<option value="">-- Select Role --</option>
				<option value="STUDENT">Student</option>
				<option value="ADMIN">Admin</option>
			</select> <input type="text" name="fullName" placeholder="Full Name"
				class="form-control mb-2" required> <input type="email"
				name="email" placeholder="Email" class="form-control mb-2" required>

			<input type="text" name="phone" placeholder="Phone"
				class="form-control mb-2" required> <input type="password"
				name="password" placeholder="Password" class="form-control mb-2"
				required> <input type="password" name="confirmPassword"
				placeholder="Confirm Password" class="form-control mb-3" required>

			<button class="btn btn-success w-100">Register</button>
		</form>

		<div class="text-center mt-3">
			<a href="login.jsp">Already registered? Login</a>
		</div>
	</div>

</body>
</html>
