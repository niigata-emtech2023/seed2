<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SpoFesBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規得点項目登録確認画面</title>
<link rel = "stylesheet" href = "./css/insertconfirmation.css">
</head>
<body>
	<%@ include file="system.jsp" %>
    
    <div id = s1>&lt;新規得点項目登録確認画面&gt;</div>
    <br>
        <span id = s2>これでよろしいですか</span>
    <br>
    
    <%
	    request.setCharacterEncoding("UTF-8");
        String task_info = request.getParameter("task_info");
        session.setAttribute("task_info" , task_info);
	%>
	<div class = task>
        <span id = s3>内容</span><span id = s4><%=task_info %></span><br>
    </div>

    <div class = button>
    <form action = "insert.jsp" method = "POST">
        <input id = s5 type = "submit" value = "戻る">
    </form>
    
    <form action = "insert-servlet" method = "POST">
        <input id = s6 type = "submit" value = "確定">
    </form>
    </div>

</body>
</html>