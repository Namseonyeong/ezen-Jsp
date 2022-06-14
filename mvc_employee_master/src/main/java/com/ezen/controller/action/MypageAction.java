package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.EmployeesDAO;
import com.ezen.dto.EmployeesVO;

public class MypageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		System.out.println(request.getParameter("name"));
		HttpSession session = request.getSession();	
		EmployeesVO member = new EmployeesVO();
		member.setId(request.getParameter("id"));
		member.setPass(request.getParameter("pwd"));
		member.setName(request.getParameter("name"));
		member.setLev(request.getParameter("lev"));
		
		if(request.getParameter("gender")!=null)
			member.setGender(Integer.parseInt(request.getParameter("gender").trim()));
		member.setPhone(request.getParameter("phone"));
				
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		eDao.updateMember(member);
		
		EmployeesVO emp = eDao.getMember(member.getId());
		
		request.setAttribute("member", emp);
		request.setAttribute("message", "회원 정보가 수정되었습니다.");
				
		session.setAttribute("loginUser", emp);
		
		System.out.println(emp);
		
		int result = eDao.userCheck(member.getId(), 
				member.getPass(), member.getLev());
		session.setAttribute("result", result);
		
		String url="joinsuccess.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);	

	}

}
