<!-- 0523 표현언어 두 수의 합 구하기  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> 고전적인 방식 (자바)</h3>
<% 
	int n1 = Integer.parseInt(request.getParameter("num1"));
	int n2 = Integer.parseInt(request.getParameter("num2"));
	
	request.setAttribute("number1", n1); // 내장 객체에 자바 변수의 값을 속성으로 저장
	request.setAttribute("number2", n2);
%>	
	<%= n1 %> + <%= n2 %> = <%= n1+n2 %> <br><br>
<h3>표현언어 방식</h3>
${param.num1} + ${param.num2} = ${param.num1+param.num2}<br>

<h3>표현언어 내의 구분자는 속성명을 지정해야함</h3>
${number1} + ${number2} = ${number1+number2} <br>
<!-- n1, n2처럼 변수를 지정하는게 아님. 변수의 값을 사용하려면 위의 request.setAttribute로 설정 -->

</body>
</html>