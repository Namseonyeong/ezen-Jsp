package com.ezen.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dto.MovieVO;
/*import com.ezen.controler.action.Action;
import com.ezen.controler.action.ActionFactory;*/
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = null;
		
		/*
		 * getAttribute()로 읽은 값이 존재하면 doPost()에서 setAttribute()로 저장한 값임.
		 * 값이 없으면 일반적인 방법으로 화면에서 전달된 데이터를 getParameter()로 읽어줌.
		 */
		if (request.getAttribute("command") != null) {
			command = (String)request.getAttribute("command");
		} else {
			command = request.getParameter("command");
		}
		System.out.println("MovieServlet에서 수신: " + command);
		ActionFactory factory = ActionFactory.getInstance();
		Action action = factory.getAction(command);
		if (action != null) {
			action.execute(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		MovieVO movie = new MovieVO();
		
		String savePath = "images";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		int sizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";
		
		// Multipart로 전송된 데이터는 일반적인 getParameter()로 읽을 수 없으므로
		// Multipart 객체를 생성해서 얻은 파라미터를 내장객체에 저장하여 doGet()으로 넘겨줌.
		// command 입력값이 null이면 MultipartRequest로 전송된다고 가정함
		if (request.getParameter("command") == null) {
			try {
				MultipartRequest multi = new MultipartRequest(
						request, uploadFilePath,
						sizeLimit, encType,
						new DefaultFileRenamePolicy()
						);
				
				movie.setTitle(multi.getParameter("title"));
				movie.setPrice(Integer.parseInt(multi.getParameter("price")));
				movie.setDirector(multi.getParameter("director"));
				movie.setActor(multi.getParameter("actor"));
				// poster 파일명 설정
				String fileName = multi.getFilesystemName("uploadFile");
				movie.setPoster(fileName);
				movie.setSynopsis(multi.getParameter("synopsis"));
				
				request.setAttribute("movie", movie);
				request.setAttribute("command", multi.getParameter("command"));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		doGet(request, response);
	}

}





