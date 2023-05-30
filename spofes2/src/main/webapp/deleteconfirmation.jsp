<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"import="model.entity.SpoFesBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録項目削除確認画面</title>
</head>
<body>
    <%
    request.setCharacterEncoding("UTF-8");
    %>
    
    &lt;削除&gt;
    <br>
        本当に削除しますか?
    <br>
    
    <%
	SpoFesBean spofes = (SpoFesBean)request.getAttribute("spofes");
	%>
        内容<br>
        <%=spofes.getTaskName() %><br>
        
        
         <%
         spofes.setTaskName(spofes.getTaskName());
         %>
 
    
    <form action = "adminmenu.jsp" method = "POST">
        <input type = "submit" value = "戻る">
    </form>
    
    <form action = "Delete-servlet" method = "POST">
        <input type = "submit" value = "削除">
    </form>

</body>
</html>