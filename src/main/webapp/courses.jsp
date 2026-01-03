<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="templates/header.jsp"/>

<h3>Available Courses</h3>

<table class="table table-bordered table-hover mt-3">
<tr>
  <th>ID</th>
  <th>Title</th>
  <th>Description</th>
  <th>Action</th>
</tr>

<c:forEach var="c" items="${courses}">
<tr>
  <td>${c.id}</td>
  <td>${c.title}</td>
  <td>${c.description}</td>

  <td>
    <c:if test="${sessionScope.user.role eq 'STUDENT'}">
      <form action="enroll" method="post">
        <input type="hidden" name="courseId" value="${c.id}">
        <input type="submit" value="Enroll" class="btn btn-success btn-sm">
      </form>
    </c:if>

    <c:if test="${sessionScope.user.role eq 'ADMIN'}">
      <a href="students?courseId=${c.id}" class="btn btn-info btn-sm">
        View Students
      </a>
    </c:if>
  </td>
</tr>
</c:forEach>

</table>

<c:if test="${sessionScope.user.role eq 'ADMIN'}">
<hr>
<h4>Add Course (Admin)</h4>

<form action="courses" method="post" class="card p-3 shadow">
  <input type="text" name="title" placeholder="Title" class="form-control mb-2" required>
  <input type="text" name="description" placeholder="Description" class="form-control mb-2" required>
  <button class="btn btn-primary">Add Course</button>
</form>
</c:if>

<jsp:include page="templates/footer.jsp"/>
