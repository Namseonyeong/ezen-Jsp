// 0530 글목록을 눌러서 게시글 수정 버튼 눌렀을경우에 해당 글 작성시에 입력한 비밀번호 창 띄우기
package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardCheckPassFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/boardCheckPass.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
