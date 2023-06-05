<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.SpoFesBean,java.util.List"%>
<%String name = (String)session.getAttribute("name");
	List<SpoFesBean> myteamlist = (List<SpoFesBean>)session.getAttribute("myteamrank");
	List<SpoFesBean> teamlist = (List<SpoFesBean>)session.getAttribute("teamrank");
	int td=1;
	int td1=1;
%>
<head>
<link rel="stylesheet" href="./css/header.css">
</head>
<header>
	<span>Spofes</span>
	<%if(name.equals("管理者１")){ %>
	<div class="rank">
		<table class="rank1">
			<tr>
				<%for(SpoFesBean team:teamlist) {%>
				<td class=td1 <%=td1 %>><%=team.getTeamName()%></td>
				<%td1++;} %>
			</tr>
		</table>
		<table class="rank2">
			<tr>
				<%for(SpoFesBean team:teamlist) {%>
				<td class=td <%=td %>><%=team.getPoint()%></td>
				<%td++;} %>
			</tr>
		</table>
	</div>
	<%}else{ %>
	<%for(SpoFesBean myteam : myteamlist) {
	String teamname = myteam.getTeamName();%>
	<div class="userheader">
		<div class="myrank">
			暫定<%=myteam.getRank() %>位
		</div>
		<div class="myteam">
			<%=myteam.getTeamName() %>団
			現在の得点<%=myteam.getPoint() %>点
		</div>
			
		<div class="slogan">
		<%if(teamname.equals("赤蠍")){%>
		<div class=redslo>気炎万丈</div>
		<%}else if(teamname.equals("青龍")){%>
		<div class=bluslo>青天白日</div>
		<%}else if(teamname.equals("黄雷")){%>
		<div class=yelslo>電光石火</div>
		<%}else if(teamname.equals("新緑")){%>
		<div class=greslo>森羅万象</div>
		<%}else if(teamname.equals("桃姫")){%>
		<div class=pinslo>桃弧棘矢</div>
		<%} %>
		</div>
	</div>

	<%} %>
	<%} %>
	
		<div id="name">
		<%=name %>さん
		<form action="logout.jsp" method="post">
			<input class="button-panel" type="submit" value="ログアウト">
		</form>
		</div>
	
</header>