<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="templates/header.jsp" />

<h3>My Profile</h3>

<!-- Messages -->
<c:if test="${param.updated eq '1'}">
	<div class="alert alert-success">Profile updated successfully</div>
</c:if>

<c:if test="${param.perror eq 'old'}">
	<div class="alert alert-danger">Old password is incorrect</div>
</c:if>

<c:if test="${param.perror eq 'match'}">
	<div class="alert alert-danger">New passwords do not match</div>
</c:if>

<c:if test="${param.psuccess eq '1'}">
	<div class="alert alert-success">Password changed successfully</div>
</c:if>

<c:if test="${sessionScope.user.role eq 'STUDENT'}">
	<form action="deactivateAccount" method="post"
		onsubmit="return confirm('This will permanently deactivate your account. Continue?');">

		<button class="btn btn-danger mt-3">Delete My Account</button>
	</form>
</c:if>

<!-- ================= PROFILE VIEW / EDIT ================= -->
<div class="card p-4 shadow mb-4" style="max-width: 600px;">
	<h5>Profile Details</h5>

	<form action="updateProfile" method="post" id="profileForm">

		<div class="mb-2">
			<label>Username</label> <input type="text" class="form-control"
				value="${sessionScope.user.username}" disabled>
		</div>

		<div class="mb-2">
			<label>Role</label> <input type="text" class="form-control"
				value="${sessionScope.user.role}" disabled>
		</div>

		<div class="mb-2">
			<label>Full Name</label> <input type="text" name="fullName"
				value="${sessionScope.user.fullName}" class="form-control editable"
				disabled required>
		</div>

		<div class="mb-2">
			<label>Email</label> <input type="email" name="email"
				value="${sessionScope.user.email}" class="form-control editable"
				disabled required>
		</div>

		<div class="mb-3">
			<label>Phone</label> <input type="text" name="phone"
				value="${sessionScope.user.phone}" class="form-control editable"
				disabled required>
		</div>

		<!-- Buttons -->
		<button type="button" class="btn btn-secondary" id="editBtn">
			Edit Profile</button>

		<button type="submit" class="btn btn-primary d-none" id="updateBtn">
			Update Profile</button>
	</form>
</div>

<!-- ================= CHANGE PASSWORD ================= -->
<div class="card p-4 shadow" style="max-width: 600px;">
	<h5>Change Password</h5>

	<form action="changePassword" method="post">

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
</div>

<!-- ================= JS ================= -->
<script>
	document.getElementById("editBtn").addEventListener("click", function() {

		// enable editable fields
		document.querySelectorAll(".editable").forEach(function(el) {
			el.disabled = false;
		});

		// toggle buttons
		document.getElementById("editBtn").classList.add("d-none");
		document.getElementById("updateBtn").classList.remove("d-none");
	});
</script>

<jsp:include page="templates/footer.jsp" />
