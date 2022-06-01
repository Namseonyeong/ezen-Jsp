//0526 회원정보 수정
package com.ezen.controller;

import java.io.IOException;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.ezen.dao.MemberDAO;
import com.ezen.dto.MemberVO;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String url = "member/memberUpdate.jsp";
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO member = mDao.getMember(userid);
	
		// 여러페이지는 세션
		request.setAttribute("member", member);
		request.getRequestDispatcher(url).forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		//회원수정에서 확인 버튼을 누르면 DB내용 업데이트 시킬때 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO member = new MemberVO();
		String url = "main.jsp";
		
		request.setCharacterEncoding("UTF-8");
		member.setName(request.getParameter("name"));
		member.setUserid(request.getParameter("userid"));
		member.setPwd(request.getParameter("pwd"));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter(""));
		member.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.updateMember(member);
		
		if (result>0) { // 업데이트가 정살일 경우 세션에 회원정보 수정
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", member); //loginUser의 정보를 가지고 member를 업데이트
		}
		// GET방식으로 LoginServlet에 요청
		response.sendRedirect("login.do"); 
	}

}
