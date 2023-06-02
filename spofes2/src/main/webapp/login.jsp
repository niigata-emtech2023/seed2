<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.SpoFesBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="./css/style.css">
 <script src="./javascript/login.js"></script>
</head>
<body>
	<div id="wrapper">
	<div class="title">
		『Spofes』を始めよう！
		</div>
		<div class="s1">
			<div id="s5">ログイン</div>
			<form action="login-servlet" method="POST" >
				<div id="s2">ID</div>
				<br>
				<div class="s4">
					<input id="name" type="text" placeholder="学籍番号" name="id">
				</div>
				<br>
				<div id="s3">パスワード</div><br>
				<div class="s4">
					<input id="pass" type="password" placeholder="パスワード（８桁以上）" name="pass">
				</div>
				<div>
				<%if(request.getAttribute("err")!=null){%>
                <%=request.getAttribute("err") %>
        		<%}else{%>
        		<br>
        		<%} %>
        		</div>
				<input class="button-panel"type="submit" value="ログイン"><br>
			</form>
		</div>
		<div id="s6">
			<a href="adminlogin.jsp">管理者の方はこちら</a>
		</div>
		
	</div>
</body>
</html>