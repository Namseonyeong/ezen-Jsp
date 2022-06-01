//0530 수정화면 띄우기 (조회 포함)
package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BoardDAO;
import com.ezen.dto.BoardVO;

public class BoardUpdateFormAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "board/boardUpdate.jsp";
      
      String num = request.getParameter("num");
      
      BoardDAO bDao = BoardDAO.getInstance();
      BoardVO board = bDao.selectOneBoardByNum(num);
      
      request.setAttribute("board", board);
      request.getRequestDispatcher(url).forward(request, response);
      
   }

}