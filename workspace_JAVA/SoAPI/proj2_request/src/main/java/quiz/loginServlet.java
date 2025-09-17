package quiz;

import java.io.Console;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		System.out.println("가입성공");
		if (id != "") {			
		request.setAttribute("id", id);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		
		// 응답할때 한글깨짐 방징
		response.setContentType("text/html;charset=utf-8;");
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("dopost 실행");
		System.out.println(id);
		System.out.println(pw);
		
		String admin = "admin";
		
		if ( id.equals(admin) && pw.equals("1234")) {
			System.out.println("로그인 성공");
			
			response.getWriter().println("관리자 페이지");
			
		}else {
			
			response.getWriter().println("아이디 :" + id);
			response.getWriter().println("비밀번호 :" +pw);
		
		}
		
		
	}

}
