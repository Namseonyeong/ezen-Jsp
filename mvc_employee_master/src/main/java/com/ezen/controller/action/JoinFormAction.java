package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dto.EmployeesVO;

public class JoinFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeesVO emp=(EmployeesVO) session.getAttribute("loginUser");
		Integer result=(Integer) session.getAttribute("result");
		if(emp != null && result==2){
			String url = "join.jsp";
			
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}else{
			response.sendRedirect("HrServlet?command=login");
		}	

	}

}
