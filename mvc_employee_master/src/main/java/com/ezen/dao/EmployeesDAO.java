package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ezen.dto.EmployeesVO;

public class EmployeesDAO {
	private EmployeesDAO() {
	}
	
	private static EmployeesDAO instance = new EmployeesDAO();
	
	public static EmployeesDAO getInstance() {
		return instance;
	}

	Connection getConnection(){
		Connection conn = null;
		Context initContext;
		
		try{
			initContext = new InitialContext();
	        Context  envContent = (Context) initContext.lookup("java:/comp/env");
	        DataSource  ds = (DataSource) envContent.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			
		}catch(NamingException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public int userCheck(String userid, String pwd, String lev){
		/* 
		 * [문제4]
		 * 애플리케이션에서 데이터베이스에 접근하는 EmployeesDAO 클래스를 싱글톤 클래스로 
		 * 생성하고 사용자 ID, 암호, 사용자 레벨을 조건으로 사용자 인증을 수행하는 
		 * userCheck() 메소드를 작성하시오. (15점)
         * <조건>
         * 리턴값: 아이디가 맞지 않으면 –1 리턴
         * 비밀번호가 맞지 않으면 0을 리턴
         * 레벨이 불일치 하면 1을 리턴
         * 관리자로 로그인 성공이면 2를 리턴
         * 일반회원으로 로그인 성공이면 3을 리턴한다.
		 */
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		String sql = "SELECT * FROM employees WHERE id=?";
		int result = -1;
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
		 	rs = pstmt.executeQuery();
		 	
		 	if (rs.next()) {  
		 		String db_pwd = rs.getString("pass");
		 		String db_lev = rs.getString("lev");

		 		if (!pwd.equals(db_pwd)) {
		 			result = 0; // 암호가 틀림
		 		} else if(!lev.equals(db_lev)) {
		 			result = 1;
		 		} else if(lev.equals("A")) {
		 			result = 2;
		 		} else if(lev.equals("B")) {
		 			result = 3;} 		
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
	
	
	
	
	
	
	
	
	
	
	
	public EmployeesVO getMember(String id){
		Connection conn = null; // 오라클 DB연결 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		String sql = "SELECT * FROM employees WHERE id=?";
		EmployeesVO employee = null;
		/*
		 * [문제5]
		 * 사용자 id를 조건으로 사용자 정보를 조회하는 getMember() 메소드를 작성하시오.
		 */
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); 
		 	rs = pstmt.executeQuery();
		 	
		 	if(rs.next()) {
		 	 employee = new EmployeesVO ();
		 	 
		 	employee.setId(rs.getString("id"));
		 	employee.setPass(rs.getString("pass"));
		 	employee.setName(rs.getString("name"));
		 	employee.setLev(rs.getString("lev"));
		 	employee.setEnter(rs.getDate("enter"));
		 	employee.setGender(rs.getInt("gender"));
		 	employee.setPhone(rs.getString("phone"));
		 		
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
		return employee;
	}
	
	
	
	public void insertMember(EmployeesVO member) {
		String sql = "insert into employees values(?,?,?,?,SYSDATE,?,?)";		
		Connection conn = null;

		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			// ?에 값 세팅
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getLev());			
			pstmt.setInt(5, member.getGender());
			pstmt.setString(6, member.getPhone());
			System.out.println(pstmt.executeUpdate());			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public int updateMember(EmployeesVO eVo) {
		int result = -1;
		String sql = "update employees set gender=?, pass=?, name=?, lev=?, phone=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eVo.getGender());
			pstmt.setString(2, eVo.getPass());
			pstmt.setString(3, eVo.getName());
			pstmt.setString(4, eVo.getLev());
			pstmt.setString(5, eVo.getPhone());
			pstmt.setString(6, eVo.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}	
}
