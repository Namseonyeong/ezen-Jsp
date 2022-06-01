//0527 상품 수정하기
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
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // 0527 상품수정화면으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "product/productUpdate.jsp";
		String code = request.getParameter("code"); //화면에서 상품 코드를 가져온다
		
		// 코드값으로 DB에서 상품조회
		ProductDAO pDao = ProductDAO.getInstance();  // 객체생성
		ProductVO product = pDao.selectPorductByCode(code);
		
		// 내장객체에 상품정보 저장, " " 없는것은 바로위 pDao의 값
		request.setAttribute("product", product);
		
		//상품 수정화면 출력
		request.getRequestDispatcher(url).forward(request, response);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// 0527 상품 수정 클릭하여 데이터 변경
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		ServletContext context = getServletContext();
		String realPath = context.getRealPath("upload");
		int sizeLimit = 10 * 1024 * 1024; // 파일 사이즈 제한 : 10mb
		String encType = "UTF-8";

		// 화면에서 전송된 File과 텍스트 데이터를 받아온다.
		MultipartRequest multi = new MultipartRequest(request, realPath, sizeLimit, encType,
				new DefaultFileRenamePolicy());

		// 화면에서 전송된 데이터를 ProductVO 객체에 저장
		ProductVO product = new ProductVO();
		
		product.setCode(Integer.parseInt(multi.getParameter("code")));
		product.setName(multi.getParameter("name"));
		product.setPrice(Integer.parseInt(multi.getParameter("price")));
		product.setDescription(multi.getParameter("description"));
		
		// 이미지 수정한다!
		String picture = multi.getFilesystemName("pictureurl");
		
		
		//사용자가 상품이미지를 변경하지 않았을때의 처리
		if (picture == null) { //이미지를 수정 안했을 경우
			product.setPictureurl(multi.getParameter("noupdateImg"));
		} else {
			product.setPictureurl(picture); //새로 변경된 이미지를 설정
		}
		
		// 업데이트
		ProductDAO pDao = ProductDAO.getInstance();
		pDao.updateProduct(product);
		
		// 출력
		response.sendRedirect("productList.do");
	}

}
