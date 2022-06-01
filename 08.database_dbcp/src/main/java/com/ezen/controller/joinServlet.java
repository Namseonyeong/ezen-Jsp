//0525 회원가입 연결
package com.ezen.controller;

import java.io.IOException;
import java.nio.channels.SelectableChannel;

import javax.security.sasl.SaslServer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.mbeans.MemoryUserDatabaseMBean;

import com.ezen.dao.MemberDAO;
import com.ezen.dto.MemberVO;

/**
 * Servlet implementation class joinServlet
 */
@WebServlet("/join.do")
public class joinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/join.jsp";
		
		// request의 내용이 member/join.jsp로 넘어간다
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO member = new MemberVO();
		String url = "member/login.jsp";
		
		// 화면 입력정보를 MemberVO 객체에 저장
		request.setCharacterEncoding("UTF-8");
		member.setName(request.getParameter("name"));
		member.setUserid(request.getParameter("userid"));
		member.setPwd(request.getParameter("pwd"));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter(""));
		member.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		// 회원정보를 DB에 저장
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.insertMember(member);
		
		if (result == 1) {
			request.setAttribute("message", "회원가입 성공!");
			request.getRequestDispatcher(url).forward(request, response);
		} else {
			request.setAttribute("message", "회원가입 실패!");
		}
		
		
		
		
	}

}
