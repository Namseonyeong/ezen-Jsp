//0527 모델2 싱글톤 인스턴스
package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ezen.dto.BoardVO;

import util.DBManager;

public class BoardDAO {
   // 싱글톤 클리스로 생성
   private BoardDAO() { }
   
   private static BoardDAO instance = new BoardDAO();
   
   public static BoardDAO getInstance() {
      return instance;
   }
   
   
   /*
    * 게시글 목록 전체 조회.
    * 최근 등록한 게시글이 먼저 나오도록 게시글 목록을 조회한다.
    */
   public List<BoardVO> selectAllBoards() {
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = "SELECT * FROM board ORDER BY num DESC";
      List<BoardVO> boardList = new ArrayList<>();
      
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
         
         rs = pstmt.executeQuery();
         
         while (rs.next()) {
            BoardVO board = new BoardVO();
            board.setNum(rs.getInt("num"));
            board.setName(rs.getString("name"));
            board.setPass(rs.getString("pass"));
            board.setEmail(rs.getString("email"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            board.setReadcount(rs.getInt("readcount"));
            board.setWritedate(rs.getDate("writedate"));
            
            boardList.add(board);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt, rs);
      }
      
      return boardList;
   }
   
   
   /*
    *   게시글 입력 정보를 DB에 저장.
    */
   public void insertBoard(BoardVO board) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      String sql = "INSERT INTO board(num, pass, name, email, title, content)"
                  + "VALUES(board_seq.NEXTVAL, ?, ?, ?, ?, ?)";
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);   
         pstmt.setString(1, board.getPass());
         pstmt.setString(2, board.getName());
         pstmt.setString(3, board.getEmail());
         pstmt.setString(4, board.getTitle());
         pstmt.setString(5, board.getContent());
         
         pstmt.executeUpdate();
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt);
      }
   }
   
   
   /*
    * 게시글 번호로 해당 게시글을 찾아 게시글 정보를 BoardVO 객체에 저장한다. 실패:null 반환.
    */
   public BoardVO selectOneBoardByNum(String num) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = "SELECT * FROM board WHERE num=?";
      BoardVO board = null;
      
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, num);
         
         rs = pstmt.executeQuery();
         
         if (rs.next()) {
            board = new BoardVO();
            board.setNum(rs.getInt("num"));
            board.setName(rs.getString("name"));
            board.setPass(rs.getString("pass"));
            board.setEmail(rs.getString("email"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            board.setReadcount(rs.getInt("readcount"));
            board.setWritedate(rs.getDate("writedate"));
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt, rs);
      }
      return board;
   }
   
   
   /*
    *   게시글 상세 보기할 때마다 글 번호를 증가시킨다.
    */
   public void updateReadCount(String num) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      String sql = "UPDATE board SET readcount = readcount+1 WHERE num=?";
      
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, num);
         
         pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt);
      }
   }
   public void updateBoard(BoardVO board) {
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   String sql = "UPDATE board SET pass=?, name=?, email=?, title=?, "
			   +"content=? WHERE num=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getPass());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getTitle());
			pstmt.setString(5, board.getContent());
			pstmt.setInt(6, board.getNum());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
   }
   
   public void deleteBoard(String num) {
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   String sql = "DELETE FROM board WHERE num=?";
	   
	   try {
		   conn = DBManager.getConnection();
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, num);
		   
		   pstmt.executeUpdate(); //실행
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DBManager.close(conn, pstmt);
	}
	   
}
   
}

















