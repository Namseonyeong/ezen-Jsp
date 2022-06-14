package com.ezen.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ezen.dto.MovieVO;

import util.DBManager;

public class MovieDAO {
	// 싱글톤 클리스로 생성
	private MovieDAO() { }
	
	private static MovieDAO instance = new MovieDAO();
	
	public static MovieDAO getInstance() {
		return instance;
	}
	
	
	/*
	 * 모든 영화정보 전체 조회.
	 * 영화목록이 최근 등록한 순으로 나오도록 조회한다.
	 */
	public List<MovieVO> selectAllMovie() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM movie ORDER BY code DESC";
		ArrayList<MovieVO> movieList = new ArrayList<>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MovieVO movie = new MovieVO();
				movie.setCode(rs.getInt("code"));
				movie.setTitle(rs.getString("title"));
				movie.setPrice(rs.getInt("price"));
				movie.setDirector(rs.getString("director"));
				movie.setActor(rs.getString("actor"));
				movie.setPoster(rs.getString("poster"));
				movie.setSynopsis(rs.getString("synopsis"));
				
				movieList.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return movieList;
	}
	
	
	/*
	 *	 등록화면에서 입력 정보를 DB에 저장.
	 */
	public void insertMovie(MovieVO movie) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO movie VALUES(movie_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, movie.getTitle());
			pstmt.setInt(2, movie.getPrice());
			pstmt.setString(3, movie.getDirector());
			pstmt.setString(4, movie.getActor());
			pstmt.setString(5, movie.getPoster());
			pstmt.setString(6, movie.getSynopsis());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	
	/*
	 * 	선택한 한가지의 영화 상세정보만 조회.
	 */
	public MovieVO selectMovieByCode(String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM movie WHERE code=?";
		MovieVO movie = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				movie = new MovieVO();
				
				movie.setCode(rs.getInt("code"));
				movie.setTitle(rs.getString("title"));
				movie.setPrice(rs.getInt("price"));
				movie.setDirector(rs.getString("director"));
				movie.setActor(rs.getString("actor"));
				movie.setPoster(rs.getString("poster"));
				movie.setSynopsis(rs.getString("synopsis"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	
		return movie;
	}

	
	/*
	 * 	수정한 상세정보를 DB에 업데이트.
	 */
	public void updateMovie(MovieVO movie) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE movie SET title=?, price=?, director=?, actor=?,"
						+ "poster=?, synopsis=? WHERE code=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, movie.getTitle());
			pstmt.setInt(2, movie.getPrice());
			pstmt.setString(3, movie.getDirector());
			pstmt.setString(4, movie.getActor());
			pstmt.setString(5, movie.getPoster());
			pstmt.setString(6, movie.getSynopsis());
			pstmt.setInt(7, movie.getCode());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	
	/*
	 * 	영화정보 삭제.
	 */
	public void deleteMovie(String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM movie WHERE code=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, code);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}		
}		


	

