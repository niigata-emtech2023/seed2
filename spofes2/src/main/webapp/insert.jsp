<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規得点項目登録画面</title>
<link rel = "stylesheet" href = "./css/insert.css">
</head>
<body>
    <%
    request.setCharacterEncoding("UTF-8");
    %>

    <div id = s1>&lt;新規得点項目登録&gt;</div>
    <form action = "select.jsp" method = "POST">
        <input id = button1 type = "submit" value = "メニューに戻る">
    </form><br>
    
    
    <form action = "insertconfirmation.jsp" method = "POST">
    
    <%
    if(session.getAttribute("task_info") == null){
    %>
    <div class = c1>・内容<br></div>
    <textarea name = "task_info" cols ="50" rows = "5" ></textarea><br>
    <%
    }else {
    %>
    <div class = c1>・内容<br></div>
    <textarea name = "task_info" cols ="50" rows = "5"><%=session.getAttribute("task_info")%></textarea><br>
    <% 
    }
    %>
        
        <input id = button2 type = "submit" value = "登録">
        
    </form>

</body>
</html>