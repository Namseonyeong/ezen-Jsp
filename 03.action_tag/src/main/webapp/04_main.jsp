<!-- 0519 로그인 인증처리 연습 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><%= request.getParameter("name") %>님 안녕하세요!</h3>
	저희 홈페이지에 방문해 주셔서 감사합니다.<br>
	즐거운 시간 되세요!!!<br>
</body>
</html>