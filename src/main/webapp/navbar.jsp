<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/clist">Classes</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/slist">Students</a></li>
				<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/sublist">Subjects</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/tlist">Teachers</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/logout">Logout</a>
				</li>
				
			</ul>
		</nav>
	</header>
</html>