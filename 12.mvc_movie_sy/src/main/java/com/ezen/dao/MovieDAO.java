//0602 movie 싱글톤 인스턴스 
package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ezen.dto.MovieVO;

import util.DBManager;

public class MovieDAO {
	//싱글톤 클레스로 생성
	private MovieDAO() { }
	
	private static MovieDAO instance = new MovieDAO();
	
	public static MovieDAO getInstance() {
		return instance;
	}
	
	/*
	 * 영화 목록 전체 조회
	 * 최근 등록한 게시이 먼저 나오도록 게시글 목록을 조회
	 */
	public List<MovieVO> selectAllMovies(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM movie ORDER BY code DESC";
		List<MovieVO> movieLise = new ArrayList<>();
	
	try {
		
	} catch (Exception e) {
		
	} finally {
		DBManager.close(conn, pstmt, rs);
	}
	
	
	
	}	
}
