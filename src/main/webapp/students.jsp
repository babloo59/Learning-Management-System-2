<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="templates/header.jsp"/>

<h3>Enrolled Students</h3>

<table class="table table-bordered mt-3">
<tr>
  <th>ID</th>
  <th>Username</th>
  <th>Role</th>
</tr>

<c:forEach var="u" items="${students}">
<tr>
  <td>${u.id}</td>
  <td>${u.username}</td>
  <td>${u.role}</td>
</tr>
</c:forEach>

</table>

<jsp:include page="templates/footer.jsp"/>
