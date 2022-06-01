

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.javabean.MemberBeans;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		멤버빈 생성
		MemberBeans member1 = new MemberBeans("이순신", "sslee");
		
//		                     "member":속성에 지정, member1:참조변수
		request.setAttribute("member", member1);
		
//		request 전달, 화면에서 입력받은 데이터를 전달할때 
//		사용자 브라우저에서 서블릿으로 데이터를 전달→ 멤버빈 객체에다가 화면에 올라온 데이터 저장 →
//		사용자의 화면에 08_member_info.jsp"을 통하여 다시 전달
		RequestDispatcher rd = request.getRequestDispatcher("08_member_info.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
