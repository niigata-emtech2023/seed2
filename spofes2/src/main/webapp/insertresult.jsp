<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SpoFesBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得点項目登録完了画面</title>
</head>
<body>
    &lt;確定画面&gt;
	<%
		int number = (Integer) request.getAttribute("number");
		if (number > 0) {
	%>
	登録しました。<br>
	<%
		} else {
	%>
	登録できませんでした。<br>
	<%
		}
	%>

	内容<%=session.getAttribute("task_info") %><br>
	
	<% session.invalidate(); %>

	<form action="adminselect.jsp" method="POST">
		<input type="submit" value="メニューに戻る">
	</form>