//0530
package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BoardDAO;
import com.ezen.dto.BoardVO;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/boardView.jsp";
		
		String num = request.getParameter("num");
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		// 게시글 조회수 증가
		bDao.updateReadCount(num);
		// 게시글 상세정보 조회
		BoardVO board = bDao.selectOneBoardByNum(num);
		
		request.setAttribute("board", board);
		request.getRequestDispatcher(url).forward(request, response);;

	}

}
