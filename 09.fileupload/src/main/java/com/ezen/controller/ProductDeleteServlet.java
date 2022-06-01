// 0527 상품 삭제하기 
package com.ezen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.ProductDAO;
import com.ezen.dto.ProductVO;

/**
 * Servlet implementation class ProductDeleteServlet
 */
@WebServlet("/productDelete.do")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    // 상품 정보 삭제 화면 구현
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "product/productDelete.jsp";
		String code = request.getParameter("code"); // 화면에서 상품 코드를 가져온다
		
		// 코드값으로 DB에서 상품 조회
		ProductDAO pDao = ProductDAO.getInstance(); //객체 생성
		ProductVO product = pDao.selectPorductByCode(code);
		
		request.setAttribute("product", product);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	
	
	
	// 상품 삭제 클릭하여 데이터 삭제
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("code"); // 화면에서 상품 코드를 가져온다
		
		ProductDAO pDao = ProductDAO.getInstance();
		pDao.deleteProduct(code);
		
		response.sendRedirect("productList.do");
		
		
		
		
		
	}

}
