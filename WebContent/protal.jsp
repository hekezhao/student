<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>首页</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
		.content{
			margin-left:250px;
			margin-right:250px;
		}
	</style>
</head>
<body>
<div class="content">
	<ul class="nav nav-tabs">
  		<li class="active"><a><%=session.getAttribute("sname") %></a></li>
	</ul>
	<ul class="nav nav-pills nav-stacked" style="text-align:center">
        <li><a href="/student/class?sno=<%=session.getAttribute("sno") %>">课程</a></li>
        <li><a href="/student/inform?sno=<%=session.getAttribute("sno") %>">收件箱</a></li>
    </ul>
 </div>
</body>
</html>