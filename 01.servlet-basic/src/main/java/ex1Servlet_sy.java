

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ex1Servlet
 */
@WebServlet("/ex1Servlet_sy")
public class ex1Servlet_sy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ex1Servlet_sy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int age1 = Integer.parseInt(request.getParameter("age1")); //str타입을 int 타입으로 변환
		int age2 = Integer.parseInt(request.getParameter("age2"));
		String id = request.getParameter("id"); 
		int password = Integer.parseInt(request.getParameter("password")); 
		int password1 = Integer.parseInt(request.getParameter("password1"));   
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String emaillist = request.getParameter("emaillist");
		int postalcode = Integer.parseInt(request.getParameter("postalcode"));
		String Address1 = request.getParameter("Address1");
		String Address2 = request.getParameter("Address2");
		int number = Integer.parseInt(request.getParameter("number"));
		
		System.out.println("id= " + id); System.out.println("age =" + age1);
		  
		  
		  // 사용자의 브라우저로 전송 response.setContentType("text/html; charset=UTF-8");
		  response.setContentType("text/html; charset=UTF-8");
		  PrintWriter out = response.getWriter();
		  out.print("<html><body>");	
		  
			out.print("<html><head><title> 사용자 입력 정보 </title></head>");
			out.print("<body><h1> 당신이 입력한 정보입니다. </h1></body>");
			out.print("이름 : " + name + "<br>");
			out.print("주민번호 : " + age1 + "-" + age2 + "<br>");
			out.print("아 이 디 : " + id + "<br>");
			out.print("비밀번호 : " + password + "<br>");
			out.print("이 메 일 : " + email1 + "@" + email2 + "<br>");
			out.print("우편번호 : " + postalcode + "<br>");
			out.print("주 소 : " + Address1 + Address1 + "<br>");
			out.print("핸드폰번호 : " + password + "<br>");
			out.print("</b><br><a href='javascript:history.go(-1)'>다시</a>");
			out.print("</body></html>");
			out.close();
		  
		  }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
