

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RadioServlet
 */
@WebServlet("/RadioServlet")
public class RadioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RadioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chkMail = request.getParameter("chk_mail");
		String gender = request.getParameter("gender");
		String content = request.getParameter("content");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h3>당신이 입력한 정보입니다</h3>");
			
		out.print("메일 수신여부: <b>" + chkMail + "</b><br>");
		out.print("성별 : <b>" + gender + "</b><br>");
		out.print("가입 인사: <b><pre>" + content + "</pre></b><br>");
		
		// 링크를 넣어서 뒤로가기 만들기, java에서는 링크(href)에 홑따음표 넣어줌
		out.print("<a href='javascript:history.go(-1)'>뒤로가기</a>");
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
