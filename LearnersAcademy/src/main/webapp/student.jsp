<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student</title>
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


	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${student != null}">
					<form action="supdate" method="post">
				</c:if>
				<c:if test="${student == null}">
					<form action="sinsert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${student != null}">
            			Edit Student
            		</c:if>
						<c:if test="${student == null}">
            			Add New Student
            		</c:if>
					</h2>
				</caption>

				<c:if test="${student != null}">
					<input type="hidden" name="id"
						value="<c:out value='${student.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>First Name</label> <input type="text"
						value="<c:out value='${student.fname}' />" class="form-control"
						name="fname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Last Name</label> <input type="text"
						value="<c:out value='${student.lname}' />" class="form-control"
						name="lname">
				</fieldset>
				<fieldset class="form-group">
					<label>DOB</label> <input type="date"
						value="<c:out value='${student.dob}' />" class="form-control"
						name="dob" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${student.address.street}' />"
						class="form-control" name="street">
				</fieldset>

				<fieldset class="form-group">
					<label>Phone</label> <input type="tel" placeholder="1234567890"
						pattern="[0-9]{10}" value="<c:out value='${student.phone}' />"
						class="form-control" name="phone">
				</fieldset>
				
				<fieldset class="form-group">
					<label for="Class">Select class</label> <select name="class">
					<c:if test="${student!=null }">
						<option value="<c:out value='${student.class_map.cid}'/>"><c:out
								value='${student.class_map.class_name}' /></option>
					</c:if>
					<c:if test="${student==null }">
						<option value="none" selected disabled hidden>Select an Option </option>
					</c:if>
						
						<c:forEach var="classes" items="${listClass}">
							<c:if test="${student.class_map.cid!=classes.cid}">
								<option value="<c:out value='${classes.cid}'/>">
									<c:out value='${classes.class_name}' /></option>
							</c:if>

						</c:forEach>
					</select>
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>