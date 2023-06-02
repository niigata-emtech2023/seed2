<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.entity.SpoFesBean,java.util.List,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>チェック内容確認画面</title>
<link rel="stylesheet" href="./css/select.css">
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	int point = 0;
	List<SpoFesBean> taskList = (List<SpoFesBean>) session.getAttribute("taskList");

	%>
	<div class="topcheck">
		<div class="topcheckleft">＜チェック欄＞</div>
		<div class="topcheckcenter">これでよろしいでしょうか</div>
		<div class="topcheckright">
			<%=request.getParameter("team_name")%>団
		</div>
	</div>
	<table class="table">
		<tbody class="tbody2">
			<%
			int i = 1;
			for (SpoFesBean bean : taskList) {
			%>
			<tr>
				<td class="kazucheck"><%=bean.getTaskId()%></td>
				<td class="task"><%=bean.getTaskName()%></td>
				<td class="radio2">
					<%if(1==Integer.parseInt(request.getParameter("task"+i))){ %>
					1 
					<% 
					point++;
					%> 
					<% 
					bean.setPoint(Integer.parseInt(request.getParameter("task"+i)));
					%>
					<%
					}else{ 
					%>
					0
					<%
					}
					%>
				</td>
			</tr>
			<%
			i++;
			}
			session.setAttribute("taskList",taskList);
			%>
		</tbody>
	</table>
	<div class="under">
		<div class="point">
			<%=point%>点
		</div>
		<form action="contact-display-servlet" method="post">
			<input class="bottombuttonright" type="submit" value="戻る">
		</form>
		<form action="contact-servlat" method="post">
			<input class="bottombuttonleft" type="submit" value="確定"> <input
				type="hidden" name="point" value="<%=point%>"> <input
				type="hidden" name="teamname"
				value="<%=request.getParameter("team_name")%>">
		</form>

	</div>
</body>
</html>