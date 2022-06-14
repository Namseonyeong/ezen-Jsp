package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MovieDAO;
import com.ezen.dto.MovieVO;

public class MovieUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "movie/movieUpdate.jsp";
		String code = request.getParameter("code");
		
		MovieDAO mDao = MovieDAO.getInstance();
		MovieVO movie = mDao.selectMovieByCode(code);
		
		request.setAttribute("movie", movie);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
