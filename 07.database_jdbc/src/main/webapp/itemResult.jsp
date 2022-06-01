<!-- 0524 상품정보 관리 페이지 (정보 입력받아 DB저장) 연습문제 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%!
	Connection conn = null; // JDBC를 통해 오라클DB에 접속한 객체
	PreparedStatement  pstmt = null; // SQL문 저장, 실행 객체
	ResultSet  rs   = null; // 데이터베이스 조회 결과를 저장하는 객체
	// 데이터베이스와 연결시켜주는 url       uid=DB사용자 id/ pass=DB사용자 pw
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "jsp_user";
	String pass = "ora123";
	String sql = "SELECT * FROM item";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<body>
<h2>입력 완료된 정보</h2>
<table  width="600" border="1">
<tr>
	<th>상품명</th><th>가격</th><th>설명</th>
</tr>
<%
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, uid, pass);
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			out.println("<tr>");
			out.println("<td>" + rs.getString("pname") + "</td>");
			out.println("<td>" + rs.getInt("price")+ "</td>");
			out.println("<td>" + rs.getString("description")+ "</td>");
			out.println("</tr>");
		}
	} catch(Exception e){
		e.printStackTrace();
	} finally {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}     
%>
</table>
</body>
</html>