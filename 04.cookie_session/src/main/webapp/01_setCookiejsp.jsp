<!-- 0520 -->
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
	// 쿠키생성
	Cookie c = new Cookie("id", "gdhong");
	
	// 유효기간 설정 : 유효기간 1년
	c.setMaxAge(365*24*60*60); 
	
	// 클라이언트로 전송
	// --> new를 하고 add를 안하면 저장이 안됨.
	response.addCookie(c);
	
	response.addCookie(new Cookie("pwd", "1234"));
	response.addCookie(new Cookie("name", "홍길동"));
	%>
	<h3>쿠키 설정</h3>
</body>
</html>