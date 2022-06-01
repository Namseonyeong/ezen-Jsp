//0530
package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BoardDAO;
import com.ezen.dto.BoardVO;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO board = new BoardVO();
		
		board.setName(request.getParameter("name"));
		board.setPass(request.getParameter("pass"));
		board.setEmail(request.getParameter("email"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.insertBoard(board);
		
		// 게시글 목록 확인
		new BoardListAction().execute(request, response);
		
		// 예전방식
		//response.sendRedirect("boardList.do");
	}

}
