//0525 싱글톤 만들기 
package com.ezen.dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;


import com.ezen.dto.MemberVO;

public class MemberDAO {
	
	// 싱글톤 클래스를 만들기 위해 생성자를 private으로 선언 
	private MemberDAO() {
	}
	
	// 내부적으로 사용할 객체 생성  (외부에서도 사용가능하게 static으로 만듬)
	private static MemberDAO instance = new MemberDAO();
	
	// 내부에서 생성한 객체를 외부에 제공하는 메소드 (외부에서도 사용가능하게 static으로 만듬)
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// 데이터베이스에 DBCP 연결을 수행하는 메소드
	public Connection getConnection() throws Exception {
		
		// JNDI(Java Naming and Directory Interface) 초기화(JNDI를 이용하기 위한 객체 생성)
		Context initContext = new InitialContext();
		// lookup() - 지정된 이름으로 등록된 서비스를 찾을 때 사용
		Context envContext = (Context)initContext.lookup("java:/comp/env");
								
	    // JDBC 연결 서비스 등록
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection(); // DBCP에 등록된 오라클 연결을 할당받음
		
		return conn; //커넥션 타입을 리턴
	}
	
	/*
	 * 파라미터 : 
	 * - userid : 화면에서 입력한 사용자 ID 
	 * - pwd : 화면에서 입력한 암호
	 */
	public int userCheck(String userid, String pwd) {
		Connection conn = null; //오라클 DB 연결 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null; // DB 실행하는 값의 변수를 설정
		String sql = "SELECT pwd FROM member WHERE userid=?";
		int result = -1;
		
		
		// DB연결 수행 , getConnection(); 썼을때 빨간줄 뜨면 서라운드..?
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid); // 상단 ?에 화면입력 id를 바인딩
		 	rs = pstmt.executeQuery();
			
		 	
		 	// rs에 값이 존재하면.. rs.next
		 	if (rs.next()) {  
		 		String db_pwd = rs.getString("pwd");
		 		if (pwd.equals(db_pwd)) {
		 			result = 1; // userid와 pwd가 모두 일치
		 		} else {
		 			result = 0; // 암호가 틀림
		 		}	
		 	} else {
		 		result = -1;
		 	}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	/*
	 * 사용자 아이디로 회원정보 가져오기 
	 */
	
	public MemberVO getMember(String userid){
		Connection conn = null; // 오라클 DB연결 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		String sql = "SELECT * FROM member WHERE userid=?";
		MemberVO member = null;
		
		// DB에 연결 수행
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid); // 상단 ?에 화면입력 id를 바인딩
		 	rs = pstmt.executeQuery();
			

		 	if (rs.next()) {  
		 		member = new MemberVO();
		 		
		 		member.setName(rs.getString("name"));
		 		member.setUserid(rs.getString("userid"));
		 		member.setPwd(rs.getString("pwd"));
		 		member.setEmail(rs.getString("email"));
		 		member.setPhone(rs.getString("phone"));
		 		member.setAdmin(rs.getInt("admin"));
		 	}
		} catch (Exception e) {
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
		
		return member;
		
	}
	
	/*
	회원가입 시, 아이디 중복 체크를 하는 메소드 
	아이디가 존재하면 1
	존재하지 않으면 -1을 반환
	*/
	
	public int confirmID(String userid) {
		Connection conn = null; // 오라클 DB연결 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		String sql = "SELECT * FROM member WHERE userid=?";
		int result = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid); // 상단 ?에 화면입력 id를 바인딩
		 	
			rs = pstmt.executeQuery(); // 해당조건으로 검색하여 값을 rs로 전달
			
		 	
		 	// rs에 값이 존재하면.. rs.next
			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

/* 
* 회원가입 화면에서 전달된 데이터를 member테이블에 저장 
*/

	public int insertMember(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member VALUES(?, ?, ?, ?, ?, ?)";
		int result = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getUserid());
			pstmt.setString(3, member.getPwd());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPhone());
			pstmt.setInt(6, member.getAdmin());
			
			result = pstmt.executeUpdate();
		
		} catch (Exception e) {
			
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

/* 
* 회원정보 수정하여 전달된 데이터를 member테이블에 저장 
*/
		public int updateMember (MemberVO member) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE member SET pwd=?, email=?, phone=?, admin=? "
						+ "WHERE userid=?";
			int result = -1;
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, member.getPwd());
				pstmt.setString(2, member.getEmail());
				pstmt.setString(3, member.getPhone());
				pstmt.setInt(4, member.getAdmin());
				pstmt.setString(5, member.getUserid());
				
				result = pstmt.executeUpdate();
			
			} catch (Exception e) {
				
			} finally {
				try {
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return result;
		}
	}

	















