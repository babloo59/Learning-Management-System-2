<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="templates/header.jsp"/>

<c:if test="${param.denied eq '1'}">
  <div class="alert alert-danger">Access Denied: Admin only</div>
</c:if>

<h3>Welcome, ${sessionScope.user.username}</h3>
<p>Role: <strong>${sessionScope.user.role}</strong></p>

<hr>

<c:if test="${sessionScope.user.role eq 'STUDENT'}">
  <a href="mycourses" class="btn btn-primary btn-sm">My Courses</a>
  <br><br>
</c:if>

<a href="courses" class="btn btn-secondary btn-sm">View Courses</a>

<jsp:include page="templates/footer.jsp"/>
