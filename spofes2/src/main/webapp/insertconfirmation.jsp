<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SpoFesBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得点項目登録確認画面</title>
</head>
<body>
    
    &lt;登録確認画面&gt;
    <br>
        これでよろしいですか
    <br>
    
    <%
	    request.setCharacterEncoding("UTF-8");
        String task_info = request.getParameter("task_info");
        session.setAttribute("task_info" , task_info);
	%>
        内容<br>
        <%=task_info %><br>
        
    <form action = "insert.jsp" method = "POST">
        <input type = "submit" value = "戻る">
    </form>
    
    <form action = "insert-servlet" method = "POST">
        <input type = "submit" value = "確定">
    </form>
    

</body>
</html>