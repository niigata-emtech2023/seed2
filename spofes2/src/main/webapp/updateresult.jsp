<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得点項目編集完了</title>
</head>
<body>
	<%
request.setCharacterEncoding("UTF-8");


%>
	＜得点項目編集完了画面＞ 項目"<%=request.getAttribute("task_id")%>"番の内容を変更しました。
	<br>
	<tr>
		<td>内容</td>
		<td><%=request.getAttribute("update_info")%></td>
	</tr>
	<form action="adminselect.jsp" 　method="post">
		<input type="submit" value="戻る">
</body>
</html>