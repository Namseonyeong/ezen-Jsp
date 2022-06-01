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
<!-- 표현식 -->
	<%= "Hello" %> <br><br>
	
<!-- 스크립트릿 -->
<%
	out.print("Hello<br><br>");
%>

<!-- 표현언어 : 값을 웹 페이지에 표시하는데 사용하는 태그-->
${"Hello"}<br><br>
</body>
</html>