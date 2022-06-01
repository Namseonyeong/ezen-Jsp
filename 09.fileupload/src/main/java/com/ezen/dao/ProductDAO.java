//0526 쇼핑몰 관련 싱글톤 클래스
package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ezen.dto.ProductVO;

import util.DBManager;

public class ProductDAO {
	private ProductDAO() {
	}

	private static ProductDAO instance = new ProductDAO();

	public static ProductDAO getInstance() {
		return instance;
	}
	

/*
전체 상품 목록 조회
*/
	
	public List<ProductVO> selectAllProucts(){
		Connection conn = null; // 오라클 DB연결 객체
		PreparedStatement pstmt = null; 
		ResultSet rs = null;  // 결과 저장을 위한 변수
		String sql = "SELECT * FROM product ORDER BY code";
		
		List<ProductVO> productList = new ArrayList<ProductVO>();
		
		
		// DB에 연결 수행
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 데이터 검색
			
			while (rs.next()) {
				// 개별상품 하나씩 저장
				ProductVO product = new ProductVO();
				product.setCode(rs.getInt("code")); // 읽어온다 
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setPictureurl(rs.getString("pictureurl"));
				product.setDescription(rs.getString("description"));
				
				// 리스트에 항목을 추가
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return productList;
	}

	
	
/*
 * 상품 등록하면 
 */	
	public void insertProduct(ProductVO product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO product VALUES(product_seq.NEXTVAL, ?, ?, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getPictureurl());
			pstmt.setString(4, product.getDescription());
			
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	
/*
 * 0527 / 현재 상품 정보를 얻어온다 
 */	
	
	public ProductVO selectPorductByCode(String code)  {
		Connection conn = null; // 오라클 DB연결 객체
		PreparedStatement pstmt = null; 
		ResultSet rs = null;  // 결과 저장을 위한 변수
		String sql = "SELECT * FROM product WHERE code=?";
		ProductVO product = new ProductVO();
		
		
			// DB에 연결 수행
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery(); // 데이터 검색 (조회)
			
			//한건이라서 while문이 아닌 if문 사용
			if (rs.next()) {
				product.setCode(rs.getInt("code"));
				product.setName(rs.getNString("name"));
				product.setPrice(rs.getInt("price"));
				product.setPictureurl(rs.getString("pictureurl"));
				product.setDescription(rs.getString("description"));
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return product;
	}
	
	/*
	 * 0527 / 상품 정보를 수정한다
	 */
	
	public void updateProduct(ProductVO product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE product SET name=?, price=?, pictureurl=?,"
				+ "description=? WHERE code=?";  //code를 조건으로 하기때문에 WHERE에 넣어준다

		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getPictureurl());
			pstmt.setString(4, product.getDescription());
			pstmt.setInt(5, product.getCode());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn,pstmt);
			}
		}
	}
	
	/*
	 * 0527 / 상품 정보를 삭제한다
	 */
	
	public void deleteProduct(String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM product WHERE code=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);

			pstmt.executeUpdate(); // 수행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
	

