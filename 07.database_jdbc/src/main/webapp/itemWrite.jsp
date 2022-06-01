<!-- 0524 상품정보 관리 페이지 (정보 입력받아 DB저장) 연습문제 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "jsp_user";
	String pass = "ora123";
	String sql = "INSERT INTO ITEM VALUES(?, ?, ?)";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//화면 데이터 가져오기
	String pname = request.getParameter("pname");
	int    price = Integer.parseInt(request.getParameter("price"));
	String description = request.getParameter("desc");
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, uid, pass);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pname);
		pstmt.setInt(2, price);
		pstmt.setString(3, description);
		
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try{
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
%>

<a href="itemResult.jsp">결과보기</a>
</body>
</html>