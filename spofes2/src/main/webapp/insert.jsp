<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得点項目登録画面</title>
</head>
<body>
    <%
    request.setCharacterEncoding("UTF-8");
    %>
    &lt;登録&gt;
    <form action = "adminselect.jsp" method = "POST">
        <input type = "submit" value = "メニューに戻る">
    </form>
    
    <form action = "insertconfirmation.jsp" method = "POST">
    
    <%
    if(session.getAttribute("task_info") == null){
    %>
    <textarea name = "task_info" cols ="25" rows = "3">
    
    </textarea><br>
    <%
    }else {
    %>
    
    <textarea name = "task_info" cols ="25" rows = "3">
    <%=session.getAttribute("task_info") %>
    </textarea><br>
    <% 
    }
    %>
        
        <input type = "submit" value = "登録">
        
    </form>

</body>
</html>