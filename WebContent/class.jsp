<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,bean.Class" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>课程</title>
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
	<%ArrayList<Class> allClass=(ArrayList<Class>) session.getAttribute("classList");
	for(int i=0;i<allClass.size();i++){%>
	<div class="panel panel-primary">
    	<div class="panel-heading">
        	<h3 class="panel-title">
        		<a href="/student/homework?cno=<%=allClass.get(i).getCno() %>&term=<%=allClass.get(i).getTerm() %>&sno=<%=allClass.get(i).getSno() %>&tno=<%=allClass.get(i).getTno() %>"><%=allClass.get(i).getCname() %></a>
        	</h3>
    	</div>
    	<div class="panel-body">
    		<p><%=allClass.get(i).getTname() %></p>
      		<p><%=allClass.get(i).getTerm() %></p>
    	</div>
	</div>
	<%} %>
</div>
</body>
</html>