<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body class="admin">
	<div id="wrapper">
	<div class="title">
	<br>
		『Spofes』を始めよう！
		</div>
		<div class="s1">
			<div id="s5">ログイン</div>
			<form action="admin-login-servlet" method="POST">
				<div id="s2">ID</div>
				<br>
				<div class="s4">
					<input type="text" placeholder="管理者番号" name="id">
				</div>
				<br>
				<div id="s3">パスワード</div><br>
				<div class="s4">
					<input type="password" placeholder="パスワード（８桁以上）" name="pass">
				</div>
				<div class="err">
				<%if(request.getAttribute("err")!=null){%>
                <%=request.getAttribute("err") %>
        		<%}else{%>
        		<br>
        		<%} %>
        		</div>
				<input class="button-panel" type="submit" value="ログイン"><br>
			</form>
		</div>
	</div>
</body>
</html>