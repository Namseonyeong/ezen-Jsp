<%@page import="java.lang.reflect.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>			
<!-- 				id는 변수가 아닌 속성 -->
	<jsp:useBean id="member" class="com.ezen.javabeans.MemberBeans"></jsp:useBean>
	
<%
	member.setName("장보고");
	member.setUserid("bkjang");
%>
	이름 : <%= member.getName() %> <br>
	아이디 : <%= member.getUserid() %>
</body>
</html>