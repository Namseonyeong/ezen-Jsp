<!-- 0524 PreparedStatement 객체 사용 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%! 
	Connection conn = null; 
	PreparedStatement pstmt = null;
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "jsp_user";
	String pass = "ora123";
	String sql = "INSERT INTO member VALUES(?, ?, ?, ?, ?, ?)";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String userid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	int	   admin = Integer.parseInt(request.getParameter("admin"));
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 메모리 로드
		conn = DriverManager.getConnection(url, uid, pass); // 드라이버 이용하여 DB에 연결
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name); // 바인딩 (상단 INSERT의 ? 값 설정)
		pstmt.setString(2, userid);
		pstmt.setString(3, pwd);
		pstmt.setString(4, email);
		pstmt.setString(5, phone);
		pstmt.setInt(6, admin);
		
		pstmt.executeUpdate();
	}catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (pstmt != null) pstmt.close();
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