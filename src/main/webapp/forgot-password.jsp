<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>

<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
    rel="stylesheet">
</head>
<body>

<div class="container mt-5" style="max-width:450px;">
<h3 class="text-center mb-3">Reset Password</h3>

<%
String err = request.getParameter("error");
if ("user".equals(err)) {
%>
<div class="alert alert-danger">Invalid username or email</div>
<%
}
if ("match".equals(err)) {
%>
<div class="alert alert-danger">Passwords do not match</div>
<%
}
if ("success".equals(request.getParameter("success"))) {
%>
<div class="alert alert-success">Password reset successfully</div>
<%
}
%>
<form action="/forgotPassword" method="post" class="card p-4 shadow">

    <input type="email" name="email"
           placeholder="Registered Email"
           class="form-control mb-2" required>

    <input type="password" name="newPassword"
           placeholder="New Password"
           class="form-control mb-2" required>

    <input type="password" name="confirmPassword"
           placeholder="Confirm New Password"
           class="form-control mb-3" required>

    <button class="btn btn-warning w-100">Reset Password</button>
</form>

<div class="text-center mt-3">
    <a href="login.jsp">Back to Login</a>
</div>
</div>

</body>
</html>
