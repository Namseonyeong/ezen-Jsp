package util;

import java.sql.*;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DBManager {

	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			// JNDI(Java Naming and Directory Interface) 초기화(JNDI를 이용하기 위한 객체 생성)
			Context initContext = new InitialContext();
			// lookup() - 지정된 이름으로 등록된 서비스를 찾을 때 사용
			Context envContext = (Context) initContext.lookup("java:/comp/env");
	
			// JDBC 연결 서비스 등록
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection(); // DBCP에 등록된 오라클 연결을 할당받음
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn; // 커넥션 타입을 리턴
	}
	
/*
select문 수행 수 close() 메소드
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
Update, Insert, Delete문 수행 수 close() 메소드
아래의 메소드에서는 ResultSet이 필요없다.
*/
	
	public static void close(Connection conn, Statement stmt) {
		try {
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
