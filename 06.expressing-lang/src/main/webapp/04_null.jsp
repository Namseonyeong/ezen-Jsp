<!-- 0523 입력 값이 없을때 null이 아닌 공란 출력 -->
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
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
%>
<h3>null값 처리 비교</h3>
자바 코드 : <%= id %> <br>
EL방식 : ${param.id}
</body>
</html>