<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得点項目編集画面</title>
<link rel="stylesheet" href="./css/update.css">
</head>
<body>
	<%@ include file="system.jsp" %>
	<%
request.setCharacterEncoding("UTF-8");
%>

	<div class=flex>
		<span id=s1>＜得点項目編集画面＞<br></span><br>
		<form action="adminselect.jsp" method="POST">
			<input id=button1 type="submit" value="メニューに戻る">
		</form>
		<br>
	</div>
	<span id=c1>・内容</span>

	<%if(request.getParameter("task_id")!=null){ %>
	<div class=flex>
		<span id=s3><%=request.getParameter("task_id")%></span>
		<form action="updateconfirmation.jsp" method="post">
			<textarea name="update_info" cols="45" rows="4"><%=request.getParameter("task_info")%></textarea>
	</div>


	<input type="hidden" name="task_id"
		value="<%=request.getParameter("task_id")%>">
	<input type="hidden" name="task_origin"
		value="<%=request.getParameter("task_info")%>">
	<input id=button2 type="submit" value="編集">
	</form>


	<%}else{%>
	<div class=flex>
	<span id=s3><%=request.getAttribute("task_id")%></span>
	<form action="updateconfirmation.jsp" method="post">
		<textarea name="update_info" cols="45" rows="4"><%=request.getAttribute("update_info")%></textarea>
		<br> <input type="hidden" name="task_id"
			value="<%=request.getAttribute("task_id")%>"> <input
			type="hidden" name="task_origin"
			value="<%=request.getAttribute("update_info")%>"> <input
			id=button2 type="submit" value="編集">
	</form>
	<%}%>


</body>
</html>