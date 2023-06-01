<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SpoFesBean,java.util.List"%>
    <% List<SpoFesBean> taskList =(List<SpoFesBean>)session.getAttribute("taskList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得点項目一覧表示画面</title>
<link rel="stylesheet" href="./css/adminselect.css">
</head>
<body>
<div class="top">
	<div class="topleft">
		☆得点項目一覧表示
	</div>
		<form action="select.jsp">
			<input class="topright" type="submit"value="メニューに戻る">
		</form>
</div>
<table class="table">
<tbody class="tbody">
<%for(SpoFesBean bean : taskList){ %>
<tr>
	<td class="kazu">
		<%=bean.getTaskId()%>
	</td>
	<td>
		<%=bean.getTaskName() %>
	</td>
	<td>
		<form action="update-display-servlet" method="post">
			<input class="tbutton" type="submit"value="編集">
			<input type="hidden" name="task_id" value="<%=bean.getTaskId() %>">
			<input type="hidden" name="task_info" value="<%=bean.getTaskName() %>">
		</form>
	</td>
	<td>
		<form action="deleteconfirmation.jsp">
			<input class="tbutton" type="submit"value="削除">
			<input type="hidden" name="task" value="<%=bean.getTaskName() %>">
		</form>
		
	</td>
</tr>
<%} %>
</tbody>
</table>
</body>
</html>