<!-- 0523 문자형 데이터 비교 (자바,EL) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 자바코드에서는 입력 파라미터가 없을 경우 예외가 발생
		 null 값에 대한 처리 필요 --%>
	<h3>문자열 비교 (자바 코드)</h3>
<% 
	if (request.getParameter("id") != null ) {
%>
	== 연산자 : <%= request.getParameter("id") == "gdhong" %> <br>
	equals() 메소드 : <%= request.getParameter("id").equals("gdhong") %> <br>
<% } else { 
		out.println("id를 입력해주세요");
		}
%> 	
	<br>
	<h3>문자열 비교 (EL방식)</h3>
	<%-- 입력 파라미터에 대한 null 처리 필요 없음 --%>
	== 연산자 : ${param.id == "gdhong"} <br>
</body>
</html>