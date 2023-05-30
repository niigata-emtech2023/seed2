<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SpoFesBean,java.util.List"%>
    <% List<SpoFesBean> taskList =(List<SpoFesBean>)session.getAttribute("taskList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得点項目一覧表示画面</title>
</head>
<body>
<form action="select.jsp">
	<input type="submit"value="メニューに戻る">
</form>
<table border="1">
<%for(SpoFesBean bean : taskList){ %>
<tr>
	<td>
		<%=bean.getTaskName() %>
	</td>
	<td>
		<form action="updateconfirmation.jsp">
			<input type="submit"value="編集">
			<input type="hidden" name="task" value="<%=bean.getTaskName() %>">
		</form>
	</td>
	<td>
		<form action="deleteconfirmation.jsp">
			<input type="submit"value="削除">
			<input type="hidden" name="task" value="<%=bean.getTaskName() %>">
		</form>
		
	</td>
</tr>
<%} %>
</table>
</body>
</html>