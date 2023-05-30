<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SpoFesBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧</title>
</head>
<body>
	<%@ include file="header.jsp" %>

	<% 
		List<SpoFesBean> taskList = (List<SpoFesBean>)session.getAttribute("taskList");
	
	%>
	
	<h3>☆得点項目一覧</h3>
	<table border="1">
	<% int i = 1; %>
	<%
		for (SpoFesBean task : taskList) {
	%>
		<tr>
			<td><%=task.getTaskId()%></td>
			<td><%=task.getTaskName()%></td>
			
		</tr>
	<%
		}
	%>
	</table>
	
	<%@ include file="task_button.jsp" %>
	
</body>
</html>