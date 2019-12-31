<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.net.*,java.sql.Timestamp,bean.Homework" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>作业</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
</head>
<body>
	<%Homework homework=(Homework) session.getAttribute("homework"); %>
	<div class="page-header">
    	<h3><%=homework.getTitle() %></h3>
	</div>
	<p class="lead"><%=homework.getTxt() %></p>
	<form action="/student/fileupload?cno=<%=homework.getCno() %>&term=<%=homework.getTerm() %>&sno=<%=homework.getSno() %>&tno=<%=homework.getTno() %>&title=<%=URLEncoder.encode(homework.getTitle(),"UTF-8") %>" enctype="multipart/form-data" method="post">
		<div class="form-group">
			<label for="name">我的答案</label>
			<p>
			<%if(homework.getAnswer()!=null){ %>
				<a href="/student/filedownload?filepath=<%=URLEncoder.encode(homework.getFilepath(),"UTF-8") %>"><%=homework.getAnswer() %></a>
			<%} %>
			</p>
			<%Date date = new Date();       
  			Timestamp now = new Timestamp(date.getTime());
  			if(now.before(homework.getEndTime())){ %>
			<table>			
			<tr>
				<td>上传附件：</td>
    			<td><input type="file" name="file" size="30"/></td>
    		</tr>
    		</table>
    		<br>
    		<input style="border-radius:5px;border-style:none;background-color:MediumSeaGreen;color:white" type="submit" value="提交" />
    		<%}else{ %>
    		<label for="name">教师批语</label>
    		<br>
    		<div class="well well-lg">
    			<%if(homework.getReply()!=null){ %>
    				<%=homework.getReply() %>
    			<%} %>
    		<%} %>
    		</div>
    	</div>
	</form>
</body>
</html>