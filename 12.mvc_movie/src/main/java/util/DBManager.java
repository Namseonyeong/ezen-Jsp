package util;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {

	public static Connection getConnection() {
		Connection conn = null;	
		
		
		try {
			// "JNDI(Java Naming and Directory Interface)" 초기화. ("JNDI" 를 이용하기 위한 객체 생성)
			Context initContext = new InitialContext();
			// lookup() --> 지정된 이름으로 등록된 서비스를 찾을 때 사용.
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			// JDBC 연결 서비스 등록.
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();	// DBCP 에 등록된 오라클 연결을 할당받는다.
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/*
	 * 	Select문 수행 후 close() 메소드.
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
	 * 	Update, Insert, Delete문 수행후 close() 메소드.
	 */
	public static void close(Connection conn, Statement stmt) { //stmt는 psmt 조상타입.
		try {
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


