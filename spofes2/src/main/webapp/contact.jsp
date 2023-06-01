<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.SpoFesBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>チェック画面</title>
<link rel="stylesheet" href="./css/select.css">
</head>
<body>
	<%
	List<SpoFesBean> taskList = (List<SpoFesBean>) session.getAttribute("taskList");
	List<SpoFesBean> teamList = (List<SpoFesBean>) request.getAttribute("teamList");
	%>
	<div class="top">
	<form action="select-all-servlet" method="post">
		<input class="topbutton" type=submit value="メニューに戻る">
	</form>
	</div>
	<form action="contactconfirmation.jsp" method="post">
		<div class="check">＜check欄＞<select class="select" name="team_name">
		
			<%int i = 1;
			for (SpoFesBean team : teamList) {
			%>
			<option class="selectteam<%=i %>" value="<%=team.getTeamName()%>"><%=team.getTeamName()%>団</option>
			<%i++;
			}
			%>
		</select></div> <br>
		
		<table class="table1">
		<tbody class="tbody2">
			<%
			for (SpoFesBean task : taskList) {
			%>
			<tr>
				<td class="kazucheck"><%=task.getTaskId()%></td>
				<td class="task"><%=task.getTaskName()%></td>
				<td class="radio">
					<input type="radio" name="task<%=task.getTaskId()%>" value="1">
				</td>
				<td class="radio">
					<input type="radio" name="task<%=task.getTaskId()%>" value="0" checked="checked">
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
		</table>

	<br>

	<input class="bottombutton" type="submit" value="登録" >
	</form>
</body>
</html>