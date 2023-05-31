<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SpoFesBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録結果</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	List<SpoFesBean> taskList = (List<SpoFesBean>) session.getAttribute("taskList");
	String teamname = (String)session.getAttribute("teamname");
	%>

	<%=teamname%>団
	<br> ＜チェック欄＞ 登録しました
	<table border="1">
		<%
			for (SpoFesBean bean : taskList) {
			%>
		<tr>
			<td><%=bean.getTaskId()%></td>
			<td><%=bean.getTaskName()%></td>
			<td>
				<%=bean.getPoint()%>点
			</td>
		</tr>
		<%
			}
			%>
	</table>
	
	<form action="select-rank-servlet" method="post">
		<input type="submit" value="メニューに戻る">
	</form>
</body>
</html>