

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex1Servlet
 */
@WebServlet("/Ex1Servlet")
public class Ex1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1Servlet() {
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
		String name = request.getParameter("name");
		String jumin_no = request.getParameter("jumin1") + "-"
						+ request.getParameter("jumin2");
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		String email = request.getParameter("email_id");
		String zipcode = request.getParameter("zipcode");
		String address = request.getParameter("addr1") + " "
						+ request.getParameter("addr2");
		String phone = request.getParameter("phone");
		String job = request.getParameter("job");
		String chk_mail = request.getParameter("chk_mail");
		String[] interest = request.getParameterValues("interest");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("이름 : <b>" + name + "</b><br>");
		out.print("주민번호 : <b>" + jumin_no + "</b><br>");
		out.print("아 이 디 : <b>" + id + "</b><br>");
		out.print("비밀번호 : <b>" + pwd + "</b><br>");
		out.print("이 메 일 : <b>" + email + "</b><br>");
		out.print("우편번호 : <b>" + zipcode + "</b><br>");
		out.print("주소 : <b>" + address + "</b><br>");
		out.print("핸드폰번호 : <b>" + phone + "</b><br>");
		out.print("직업 : <b>" + job + "</b><br>");
		out.print("메일수신 여부 : <b>" + chk_mail + "</b><br>");
		out.print("관심분야 : <b>");
		if (interest == null) {
			out.print("선택한 항목이 없습니다.");
		} else {
			for(String item : interest) {
				out.print(item + " ");
			}
		}
		out.print("</b><br><br>");
		out.print("<a href='javascript:history.go(-1)'>다시</a>");
	}

}
