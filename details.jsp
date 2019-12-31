<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.sql.Timestamp,java.text.*,bean.Inform" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>通知</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%Inform inform=(Inform) session.getAttribute("inform"); %>
	<div class="page-header">
    	<h3><%=inform.getTitle() %></h3>
	</div>
	<p class="lead"><%=inform.getTxt() %></p>
</body>
</html>