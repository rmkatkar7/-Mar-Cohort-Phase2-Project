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
			<h3 class="text-center">Add Subjects and Teachers to <%=cname %> </h3>
			<hr>

			<br>
<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				
					<form action="stcinsert" method="post">
						<input type="hidden" name="cname"
						value=<%=cname %> />
						<input type="hidden" name="cid"
						value=<%=cid%> />
				<fieldset class="form-group">
					<label for="Class">Select Subject</label> <select name="subject">
						<option value="none" selected disabled hidden>Select an Option </option>
					
						
						<c:forEach var="subject" items="${listSubject}">	
							
								<option value="<c:out value='${subject.sub_name}'/>">
									<c:out value='${subject.sub_name}' /></option>	
					</c:forEach>
					</select>	
				</fieldset>	
				<fieldset class="form-group">
					<label for="Class">Select Teacher</label> <select name="teacher">
						<option value="none" selected disabled hidden>Select an Option </option>
					
						<c:forEach var="teacher" items="${listTeacher}">
							<option value="<c:out value='${teacher.fname}'/>">
									<c:out value='${teacher.fname}' /></option>
						</c:forEach>
					
					</select>
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
	<br>
	<br>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
		
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="background-color:#87CEFA">S.No.</th>
						<th style="background-color:#87CEFA">Subject</th>
						<th style="background-color:#87CEFA">Teacher Name</th>
						<th style="background-color:#87CEFA">Actions</th>
					</tr>
				</thead>
				<tbody>
				<%!int i=0; %>
					<c:forEach var="classReport" items="${listClassReport}">

						<tr>
							<td><c:out value="<%=++i%>" /></td>
							<td><c:out value="${classReport.subjectName}" /></td>
							<td><c:out value="${classReport.teacherFname}" /></td>
							<td><a href="stcdelete?id=<c:out value='${classReport.id}' />&cid=<%=cid %>">Delete</a></td>					
								
						</tr>
					</c:forEach>
					<%i=0;%>
				</tbody>

			</table>
		</div>
	</div>
	
</body>
</html>