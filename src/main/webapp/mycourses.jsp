<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="templates/header.jsp"/>

<h3>My Enrolled Courses</h3>

<table class="table table-striped mt-3">
<tr>
  <th>ID</th>
  <th>Title</th>
  <th>Description</th>
  <th>Action</th>
</tr>

<c:choose>
  <c:when test="${not empty courses}">
    <c:forEach var="c" items="${courses}">
      <tr>
        <td>${c.id}</td>
        <td>${c.title}</td>
        <td>${c.description}</td>
        <td>
          <form action="unenroll" method="post">
            <input type="hidden" name="courseId" value="${c.id}">
            <input type="submit" value="Withdraw" class="btn btn-danger btn-sm">
          </form>
        </td>
      </tr>
    </c:forEach>
  </c:when>

  <c:otherwise>
    <tr>
      <td colspan="4">No courses enrolled</td>
    </tr>
  </c:otherwise>
</c:choose>

</table>

<jsp:include page="templates/footer.jsp"/>
