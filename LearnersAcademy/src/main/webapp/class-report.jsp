<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Class</title>
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
	<% String cname = request.getParameter("cname"); %>
	<% String cid = request.getParameter("cid"); %>
		<div class="container">
			<h3 class="text-center">Class Report of <%=cname %> </h3>
			<hr>

			<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
		
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="background-color:#87CEFA">S.No.</th>
						<th style="background-color:#87CEFA">Subject</th>
						<th style="background-color:#87CEFA">Teacher Name</th>
					</tr>
				</thead>
				<tbody>
				<%!int i=0; %>
					<c:forEach var="classReport" items="${listClassReport}">

						<tr>
							<td><c:out value="<%=++i%>" /></td>
							<td><c:out value="${classReport.subjectName}" /></td>
							<td><c:out value="${classReport.teacherFname}" /></td>	
						</tr>
					</c:forEach>
					<%i=0;%>
				</tbody>

			</table>
		</div>
		
		<h3 align="center">Students List</h3>
		<div class="container">
	<table class="table table-bordered">
				<thead>
					<tr>
						<th style="background-color:#87CEFA">ID</th>
						<th style="background-color:#87CEFA">First Name</th>
						<th style="background-color:#87CEFA">Last Name</th>
						<th style="background-color:#87CEFA">DOB</th>
						<th style="background-color:#87CEFA">Address</th>
						<th style="background-color:#87CEFA">Phone</th>
										
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
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
		

</body>
</html>