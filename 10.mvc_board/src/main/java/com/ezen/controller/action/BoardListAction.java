package com.ezen.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BoardDAO;
import com.ezen.dto.BoardVO;

public class BoardListAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "board/boardList.jsp";
      
      // DB에서 게시글 목록 전체 조회
      BoardDAO bDao = BoardDAO.getInstance();
      List<BoardVO> boardList = bDao.selectAllBoards();
      
      // 조회내용을 내장객체에 저장
      request.setAttribute("boardList", boardList);

      request.getRequestDispatcher(url).forward(request, response);
   }

}