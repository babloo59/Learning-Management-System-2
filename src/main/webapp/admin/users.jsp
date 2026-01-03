<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Users</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet">
</head>
<body>

<div class="container mt-4">
<h3>Manage Users</h3>

<table class="table table-bordered">
<tr>
    <th>ID</th>
    <th>Username</th>
    <th>Email</th>
    <th>Role</th>
    <th>Status</th>
    <th>Action</th>
</tr>

<c:forEach var="u" items="${users}">
<tr>
    <td>${u.id}</td>
    <td>${u.username}</td>
    <td>${u.email}</td>
    <td><span class="badge bg-secondary">${u.role}</span></td>
    <td>
        <span class="badge ${u.status eq 'ACTIVE' ? 'bg-success' : 'bg-danger'}">
            ${u.status}
        </span>
    </td>
    <td>
        <div class="d-flex gap-2">
            <form action="updateUserStatus" method="post" style="display:inline;">
                <input type="hidden" name="userId" value="${u.id}">
                <input type="hidden" name="status" 
                       value="${u.status eq 'ACTIVE' ? 'DEACTIVE' : 'ACTIVE'}">
                <button type="submit" class="btn btn-sm ${u.status eq 'ACTIVE' ? 'btn-outline-danger' : 'btn-outline-success'}">
                    ${u.status eq 'ACTIVE' ? 'Deactivate' : 'Activate'}
                </button>
            </form>

            <form action="updateUserRole" method="post" style="display:inline;">
                <input type="hidden" name="userId" value="${u.id}">
                <select name="newRole" onchange="this.form.submit()" class="form-select form-select-sm">
                    <option value="STUDENT" ${u.role eq 'STUDENT' ? 'selected' : ''}>Student</option>
                    <option value="ADMIN" ${u.role eq 'ADMIN' ? 'selected' : ''}>Admin</option>
                </select>
            </form>
        </div>
    </td>
</tr>
</c:forEach>

</table>

<a href="dashboard.jsp">Back</a>
</div>

</body>
</html>
