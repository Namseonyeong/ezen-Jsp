<!-- 0519 sendRedirect : 현재 페이지에서 사용자가 지정한 새로운 페이지로 이동 -->
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
	response.sendRedirect("http://www.naver.com");
	%>
</body>
</html>