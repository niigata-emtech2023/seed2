<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト</title>
<link rel="stylesheet" href="./css/logout.css">
</head>
<body>
<div id="text">
	ログアウトしますか？
	<br>
	<div class="bottan">
		<form action="select.jsp">
			<input class="button-panel" type="submit" value="戻る">
		</form>
		<form action="logout-servlet" method="post">
			<input class="button-panel" type="submit" value="ログアウト">
		</form>
	</div>
	</div>
</body>
</html>