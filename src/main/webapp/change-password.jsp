<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="templates/header.jsp" />

<h3>Change Password</h3>

<c:if test="${param.error eq 'old'}">
	<div class="alert alert-danger">Old password is incorrect</div>
</c:if>

<c:if test="${param.error eq 'match'}">
	<div class="alert alert-danger">New passwords do not match</div>
</c:if>

<c:if test="${param.success eq '1'}">
	<div class="alert alert-success">Password changed successfully</div>
</c:if>

<form action="changePassword" method="post" class="card p-4 shadow"
	style="max-width: 450px;">

	<div class="mb-2">
		<label>Old Password</label> <input type="password" name="oldPassword"
			class="form-control" required>
	</div>

	<div class="mb-2">
		<label>New Password</label> <input type="password" name="newPassword"
			class="form-control" required>
	</div>

	<div class="mb-3">
		<label>Confirm New Password</label> <input type="password"
			name="confirmPassword" class="form-control" required>
	</div>

	<button class="btn btn-warning">Change Password</button>
</form>

<jsp:include page="templates/footer.jsp" />
