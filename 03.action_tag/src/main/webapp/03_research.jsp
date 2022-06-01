<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	span {
		font-size: 1.2em;
		font-weight: 700;
	}
</style>
</head>
<body>
<div id="container">
	<% 
	request.setCharacterEncoding("UTF-8");
	String[] season_name = {"", "봄", "여름", "가을", "겨울"};
	String[] values = request.getParameterValues("season");
	%>
	<h2>설문조사 결과</h2>	
	이름: <span class="result"><%= request.getParameter("name") %></span><br>
	성별: <span class="result"><%= request.getParameter("gender") %></span><br>
	당신이 좋아하는 계절은 <span class="result">
	<%
		for(int i=0; i<values.length; i++) {
			int idx = Integer.parseInt(values[i]);
			out.print(season_name[idx]+ " ");
		}
	%>
	</span>입니다.<br>
	<a href="javascript:history.go(-1)">다시</a>
</div>	
</body>
</html>