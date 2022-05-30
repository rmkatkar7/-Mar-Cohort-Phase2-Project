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


	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${clas != null}">
					<form action="cupdate" method="post">
				</c:if>
				<c:if test="${clas == null}">
					<form action="cinsert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${clas != null}">
            			Edit Class
            		</c:if>
						<c:if test="${clas == null}">
            			Add New Class
            		</c:if>
					</h2>
				</caption>

				<c:if test="${clas != null}">
					<input type="hidden" name="cid"
						value="<c:out value='${clas.cid}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Class Name</label> <input type="text"
						value="<c:out value='${clas.class_name}' />" class="form-control"
						name="fname" required="required">
				</fieldset>

				
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>