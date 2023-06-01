<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得点項目編集確認</title>
<link rel = "stylesheet" href = "./css/update.css">
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
%>
<div class="flex"><span id="s1">＜得点項目編集確認画面＞</span>
<span id="c2"><%=request.getParameter("task_id")%> 番の内容を変更します。</span></div>
<div id="s2">この内容でよろしいですか？<br></div>
<table class="tablecon">
<tr><td class="table1">変更前</td><td class="table2"><%=session.getAttribute("task_origin")%></td></tr>


<tr><td class="table1">変更後</td><td class="table2"><%=request.getParameter("update_info")%></td></tr>

</table>

<div class="under">

<form action="update.jsp" method="post">
	<input type="hidden" name="task_id" value="<%=request.getParameter("task_id")%>">
	<input type="hidden" name="task_info" value="<%=request.getParameter("update_info")%>">
	<input class="bottombuttonleft" type="submit" value="戻る">
</form>	

<form action="update-servlet" method="post">
	<input type="hidden" name="task_id" value="<%=request.getParameter("task_id")%>">
	<input type="hidden" name="update_info" value="<%=request.getParameter("update_info")%>">
	<input class="bottombuttonright" type="submit" value="確定">
</form>

</div>
</body>
</html>