<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SpoFesBean,java.util.List"%>
<%String name = (String)session.getAttribute("name");
	List<SpoFesBean> list = (List<SpoFesBean>)session.getAttribute("myteamrank");
%>
<span>Spofes</span>
<%for(SpoFesBean bean: list){ %>
<%=bean.getTeamName() %>
<%=bean.getPoint() %>
<%} %>
<%=name %>
<form action="logout.jsp" method="post">
	<input type="submit" value="ログアウト">
</form>
