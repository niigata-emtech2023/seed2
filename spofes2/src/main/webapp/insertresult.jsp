<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SpoFesBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規得点項目登録完了画面</title>
<link rel = "stylesheet" href = "./css/insertresult.css">
</head>
<body>
    <span id = s1>&lt;新規得点項目登録完了画面&gt;</span>
    <br><br>
	<%
		int number = (Integer) request.getAttribute("number");
		if (number > 0) {
	%>
	<span class = c1>登録しました。</span><br>
	<%
		} else {
	%>
	<span class = c1>登録できませんでした。</span><br>
	<%
		}
	%>

    <div class = task>
	<span id = s3>内容</span><span id = s4><%=session.getAttribute("task_info") %></span><br>
	</div>
	
	<%--<% session.invalidate(); --%>

	<form action = "select-rank-servlet" method = "POST">
		<input id = s5 type="submit" value="メニューに戻る">
	</form>
	
</body>
</html>	