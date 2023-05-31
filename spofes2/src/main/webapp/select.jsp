<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SpoFesBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧</title>
<link rel="stylesheet" href="./css/select.css">
</head>
<body>
	<%@ include file="header.jsp" %>

	<% 
		List<SpoFesBean> taskList = (List<SpoFesBean>)session.getAttribute("taskList");
		
	%>
	
	<p>☆得点項目一覧</p>
	<table class="table">
	<tbody class="tbody">
	<% int i = 1; %>
	<%
		for (SpoFesBean task : taskList) {
	%>
		<tr>
			<td class="kazu"><%=task.getTaskId()%></td>
			<td class="task"><%=task.getTaskName()%></td>
			
		</tr>
	<%
		}
	%></tbody>
	</table>
	<%if(name.equals("管理者１")){ %>
	<%@ include file="task_button.jsp" %>
	<%} %>
</body>
</html>