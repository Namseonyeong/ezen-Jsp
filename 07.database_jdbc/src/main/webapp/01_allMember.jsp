<!-- 0524 JDBC 드라이버 등 설정 + 테이블(표) 추가 -->
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	Connection conn = null; // JDBC를 통해 오라클DB에 접속한 객체
	Statement  stmt = null; // SQL문 저장, 실행 객체
	ResultSet  rs   = null; // 데이터베이스 조회 결과를 저장하는 객체
	// 데이터베이스와 연결시켜주는 url       uid=DB사용자 id/ pass=DB사용자 pw
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "jsp_user";
	String pass = "ora123"; 
%>
<table width="600" border="1">
<tr>
	<th>이름</th><th>아이디</th><th>암호</th><th>이메일</th><th>전화번호</th><th>권한</th>
</tr>
<%
	try {
		// (1) 오라클 JDBC 드라이버를 JVM 메모리에 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
		// (2) DriverManager를 이용하여 오라클 DB에 연결
		conn = DriverManager.getConnection(url, uid, pass);
		
		// (3) SQL문 실행을 위한 Statement 객체 생성
		stmt = conn.createStatement();
		
		// (4) SQL문을 실행하여 결과를 가져온다.
		rs = stmt.executeQuery("SELECT * FROM member");
		
		while(rs.next()) {
			out.println("<tr>");
			out.println("<td>" + rs.getString("name") + "</td>");
			out.println("<td>" + rs.getString("userid")+ "</td>");
			out.println("<td>" + rs.getString("pwd")+ "</td>");
			out.println("<td>" + rs.getString("email")+ "</td>");
			out.println("<td>" + rs.getString("phone")+ "</td>");
			out.println("<td>" + rs.getInt("admin")+ "</td>");
			out.println("</tr>");
		}
	} catch(Exception e){
		e.printStackTrace();
	} finally {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}     
%>
</table>
</body>
</html>