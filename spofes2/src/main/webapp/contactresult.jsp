<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SpoFesBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録結果</title>
<link rel="stylesheet" href="./css/select.css">
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	List<SpoFesBean> taskList = (List<SpoFesBean>) session.getAttribute("taskList");
	String teamname = (String)session.getAttribute("teamname");
	Integer point = (Integer)session.getAttribute("point");
	%>
	<div class="topcheck">
	<div class="topcheckleft">
		＜チェック欄＞ 
	</div>
	<div class="topcheckcenter">
		登録しました
	</div>
	<div class="topcheckright">
		<%=teamname%>団
	</div>
	</div>
	<table class="table">
		<tbody class="tbody2">
		<%
			for (SpoFesBean bean : taskList) {
			%>
		<tr>
			<td class="kazucheck"><%=bean.getTaskId()%></td>
			<td class="task"><%=bean.getTaskName()%></td>
			<td class="radio2">
				<%=bean.getPoint()%>
			</td>
		</tr>
		<%
			}
			%>
			
			</tbody>
	</table>
	
	<div class="under1">
	 <div class="point1">
	<%=point%>点
	 </div>
	<form action="select-rank-servlet" method="post">
		<input class="bottombuttomenu"  type="submit" value="メニューに戻る">
	</form>
	</div>
</body>
</html>