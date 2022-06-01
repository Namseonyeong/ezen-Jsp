<!-- 0519 내장객체 request -->
<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<from method="get">
		<input type="text" name="name">
		<input type="submit" value="전송"> <br>
<!-- 컨텍스트 패스 : 프로젝트가 위치한곳 Servers->tomcat->server->하단 source -->
	컨텍스트 패스 : <%= request.getContextPath() %> <br>
	요청 방식 : <%= request.getMethod() %> <br>
 	요청 URL : <%= request.getRequestURL() %> <br> <%--사용자가 입력하는 전체 주소 --%>
	요청 URI : <%= request.getRequestURI() %> <br> <%--사용자가 요청하는 주소 --%>
	서버의 이름 : <%= request.getServerName() %> <br> <%-- 특정IP주소 ex)naver.com/ 등 --%>
	프로토콜 : <%= request.getProtocol() %> <br>
</body>
</html>