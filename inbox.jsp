<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.sql.Timestamp,java.text.*,bean.Inform" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>收件箱</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<ul class="nav nav-tabs">
  		<li class="active"><a>通知</a></li>
	</ul>
	<%ArrayList<Inform> allInform=(ArrayList<Inform>) session.getAttribute("informList");
	if(allInform.size()==0){ %>
		<h4>暂无通知</h4>
	<%}else{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
		<ul class="nav nav-pills nav-stacked">
		<%for(int i=0;i<allInform.size();i++){ %>
			<li><a href="/student/informdetails?sno=<%=allInform.get(i).getSno() %>&sendTime=<%=allInform.get(i).getSendTime() %>">
				<%if(allInform.get(i).getType()==1){ %>
					<span class="label label-primary">作业通知</span>
				<%} %>
				<%if(allInform.get(i).getType()==2){ %>
					<span class="label label-primary">课程通知</span>
				<%} %>
				<span><%=allInform.get(i).getTitle() %></span>
				<span style="float:right"><%=df.format(allInform.get(i).getSendTime()) %></span>
			</a></li>
		<%} %>
		</ul>
	<%} %>
</body>
</html>