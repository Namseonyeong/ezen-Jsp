package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dto.EmployeesVO;

public class MyPageFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeesVO emp = (EmployeesVO) session.getAttribute("loginUser");	
		if(emp != null){
			String url="mypage.jsp";
			
			//EmployeesDAO eDao = EmployeesDAO.getInstance();
			//EmployeesVO employee = eDao.getMember(emp.getId());
		
			request.setAttribute("loginUser", emp);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}else{
			response.sendRedirect("login.do");
		}

	}

}
