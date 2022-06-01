<!-- 0524 JDBC 드라이버 등 설정 : 초기 버전 테이블(표) 없는것-->
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
	// 데이터베이스와 연결시켜주는 url
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "jsp_user";
	String pass = "ora123"; 
%>
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
			System.out.println("name : " + rs.getString("name"));
			System.out.println("userid : " + rs.getString("userid"));
			System.out.println("pwd : " + rs.getString("pwd"));
			System.out.println("email : " + rs.getString("email"));
			System.out.println("phone : " + rs.getString("phone"));
			System.out.println("admin : " + rs.getInt("admin"));
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
</body>
</html>