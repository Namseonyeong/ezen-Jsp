<!-- 0520 세션 04_setSession 파일 코드 받아보기-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>세션에 저장된 모든 값 읽어오기</h3>
<%
	Enumeration<String> names = session.getAttributeNames();

	while(names.hasMoreElements()) { // 다음 항목 값이 있는지 확인
		String name = names.nextElement(); // 다음 항목 가져오기
		
		String value = (String)session.getAttribute(name);
		out.print(name + " : " + value + "<br>");
		
	}

%>
</body>
</html>