package com.ezen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MulitUploadServlet
 */
@WebServlet("/multi_upload.do")
public class MulitUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MulitUploadServlet() {
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
		
		Enumeration<String> files = multi.getFileNames();
		
		while(files.hasMoreElements()) {
			String file = files.nextElement();
			
			String fileName = multi.getFilesystemName(file); // 업로드시 파일명
			String originFile = multi.getOriginalFileName(file); // rename이전 기존 파일명
			
			out.println("업로드 파일명 : " + fileName + "<br>");
			out.println("원본 파일명 ; " + originFile + "<br>");
			out.println("<hr>");
 			
		}
		
	}

}
