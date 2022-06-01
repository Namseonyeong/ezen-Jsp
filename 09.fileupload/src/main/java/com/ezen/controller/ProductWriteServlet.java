//0526
package com.ezen.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.ProductDAO;
import com.ezen.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ProductWriteServlet
 */
@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "product/productWrite.jsp";
		
		//결과화면 이동
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * 
	 */	
	
	// 상품등록 클릭하여 데이터 보내기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		String realPath = context.getRealPath("upload");
		int sizeLimit = 10 * 1024 * 1024; // 파일 사이즈 제한 : 10mb
		String encType = "UTF-8";
		
		
		// 화면에서 전송된 File과 텍스트 데이터를 받아온다.
		MultipartRequest multi = new MultipartRequest(
				request, realPath,
				sizeLimit, encType,
				new DefaultFileRenamePolicy()
				); 
		
		// 화면에서 전송된 데이터를 ProductVO 객체에 저장
		ProductVO product = new ProductVO();
		
		// 멀티로 했을때는 리퀘스트가 아닌 멀티객체로 설정해야됨
		product.setName(multi.getParameter("name"));
		product.setPrice(Integer.parseInt(multi.getParameter("price")));
		product.setDescription(multi.getParameter("description"));
		// PictureUrl의 파일명을 읽어온다
		String fileName = multi.getFilesystemName("pictureurl");
		product.setPictureurl(fileName);
		
		// 데이터베이스에 입력 데이터 저장
		ProductDAO pDao = ProductDAO.getInstance();
		pDao.insertProduct(product);
		
		// 확인을 위해 상품목록 출력요청
		response.sendRedirect("productList.do");
		
		
	}

}
