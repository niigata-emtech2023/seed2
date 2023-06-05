<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得点項目編集完了</title>
<link rel = "stylesheet" href = "./css/update.css">
</head>
<body>
	<%@ include file="system.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<div class="flex"><span id="s1">＜得点項目編集完了画面＞</span>
<span id="c2"><%=request.getAttribute("task_id")%>番の内容を変更しました。</span></div>
<table class="tableres">
<tr><td class="table1">内容</td><td class="table2"><%=request.getAttribute("update_info")%></td></tr>
</table>
<form action="adminselect.jsp" method="post">
	<input class="bottombuttonreturn" type="submit" value="メニューに戻る">
	</form>
</body>
</html>