<%@page import="searcher.Article, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Article Search Results</title>
<link rel="stylesheet" href="searchresult.css" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Sriracha" rel="stylesheet">
</head>
<body>
	<div class=title href="index.jsp">
	<a href="index.jsp">
		<img width="379" height="64" xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://g1.nyt.com/assets/homepage/20180313-200348/images/foundation/logos/nyt-logo-379x64.svg" src="https://g1.nyt.com/assets/homepage/20180313-200348/images/foundation/logos/nyt-logo-379x64.png" alt="The New York Times" border="0"></img>
	</a>
	</div>
	
	<% ArrayList<Article> articles=(ArrayList<Article>)request.getAttribute("articles"); %>
	<% for(int i=0; i<articles.size();i++){ %>
		<h3 class=headline><a href="<%= articles.get(i).getUrl()%>"><%= articles.get(i).getHeadline() %></a></h3>
		<p><%= articles.get(i).getSnippet() %></p>
		<hr>
	<% } %>
</body>
</html>