<%@page import="com.bean.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
</head>
<body>
<%
  response.setHeader("cache-control","no-cache,no-store,must-revalidate");
  if (session.getAttribute("admin")==null){
	  response.sendRedirect("index.jsp");
  }
 
 %>
<jsp:include page="navbar.jsp" />
<br><br><br>
<div align="center">

</div>
<h1 align="center">Welcome to Admin Dashboard</h1>
 
<%
response.sendRedirect("clist");
%>
</body>
</html>