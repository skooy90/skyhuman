package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Mypage")
public class MypageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		HttpSession sess = request.getSession(false);
		if (sess == null) {
			System.out.println("로그인 안함 1");
			System.out.println("처음 방문");
			// 로그인 안함
			response.sendRedirect("cookie_5.jsp");

		} else {
			System.out.println("로그인 안함 2");
			System.out.println("처음 방문은 아님");
			
			// getAttribute : 없으면 null
			Boolean login = (Boolean) sess.getAttribute("login");
			if (login == null || login != true) {
				// 로그인 안함
				response.sendRedirect("cookie_5.jsp");
			}else {
				response.getWriter().println("로그인 해야 올 수 있는 곳");
				response.getWriter().println("아이디 : " + sess.getAttribute("userId"));
				
			}

		}


	}

}
