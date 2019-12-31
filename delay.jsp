<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.net.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>延期</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="page-header">
    	<h2>延期申请</h2>
	</div>
	<form role="form" action="/student/delay?cno=<%=request.getParameter("cno") %>&term=<%=request.getParameter("term") %>&sno=<%=request.getParameter("sno") %>&tno=<%=request.getParameter("tno") %>&workTitle=<%=URLEncoder.encode(request.getParameter("workTitle"),"UTF-8") %>" method="post">
  		<div class="form-group">
    		<label for="name">延期原因：</label>
    		<textarea class="form-control" rows="3" name="reason" placeholder="请输入"></textarea>
    	</div>
    	<div class="form-group">
  			<label for="name">延期天数：</label>
    		<select class="form-control" name="delayDays">
      			<option>1</option>
      			<option>2</option>
      			<option>3</option>
      			<option>4</option>
      			<option>5</option>
      			<option>6</option>
      			<option>7</option>
    		</select>
    	</div>
    	<div align="center">
    		<input style="border-radius:5px;border-style:none;background-color:MediumSeaGreen;color:white;width:150px" type="submit" value="提交" />
    	</div>
	</form>
</body>
</html>