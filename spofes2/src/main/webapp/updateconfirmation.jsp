<html>
<head>
<meta charset="UTF-8">
<title>得点項目編集確認</title>
</head>
<body>
	<%
request.setCharacterEncoding("UTF-8");
%>
	＜得点項目編集確認画面＞
	<br> 項目
	<%=request.getParameter("task_id")%>
	番の内容を変更します。 この内容でよろしいですか？
	<br>
	<table>
		<tr>
			<td>変更前</td>
			<td><%=session.getAttribute("task_origin")%></td>
		</tr>


		<tr>
			<td>内容</td>
			<td><%=request.getParameter("update_info")%></td>
		</tr>

	</table>
	<form action="update-servlet" method="post">
		<input type="hidden" name="task_id"
			value="<%=request.getParameter("task_id")%>"> <input
			type="hidden" name="update_info"
			value="<%=request.getParameter("update_info")%>"> <input
			type="submit" value="確定">
	</form>
	<form action="update.jsp" 　method="post">
		<input type="hidden" name="task_id"
			value="<%=request.getParameter("task_id")%>"> <input
			type="hidden" name="task_info"
			value="<%=request.getParameter("update_info")%>"> <input
			type="submit" value="戻る">
	</form>
</body>
</html>