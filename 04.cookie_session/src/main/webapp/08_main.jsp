<!-- 0520 세션을 이용한 로그인처리 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name = (String)session.getAttribute("loginUser");
%>
		<h3>메인 페이지</h3>
		<b><%= name %></b>님 안녕하세요! <br>
		저희 홈페이지에 방문해 주셔서 감사합니다. <br>
		즐거운 시간 되세요<br><br>
		<form method="get" action="08_logout.jsp">
			<input type="submit" value="로그아웃">
		</form>
	
</body>
</html>