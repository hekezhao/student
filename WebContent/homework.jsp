<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.net.*,java.sql.Timestamp,java.text.*,bean.Homework" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>作业</title>
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
  		<li class="active"><a>作业</a></li>
	</ul>
	<%ArrayList<Homework> allHomework=(ArrayList<Homework>) session.getAttribute("homeworkList");
	if(allHomework.size()==0){ %>
		<h4>暂无作业</h4>
	<%}
	else{	
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		for(int i=0;i<allHomework.size();i++){ %>
		<div class="panel panel-info">
    		<div class="panel-heading">
        		<h3 class="panel-title">
        			<a href="/student/submit?cno=<%=allHomework.get(i).getCno() %>&term=<%=allHomework.get(i).getTerm() %>&sno=<%=allHomework.get(i).getSno() %>&tno=<%=allHomework.get(i).getTno() %>&title=<%=URLEncoder.encode(allHomework.get(i).getTitle(),"UTF-8") %>"><%=allHomework.get(i).getTitle() %></a>
        		</h3>
    		</div>
    		<div class="panel-body">
    			<p>开始时间：<%=df.format(allHomework.get(i).getBeginTime()) %></p>
      			<span>截止时间：<%=df.format(allHomework.get(i).getEndTime()) %></span>
      			<%Date date = new Date();       
      			Timestamp now = new Timestamp(date.getTime());
      			if(now.before(allHomework.get(i).getEndTime())) {  %>
      				<span>
      				<input type="submit" style="border-radius:5px;border-style:none;background-color:DeepSkyBlue;color:white" onclick="window.location.href='/student/delay.jsp?cno=<%=allHomework.get(i).getCno() %>&term=<%=allHomework.get(i).getTerm() %>&sno=<%=allHomework.get(i).getSno() %>&tno=<%=allHomework.get(i).getTno() %>&workTitle=<%=URLEncoder.encode(allHomework.get(i).getTitle(),"UTF-8") %>'" value="延期" />
      				</span>
      			<%} %>
    		</div>
    		<div class="panel-footer">
    			<input style="border-radius:5px;border-style:none;background-color:MediumSeaGreen;color:white" type="submit" onclick="window.location.href='/student/submit?cno=<%=allHomework.get(i).getCno() %>&term=<%=allHomework.get(i).getTerm() %>&sno=<%=allHomework.get(i).getSno() %>&tno=<%=allHomework.get(i).getTno() %>&title=<%=URLEncoder.encode(allHomework.get(i).getTitle(),"UTF-8") %>'" value="查看" />
  				<span style="color:red;float:right">
    			<%if(allHomework.get(i).getScore()!=0){ %>
    				<%=allHomework.get(i).getScore() %>分
    			<%} %>
    			</span>
    		</div>
		</div>
		<%} 
	} %>
</div>
</body>
</html>