<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.SpoFesBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>チェック画面</title>
</head>
<body>
	<%
	List<SpoFesBean> taskList = (List<SpoFesBean>) session.getAttribute("taskList");
	List<SpoFesBean> teamList = (List<SpoFesBean>) request.getAttribute("teamList");
	%>

	<form action="select-all-servlet" method="post">
		<input type=submit value="メニューに戻る">
	</form>
	<form action="contactconfirmation.jsp" method="post">
		＜check欄＞<select name="team_name">
			<%
			for (SpoFesBean team : teamList) {
			%>
			<option value="<%=team.getTeamName()%>>"><%=team.getTeamName()%></option>
			<%
			}
			%>
		</select> <br>
		<table border="1">
			<%
			for (SpoFesBean task : taskList) {
			%>
			<tr>
				<td><%=task.getTaskId()%></td>
				<td><%=task.getTaskName()%></td>
				<td>
					<input type="radio" name="task<%=task.getTaskId()%>" value="1">
				</td>
				<td>
					<input type="radio" name="task<%=task.getTaskId()%>" value="0" checked="checked">
				</td>
			</tr>
			<%
			}
			%>
		</table>

	<br>

	<input type="submit" value="登録" >
	</form>
</body>
</html>