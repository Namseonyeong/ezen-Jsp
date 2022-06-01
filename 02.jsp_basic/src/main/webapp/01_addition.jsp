<!-- 0518 자바 사용시  -->
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
	// Java Code를 작성하는 부분
	int num1 = 30;
	int num2 = 20;
	int add = num1 + num2;
	// out : 출력스트림
	out.print(num1 +" + "+ num2 +" = "+ add);
%>

<!--  java는 브라우저가 아닌 서버에서 해석해서 브라우저로 내보낸다 -->
</body>
</html>