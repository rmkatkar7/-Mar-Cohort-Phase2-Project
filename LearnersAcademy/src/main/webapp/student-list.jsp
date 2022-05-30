<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<%
  response.setHeader("cache-control","no-cache,no-store,must-revalidate");
  if (session.getAttribute("admin")==null){
	  response.sendRedirect("index.jsp");
  }
 
 %>
	<jsp:include page="navbar.jsp" /> 
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Students</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/snew" class="btn btn-success">Add
					New Student</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="background-color:#87CEFA">ID</th>
						<th style="background-color:#87CEFA">First Name</th>
						<th style="background-color:#87CEFA">Last Name</th>
						<th style="background-color:#87CEFA">DOB</th>
						<th style="background-color:#87CEFA">Address</th>
						<th style="background-color:#87CEFA">Phone</th>
						<th style="background-color:#87CEFA">Class</th>
						<th style="background-color:#87CEFA">Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="student" items="${listStudent}">

						<tr>
							<td><c:out value="${student.id}" /></td>
							<td><c:out value="${student.fname}" /></td>
							<td><c:out value="${student.lname}" /></td>
							<td><c:out value="${student.dob}" /></td>
							<td><c:out value="${student.address.street}" /></td>
							<td><c:out value="${student.phone}" /></td>
							<td><c:out value="${student.class_map.class_name}" /></td>
							<td><a href="sedit?id=<c:out value='${student.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="sdelete?id=<c:out value='${student.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>