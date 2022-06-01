<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 0520 세션을 이용한 로그인처리 -->
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<%
	String id = "gdhong";
	String pwd = "1234";
	String name = "홍길동";

	
	if (id.equals(request.getParameter("id")) && 
	    pwd.equals(request.getParameter("pwd"))) {
		//정상적인 사용자
		session.setAttribute("loginUser", name);
		response.sendRedirect("08_main.jsp");
	} else { 
		response.sendRedirect("08_loginForm.jsp"); 
	}
%>	
</body>
</html>