<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
	<div align="justify"><br><br><br><br>
	<h1 align="center">Welcome to Learners Academy</h1>
	<br><br><br><br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			
				
					<form action="login" method="post">
				
				<fieldset class="form-group">
					<label>User Name</label> <input type="text" class="form-control" name="username" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Password</label> <input type="password" class="form-control" name="password" required="required">
				</fieldset>

				
				<button type="submit" class="btn btn-success">Login</button>
				</form>
			</div>
		</div>
	</div>
	<%
	String invalid;
	try {
		invalid = (String) session.getAttribute("invalid");
		if (invalid!=null) {
			out.println("<center><span style='color:red'>Incorrect username or password</SPAN></center>");
			session.removeAttribute("invalid");
		}
	} catch (Exception e) {
		out.print(e.getMessage());
		out.print("Something went wrong");
	}
	%>
</div>
</body>
</html>