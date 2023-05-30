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
	List<SpoFesBean> taskList = (List<SpoFesBean>) request.getAttribute("taskList");
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
		<table border>
			<%
			for (SpoFesBean task : taskList) {
			%>
			<tr>
				<td><%=task.getTaskId()%></td>
				<td><%=task.getTaskName()%></td>
				<td>
					<input type="radio" name="check<%=task.getTaskId()%>" value="true">〇
					<input type="radio" name="check<%=task.getTaskId()%>" value="false">×
				</td>
			</tr>
			<%
			}
			%>
		</table>

	<br>
	＜コメント＞<br>
	<table border>
		<tr>
			<td>
			<select name="coment_id">
			<%
			for (SpoFesBean task : taskList) {
			%>
			<option value="<%=task.getTaskId()%>>"><%=task.getTaskId()%></option>
			<%
			}
			%>
			</td>
			<td><textarea name="coment" cols="80" rows="4"></textarea></td>
		</tr>
	</table>
	<input type="submit" value="登録" >
	</form>
</body>
</html>