//0525 아이디 중복체크 
package com.ezen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDAO;

/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/idCheck.do")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheckServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/idCheck.jsp";
		
		// 화면에서 입력 파라미터 읽어오기
		String userid = request.getParameter("userid");
		
		// 사용자 ID를 DB에서 조회  (MemberDAO에서 조회쿼리 작성 후 작성함)
		MemberDAO mDao = MemberDAO.getInstance();
		int status = mDao.confirmID(userid);
		
		// jsp에 넘겨주기 위한 결과를 내장객체에 저장
		request.setAttribute("userid", userid);
		request.setAttribute("result", status);
		
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
