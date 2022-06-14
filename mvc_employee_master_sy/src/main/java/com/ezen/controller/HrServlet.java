package com.ezen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.controller.action.Action;
import com.ezen.controller.action.ActionFactory;

/**
 * Servlet implementation class HrServlet
 */
@WebServlet("/HrServlet")
public class HrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HrServlet() {
        super();
     
    }

    /*
     * [문제3]
     * 사용자의 요청 URL을 수신하여 “command” 파라미터를 읽고 ActionFactory에서 command 
     * 파라미터를 해석하여 업무모듈(Action 클래스)을 실행시키는 서블릿을 작성하시오.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		ActionFactory factory = ActionFactory.getInstance();
		Action action = factory.getAction(command); 
		

		if (action != null) {
			action.execute(request, response); 
			
		}
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	
		doGet(request, response);
		
	}
}
