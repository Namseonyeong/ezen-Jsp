<!-- 0520 표현언어 연산자 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- \를 사용하면 문자열로 인식하여 출력가능  -->
<!-- div(/나누기) mod(%나머지) >(비교연산자) empty(값의 유무) -->
\${ 5 + 2 } : ${5 + 2}<br>
\${ 5 / 2 } : ${5 / 2}<br>
\${5 div 2} : ${5 div 2} <br>
\${5 mod 2} : ${5 mod 2} <br>
\${5 > 2} : ${5 > 2}<br>
\${5 gt 2} : ${5 gt 2}<br>
\${5>2? 5 : 2} : ${5>2? 5 : 2}<br>
\${(5>2) || (2<10)} : ${(5>2) || (2<10)}<br>
<%
	String name = null;
%>
\${empty name} : ${empty name}<br>
</body>
</html>