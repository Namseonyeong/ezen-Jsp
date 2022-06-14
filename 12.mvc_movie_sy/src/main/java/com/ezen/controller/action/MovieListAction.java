//0602  DB에서 게시글 목록 전체 조회
package com.ezen.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.controller.Action;
import com.ezen.dao.MovieDAO;
import com.ezen.dto.MovieVO;

public class MovieListAction extends Action {

	  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String url = "movie/movieList.jsp";
		  
		  // DB에서 게시글 목록 전체 조회
		  MovieDAO bDao = MovieDAO.getInstance();
		  List<MovieVO> movieList = bDao.selectAllMovies();
		  
		  // 조회내용을 내장객체에 저장
		  request.setAttribute("movieList", movieList);
		  
		  request.getRequestDispatcher(url).forward(request, response);
		  
		  
		}
	}
