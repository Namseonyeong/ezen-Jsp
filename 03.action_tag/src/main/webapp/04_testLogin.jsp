<!-- 0519 로그인 인증처리 연습 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	// 원래는 DB정보와 비교해서 가져와야함. 실습이라서 임의로 지정
	String id="gdhong";
	String pwd = "1234";
	String name = "홍길동";
	
// 	request : 화면에서 올라온 객체를 보관
	request.setCharacterEncoding("UTF-8");
	
	if (id.equals(request.getParameter("id")) &&
			pwd.equals(request.getParameter("pwd"))) {
/* 		// 정상적인 로그인 -> main화면으로 이동
		   response.sendRedirect("04_main.jsp); */
		
	   // 정상적인 로그인 -> main화면으로 이동 + 주소창 위에 name 띄움, 한글은 인코딩 해줘야함
	   response.sendRedirect("04_main.jsp?name="+URLEncoder.encode(name, "UTF-8"));
	} else {
		// 로그인 실패시 -> 
		response.sendRedirect("04_loginForm.jsp");
	}
	
%>
</body>
</html>