<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class</title>
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
			<h3 class="text-center">List of Classes</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/cnew" class="btn btn-success">Add
					New Class</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="background-color:#87CEFA">ID</th>
						<th style="background-color:#87CEFA">Class Name</th>
						<th style="background-color:#87CEFA">Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="clas" items="${listClass}">

						<tr>
							<td><c:out value="${clas.cid}" /></td>
							<td><c:out value="${clas.class_name}" /></td>
							<td><a href="cedit?cid=<c:out value='${clas.cid}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="cdelete?cid=<c:out value='${clas.cid}' />">Delete</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="teacher-subject?cid=<c:out value='${clas.cid}' />&cname=<c:out value='${clas.class_name}' />">Subjects and Teachers</a>						
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="creport?cid=<c:out value='${clas.cid}' />&cname=<c:out value='${clas.class_name}' />">Class Report</a>
								</td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>