<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SpoFesBean,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録項目削除確認画面</title>
<link rel = "stylesheet" href = "./css/deleteconfirmation.css">
</head>
<body>
    <%
    request.setCharacterEncoding("UTF-8");
    %>
    
    <div id = s1>&lt;登録項目削除確認画面&gt;</div>
    <br>
        <span id = s2>本当に削除しますか?</span>
    <br>
    
    <%
	SpoFesBean spofes = (SpoFesBean)request.getAttribute("spofes");
    String task = request.getParameter("task");
	%>
    
    <div class = task>
        <span id = s3>内容</span><span id = s4><%=task %></span><br>
    </div>
        <%session.setAttribute("task",task); %>
    
    <div class = button>
    <form action = "adminselect.jsp" method = "POST">
        <input id = s5 type = "submit" value = "戻る">
    </form>
    
    <form action = "delete-servlet" method = "POST">
        <input id = s6 type = "submit" value = "削除">
        
    </form>
    </div>

</body>
</html>