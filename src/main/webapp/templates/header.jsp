<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LMS</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">

			<a class="navbar-brand" href="dashboard.jsp">LMS</a>

			<ul class="navbar-nav me-auto">

				<!-- Courses -->
				<li class="nav-item"><a class="nav-link" href="courses">Courses</a>
				</li>

				<!-- Student only -->
				<c:if test="${sessionScope.user.role eq 'STUDENT'}">
					<li class="nav-item"><a class="nav-link" href="mycourses">My
							Courses</a></li>
				</c:if>

				<!-- Profile -->
				<li class="nav-item"><a class="nav-link" href="profile.jsp">Profile</a>
				</li>

				<!-- 🔥 ADMIN ONLY -->
				<c:if test="${sessionScope.user.role eq 'ADMIN'}">
					<li class="nav-item"><a class="nav-link" href="adminUsers">Manage
							Users</a></li>
				</c:if>

			</ul>

			<!-- Right side -->
			<c:if test="${not empty sessionScope.user}">
				<span class="text-white me-3"> ${sessionScope.user.username}
					(${sessionScope.user.role}) </span>
				<a href="logout" class="btn btn-outline-light btn-sm">Logout</a>
			</c:if>

		</div>
	</nav>

	<div class="container mt-4">