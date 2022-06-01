//0517 request 객체 (id값과 나이 가져오기)

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParamServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
		  protected void doGet(HttpServletRequest request, HttpServletResponse
		  response) throws ServletException, IOException { // 화면에서 입력한 사용자 입력정보를 읽어온다.
		  String id = request.getParameter("id"); int age =
		  Integer.parseInt(request.getParameter("age")); //str타입을 int 타입으로 변환
		  
		  System.out.println("id= " + id); System.out.println("age =" + age);
		  
		  
		  // 사용자의 브라우저로 전송 response.setContentType("text/html; charset=UTF-8");
		  PrintWriter out = response.getWriter();
		  
		  out.print("<html><head><title> 사용자 입력 정보 </title></head>");
		  out.print("<body><h1> 당신이 입력한 정보입니다. </h1></body>"); out.print("아이디 : " + id
		  +"<br>"); out.print("나 이 : " + age +"<br>"); out.close();
		  
		  }
		 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()에서 실행...");

		// post 방식에서는 반드시 한글 인코딩 설정을 해야함.
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age")); // str타입을 int 타입으로 변환

		System.out.println("id= " + id);
		System.out.println("age =" + age);

//		사용자의 브라우저로 전송
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<html><head><title> 사용자 입력 정보 </title></head>");
		out.print("<body><h1> 당신이 입력한 정보입니다. </h1></body>");
		out.print("아이디 : " + id + "<br>");
		out.print("나 이 : " + age + "<br>");
		out.close();
	}

}
