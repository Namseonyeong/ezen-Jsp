package snippet;

public class Snippet {
	<!-- 0525 DAO 테스트  -->
	<%@page import="com.ezen.dto.MemberDAO"%>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<%@ page import="com.ezen.dto.MemberDAO" %>
//	 상단 MemberDAO 하고 컨트롤 스페이스 : 자동생성
	<%@ page import="java.sql.*" %>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
	<%
		// DAO 객체 생성
		MemberDAO mDao = MemberDAO.getInstance();
	
		// 데이터베이스 연결 수행
		Connection conn = mDao.getConnection();
		
		if (conn != null) {
			out.print("데이터베이스 연결 성공!");
		
			conn.close();
		}
			
		
	%>
	</body>
	</html>
}

