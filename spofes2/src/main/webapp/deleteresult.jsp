<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.List,model.entity.SpoFesBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得点項目削除完了画面</title>
<link rel = "stylesheet" href = "./css/deleteresult.css">
</head>
<body>
    <span id = s1>&lt;得点項目削除完了画面&gt;</span>
    <br><br>
	<%
		int number = (Integer) request.getAttribute("number");
		if (number > 0) {
	%>
	<span class = c1>削除しました。</span><br>
	<%
		} else {
	%>
	<span class = c1>削除できませんでした。</span><br>
	<%
		}
	%>
	<%
	String task = (String)session.getAttribute("task");
	%>
	
	<div class = task>
	<span id = s3>内容</span><span id = s4><%=task %></span><br>
	</div>

	<form action="select-all-servlet" method="POST">
		<input id = s5 type="submit" value="メニューに戻る">
	</form>

	<% session.invalidate(); %>

</body>
</html>