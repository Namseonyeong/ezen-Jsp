package com.ezen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		String savePath = "upload"; // 업로드 파일을 저장할 폴더명
		
		// 업로드 폴더의 실제 경로를 구하기
		ServletContext context = getServletContext(); // 프로젝트 정보 가져오기
		String uploadFilePath =  context.getRealPath(savePath); // 실제 디렉토리를 가져옴
		System.out.println("실제 업로드 파일의 경로 : " + uploadFilePath);
		
		int uploadFileSize = 5 * 1024 * 1024; // 5M(바이트 단위)
		String encType = "UTF-8";
		
		MultipartRequest multi = new MultipartRequest(
				request,
				uploadFilePath,
				uploadFileSize,
				encType,
				new DefaultFileRenamePolicy());
		
			//화면에서 업로드한 파일의 이름을 가져온다.
			String fileName = multi.getFilesystemName("upload_file");
			
			if (fileName == null) {
				System.out.println("파일이 업로드 되지않았습니다.");
			} else {
				out.println("글쓴이 : " + multi.getParameter("writer")+"<br>");
				out.println("제 목 : " + multi.getParameter("title")+"<br>");
				out.println("파일명 :" + fileName);
			}

		}

	}
