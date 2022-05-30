<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject</title>
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
				<c:if test="${subject != null}">
					<form action="subupdate" method="post">
				</c:if>
				<c:if test="${subject == null}">
					<form action="subinsert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${subject != null}">
            			Edit subject
            		</c:if>
						<c:if test="${subject == null}">
            			Add New subject
            		</c:if>
					</h2>
				</caption>

				<c:if test="${subject != null}">
					<input type="hidden" name="subid"
						value="<c:out value='${subject.sub_id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Subject Name</label> <input type="text"
						value="<c:out value='${subject.sub_id}' />" class="form-control"
						name="subname" required="required">
				</fieldset>

				
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>