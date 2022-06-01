//0530 게시판 글 클릭하여 작성시 비밀번호 맞는지 확인 후 수정 또는 삭제 폼으로 이동
package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BoardDAO;
import com.ezen.dto.BoardVO;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		// 화면 입력 내용 가져오기
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		
		// DB에서 게시글 조회
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO board = bDao.selectOneBoardByNum(num);

		if (pass.equals(board.getPass())) {
			// 비밀번호가 일치하면 Update 또는 Delete화면 출력
			url = "board/checkSuccess.jsp";
		} else {
			// 비밀번호가 일치하지 않으면 "boardCheckPass.jsp"화면에 메시지를 전달
			request.setAttribute("message", "비밀번호가 일치하지 않습니다. 다시 확인해 주세요.");
			url = "board/boardCheckPass.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}