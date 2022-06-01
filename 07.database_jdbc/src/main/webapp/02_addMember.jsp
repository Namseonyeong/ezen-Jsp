<!-- 0524 UP -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%! 
	Connection conn = null; 
	Statement stmt = null;
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "jsp_user";
	String pass = "ora123";
	String sql = "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name = "홍길동";
	String userid = "gdhong";
	String pwd = "1234";
	String email = "gdhong@email.com";
	String phone = "010-1234-5678";
	int	   admin = 0;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 메모리 로드
		conn = DriverManager.getConnection(url, uid, pass); // 드라이버 이용하여 DB에 연결
		stmt = conn.createStatement();
		
		sql = "INSERT INTO member VALUES('"+name+"','"+userid+"','"+pwd+"','"+email+"','"
				+phone+"',"+admin+")";
		stmt.executeUpdate(sql);
	}catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
%>	
<h3>회원 가입 완료</h3>
<a href="01_allMember.jsp">회원 전체 목록보기</a>	
</body>
</html>