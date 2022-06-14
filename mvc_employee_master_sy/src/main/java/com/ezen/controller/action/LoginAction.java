package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.EmployeesDAO;
import com.ezen.dto.EmployeesVO;

public class LoginAction implements Action {

	/*
	 * [문제6]
	 * "로그인" 버튼을 클릭하면 사용자 인증을 수행하는 LoginAction클래스를 작성하시오.
	 * <조건>
     * (1) Action 인터페이스를 implement하여 execute() 메소드를 구현한다.
     * (2) 화면에서 입력한 id, pwd, lev 파라미터를 읽어온다.
     * (3) EmployeesDAO 객체의 userCheck를 호출하여 반환 결과에 따라 다음과 같이 처리한다.
     *     - result가 2 또는 3이면 DAO에서 사원정보를 조회하고, 
     *     - Session 객체에 “loginUser” 속성으로 사원정보를 저장하고, “result” 속성에 userCheck()의 반환값을 저장한다.
     *     - url을 “main.jsp”로 지정하여 forward한다.
     *     - result가 1이면 “message” 속성에 “사용자 레벨을 확인하여 주십시오.”를 저장하고 “login.jsp”로 forward한다. 
     *     - result가 0이면 “message” 속성에 “비밀번호가 맞지 않습니다”를 저장하고 “login.jsp”로 forward한다.
     *     - result가 –1이면 “message” 속성에 “아이디가 맞지 않습니다.”를 저장하고 “login.jsp”로 forward한다.
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();	
        
        String userid = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String lev = request.getParameter("lev");
        String url = null;
        
        EmployeesDAO eDao = EmployeesDAO.getInstance();
		int result = eDao.userCheck(userid, pwd, lev);
		
        if (result == 2 || result == 3) {
            url="main.jsp";
            EmployeesVO emp = eDao.getMember(userid);
            session.setAttribute("loginUser", emp);

            request.setAttribute("result", result);
    
        } else if (result == 1) {
            url = "login.jsp";

            request.setAttribute("message", "사용자 레벨을 확인하여 주십시오.");
       
        } else if (result == 0) {
            url = "login.jsp";

            request.setAttribute("message", "비밀번호가 맞지 않습니다");
            
        } else if (result == -1) {
            url = "login.jsp";

            request.setAttribute("message", "아이디가 맞지 않습니다.");
            
        }

        request.getRequestDispatcher(url).forward(request, response);
	}

}
