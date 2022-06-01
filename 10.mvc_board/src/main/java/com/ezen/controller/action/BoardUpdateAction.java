//0530 수정화면 
package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BoardDAO;
import com.ezen.dto.BoardVO;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO board = new BoardVO();
		board.setNum(Integer.parseInt(request.getParameter("num")));
		board.setName(request.getParameter("name"));
		board.setPass(request.getParameter("pass"));
		board.setEmail(request.getParameter("email"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));

		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateBoard(board);
		
		// 게시글 목록 출력 
		new BoardListAction().execute(request, response);
		

	}

}
