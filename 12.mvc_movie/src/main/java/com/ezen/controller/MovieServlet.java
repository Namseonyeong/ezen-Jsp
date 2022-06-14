package com.ezen.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.controller.action.Action;
import com.ezen.controller.action.ActionFactory;
import com.ezen.dto.MovieVO;
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
		
		// command = request.getParameter("command");
		/*
		 * 	getAttribute() 로 읽은 값이 존재하면 doPost() 에서 setAttribute() 로 저장한 값임.
		 * 	값이 없으면 일반적인 방법으로 화면에서 전달된 데이터를 getParameter() 로 읽어줌.
		 */
		if (request.getAttribute("command") != null) {
			command = (String)request.getAttribute("command");	// 밑의 post 마지막에서 쓴 movie 객체 담긴 내용을 가져옴.(multi-part 로 입력된 데이터임)
		} else {
			command = request.getParameter("command");			//일반적인경우.(multi-part 입력이 아닌경우)
		}

		System.out.println("MovieServlet에서 요청 수신: " + command);
		
		// 수신한 command를 ActionFactory로 넘겨서 어떤 Action 클래스를 사용할지 판단.
		ActionFactory factory = ActionFactory.getInstance();	
		Action action = factory.getAction(command);		// command에 대한 Action객체를 얻어옴.
		
		// action이 null 아니면 execute를 실행해라.
		if (action != null) {
			action.execute(request, response);			// 전달받은 action객체의 비즈니스 로직 수행.
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		MovieVO movie = new MovieVO();
		
		String savePath = "images";			// 이미지파일은 항상 doPost 방식으로 들어와야함.
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		int sizeLimit = 10 * 1024 * 1024;	// 제한용량: 10mb
		String encType = "UTF-8";
		
		// Multipart로 전송된 데이터는 일반적인 getParameter() 로 읽을 수 없으므로
		// Multipart 객체를 생성해서 얻은 파라미터를 내장객체에 저장하여 doGet() 으로 넘겨줌.
		// command 입력값이 null 이면 MultipartRequest 로 전송된다고 가정함.
		if (request.getParameter("command") == null) {		// if문을 쓴 이유는 null 이면 MultipartRequest를 실행시키라는 이유때문.
			try {
				MultipartRequest multi = new MultipartRequest(request, uploadFilePath,
														sizeLimit, encType, new DefaultFileRenamePolicy());
				// 모든 목록들이 무조건 code 값이 있지만, 업데이트절에 "code" 를 지정을 안해줬기 때문에!! if문을 사용.
				// code값이 없으면 넘어가고, 있으면 밑에 if문 안쪽 수행문을 수행해서 업데이트하게 만듬.
				if (multi.getParameter("code") != null) {		// 영화정보 Update인 경우
					movie.setCode(Integer.parseInt(multi.getParameter("code")));
				}
				movie.setTitle(multi.getParameter("mtitle"));
				movie.setPrice(Integer.parseInt(multi.getParameter("price")));
				movie.setDirector(multi.getParameter("director"));
				movie.setActor(multi.getParameter("actor"));
				// poster 파일명 설정.
				String fileName;
				if (multi.getFilesystemName("poster") == null) {
					fileName = multi.getParameter("nonmakeImg");
				} else {
					fileName = multi.getFilesystemName("poster");
				}
				movie.setPoster(fileName);
				movie.setSynopsis(multi.getParameter("synopsis"));
				// 위문장에 파라미터들은 재사용 불가. 그래서 아래와 같이 movie객체에 저장.
				request.setAttribute("movie", movie);
				request.setAttribute("command", multi.getParameter("command"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		doGet(request, response);

	}
}
