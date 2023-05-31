<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SpoFesBean,java.util.List"%>
<%String name = (String)session.getAttribute("name");
	List<SpoFesBean> list = (List<SpoFesBean>)session.getAttribute("myteamrank");
%>
<head>
<link rel="stylesheet" href="./css/header.css">
</head>
<header>
<span>Spofes</span>
<div id="name">
	<%=name %>さん

<form action="logout.jsp" method="post">
	<input class="button-panel" type="submit" value="ログアウト">
</form></div>
</header>
