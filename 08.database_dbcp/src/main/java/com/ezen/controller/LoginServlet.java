//0525 login.jsp 파일에서 사용자가 입력한 id,pw값 읽어오기 (doPost)
package com.ezen.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.MemberDAO;
import com.ezen.dto.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();

    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		index.jsp 로 넘어가도록 처리
		String url = "member/login.jsp";
		
		// 이미 로그인된 사용자이면 main.jsp로 이동
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		if (member != null) { //로그인된 사용자
			url = "main.jsp";	
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp";
		request.setCharacterEncoding("UTF-8");
		
		// 화면에서 입력한 파라미터값 읽어오기
		String userid = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
//		System.out.printf("id=%s, pwd=%s\n", userid, pwd);
		MemberDAO mDao = MemberDAO.getInstance();
		int status = mDao.userCheck(userid, pwd);
		
		if (status == 1) {
			System.out.println("정상적인 로그인");
			// 정상 로그인시 사용자 정보 조회
			MemberVO member =  mDao.getMember(userid);
			// 세션 내장객체에 사용자정보 저장
		    HttpSession session = request.getSession();
			session.setAttribute("loginUser", member);
		    
			url = "main.jsp";
		} else if (status == 0) {
			System.out.println("비밀번호가 맞지 않습니다.");
			request.setAttribute("massage", "비밀번호가 맞지 않습니다.");
		} else if (status == -1) {
			System.out.println("아이디가 존재하지 않습니다.");
			request.setAttribute("message", "사용자 아이디가 존재하지 않습니다!");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
