<!-- 0519 내장객체 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>현재 페이지에서 각 영역의 데이터 저장 후 확인</h3>
 <%	 
//  	각 영역의 종류 test
	pageContext.setAttribute("name", "페이지 저장 속성");
	request.setAttribute("name", "request 저장 속성");
	session.setAttribute("name", "session 저장 속성");
	application.setAttribute("name", "application 저장 속성");
	
	System.out.println("=== firstPage.jsp ===");
	System.out.println("페이지 영역 데이터 : " + pageContext.getAttribute("name"));
	System.out.println("request 영역 데이터 : " + request.getAttribute("name"));
	System.out.println("session 영역 데이터 : " + session.getAttribute("name"));
	System.out.println("application 영역 데이터 : " + application.getAttribute("name"));
	
// 	다른 페이지로 이동하기 위한 설정
	RequestDispatcher rd = request.getRequestDispatcher("06_secondPage.jsp");
	rd.forward(request, response); // 두번째 페이지로 이동(현재 페이지의 request, response 정보를 같이 전달)
%>
</body>
</html>