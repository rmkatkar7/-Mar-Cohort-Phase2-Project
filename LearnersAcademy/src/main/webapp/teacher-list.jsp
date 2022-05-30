<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
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
			<h3 class="text-center">List of Teachers</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/tnew" class="btn btn-success">Add
					New Teacher</a>
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
						<th style="background-color:#87CEFA">Designation</th>
						<th style="background-color:#87CEFA">Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="teacher" items="${listTeacher}">

						<tr>
							<td><c:out value="${teacher.id}" /></td>
							<td><c:out value="${teacher.fname}" /></td>
							<td><c:out value="${teacher.lname}" /></td>
							<td><c:out value="${teacher.dob}" /></td>
							<td><c:out value="${teacher.address.street}" /></td>
							<td><c:out value="${teacher.phone}" /></td>
							<td><c:out value="${teacher.designation}" /></td>
							<td><a href="tedit?id=<c:out value='${teacher.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="tdelete?id=<c:out value='${teacher.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>