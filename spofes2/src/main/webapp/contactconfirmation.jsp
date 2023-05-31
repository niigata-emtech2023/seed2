<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.entity.SpoFesBean,java.util.List,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>チェック内容確認画面</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	int point = 0;
	List<SpoFesBean> taskList = (List<SpoFesBean>) session.getAttribute("taskList");

	%>

	<%=request.getParameter("team_name")%>団
	<br> ＜チェック欄＞ これでよろしいでしょうか
	<table border="1">
		<%
			int i = 1;
			List<Integer> list = new ArrayList<Integer>();
			for (SpoFesBean bean : taskList) {
			%>
		<tr>
			<td><%=bean.getTaskId()%></td>
			<td><%=bean.getTaskName()%></td>
			<td>
				<%if(1==Integer.parseInt(request.getParameter("task"+i))){ %>
					1点 
					<% point++;%>
					<% bean.setPoint(Integer.parseInt(request.getParameter("task"+i)));
						
					%>
				<%}else{ %> 
					0点 
				<%} %>
			</td>
		</tr>
		<%
			i++;
			}
			session.setAttribute("taskList",taskList);
			
			%>
	</table>
	<form action="contact-servlat" method="post">
		<input type="submit" value="確定">
		<input type="hidden" name="point" value="<%=point%>">
		<input type="hidden" name="teamname" value="<%=request.getParameter("team_name")%>">
	</form>
	<form action="contact-display-servlet" method="post">
		<input type="submit" value="戻る">
	</form>
</body>
</html>