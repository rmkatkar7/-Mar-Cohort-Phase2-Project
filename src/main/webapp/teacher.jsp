<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Teacher</title>
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
				<c:if test="${teacher != null}">
					<form action="tupdate" method="post">
				</c:if>
				<c:if test="${teacher == null}">
					<form action="tinsert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${teacher != null}">
            			Edit Teacher
            		</c:if>
						<c:if test="${teacher == null}">
            			Add New Teacher
            		</c:if>
					</h2>
				</caption>

				<c:if test="${teacher != null}">
					<input type="hidden" name="id"
						value="<c:out value='${teacher.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>First Name</label> <input type="text"
						value="<c:out value='${teacher.fname}' />" class="form-control"
						name="fname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Last Name</label> <input type="text"
						value="<c:out value='${teacher.lname}' />" class="form-control"
						name="lname">
				</fieldset>
				<fieldset class="form-group">
					<label>DOB</label> <input type="date"
						value="<c:out value='${teacher.dob}' />" class="form-control"
						name="dob" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${teacher.address.street}' />"
						class="form-control" name="street">
				</fieldset>

				<fieldset class="form-group">
					<label>Phone</label> <input type="tel" placeholder="1234567890"
						pattern="[0-9]{10}" value="<c:out value='${teacher.phone}' />"
						class="form-control" name="phone">
				</fieldset>
				
				<fieldset class="form-group">
					<label for="Class">Select Designation</label> <select name="designation">
					<c:if test="${teacher!=null }">
						<option value="<c:out value='${teacher.designation}'/>"><c:out
								value='${teacher.designation}' /></option>
					</c:if>
					<c:if test="${teacher==null }">
						<option value="none" selected disabled hidden>Select an Option </option>
					</c:if>
							<option value="Adjunct professor">Adjunct professor</option>
						    <option value="Visiting professor">Visiting professor</option>
						    <option value="Assistant professor">Assistant professor</option>
						    <option value="Associate professor">Associate professor</option>
						    <option value="Full professor">Full professor</option>
					</select>
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

<!-- 
<div align="center">
	<h1>Add new Teacher</h1>
		<form action="teacher" method="post">
			<table>
				<tr>
					<td>First Name*</td><td><input type="text" name="fname" required="required"></td>
					<td></td><td></td><td></td>
					<td>Last Name*</td><td><input type="text" name="lname" required="required"></td>
				</tr>
				<tr>
					<td>Date of birth*</td><td><input type="date" name="dob" required="required"></td>
					<td></td><td></td><td></td>
					<td>Designation*</td>
					<td>
						<select name="designation">
						    <option value="Adjunct professor">Adjunct professor</option>
						    <option value="Visiting professor">Visiting professor</option>
						    <option value="Assistant professor">Assistant professor</option>
						    <option value="Associate professor">Associate professor</option>
						    <option value="Full professor">Full professor</option>
					 	 </select>
					</td>
				</tr>
				<tr>
					<td>D.No*</td><td><input type="text" name="dno" required="required"></td>
					<td></td><td></td><td></td>
					<td>Street*</td><td><input type="text" name="street" required="required"></td>
				</tr>
				<tr>
					<td>city*</td><td><input type="text" name="city" required="required"></td>
					<td></td><td></td><td></td>
					<td>State*</td><td><input type="text" name="state" required="required"></td>
				</tr>
				<tr><td>Zipcode*</td><td><input type="text" name="zipcode" required="required"></td>
				<td></td><td></td><td></td>
				<td><label for="phone">Phone</label></td><td><input type="tel" name="phone" placeholder="1234567890" pattern="[0-9]{10}"></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td></td><td><input type="submit" value="Submit"></td>
					<td></td>
					<td></td>
					<td></td><td><input type="Button" value="Cancel"></td>
				</tr>
			</table>
		</form>
	</div>

 -->
	
</body>
</html>