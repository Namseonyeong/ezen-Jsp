//0527 모델2 클라이언트 컨트롤러 
package com.ezen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.controller.action.Action;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println("BoardServlet에서 요청 수신 : " + command);
		
		// 수신한 command를 ActionFactory로 넘겨서 어떤 Action 클래스를 사용할지 판단
		ActionFactory factory = ActionFactory.getInstance();
		Action action = factory.getAction(command); // command에 대한 Action객체를 얻어옴
		
		// action이 null 아니면 execute를 실행해라
		if (action != null) {
			action.execute(request, response); // 전달받은 action객체의 비즈니스 로직 수행
			
			
		}
	}

	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
		
		
	}

}
