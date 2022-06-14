package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MovieDAO;
import com.ezen.dto.MovieVO;

public class MovieWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// movieServlet 에서 마지막 부분 setAttribute에 movie에 저장된 데이터를 가져옴.
		MovieVO movie = (MovieVO) request.getAttribute("movie");
		
		MovieDAO mDao = MovieDAO.getInstance();
		mDao.insertMovie(movie);
		
		// 확인차 무비리스트를 호출.(영화목록 모듈 호출)
		new MovieListAction().execute(request, response);

	}

}
