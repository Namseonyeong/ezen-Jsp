<!-- 0523 표현언어로 파라미터값 받아오기 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	당신이 입력한 정보입니다. (Java 문법의 표현식 이용)
	아이디 : <%= request.getParameter("id") %> <br> 
	암  호 : <%= request.getParameter("pwd") %> <br><br>
	당신이 입력한 정보입니다. (표현 언어(EL) 방식 사용 아래 방법 둘 다 사용가능)
	아이디 : ${param.id} <br> ${param["id"]} <br>
	암  호 : ${param.pwd} <br> ${param["pwd"]} <br><br>
</body>
</html>