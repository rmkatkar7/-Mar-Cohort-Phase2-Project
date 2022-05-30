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
			<h3 class="text-center">List of Subjects</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/subnew" class="btn btn-success">Add
					New Subject</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="background-color:#87CEFA">ID</th>
						<th style="background-color:#87CEFA">Subject Name</th>
						<th style="background-color:#87CEFA">Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="subject" items="${listSubject}">

						<tr>
							<td><c:out value="${subject.sub_id}" /></td>
							<td><c:out value="${subject.sub_name}" /></td>
							<td><a href="subedit?subid=<c:out value='${subject.sub_id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="subdelete?subid=<c:out value='${subject.sub_id}' />">Delete</a>
								</td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>