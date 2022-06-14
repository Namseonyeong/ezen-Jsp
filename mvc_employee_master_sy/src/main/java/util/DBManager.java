package util;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			// JNDI 초기화(객체 생성)
			Context initContext = new InitialContext();
			// naming으로 등록된 서비스 자원을 찾을 때 사용하는 메소드
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			// JDBC 연결 서비스 등록
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;		
	}
	
	/*
	 * Select 문 수행후 close() 메소드
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Update, Delete, Insert문 수행 후 close() 메소드
	 */
	public static void close(Connection conn, Statement stmt ) {
		try {
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
