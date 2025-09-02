package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main")
public class mainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		HttpSession sess = request.getSession();
//		// 세션 받아 오기 
//		if(sess.getAttribute("login") != null) {
//					
//		request.setAttribute("codeName", "3500");
//		// forward는 내부 전환으로 필터를 거치지 않고 바로 간다.
//		request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request, response);;
//		}else {
//			response.sendRedirect("login.html");
//		}
//		 
		request.setAttribute("codeName", "3500");
		// forward는 내부 전환으로 필터를 거치지 않고 바로 간다.
		request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request, response);;
	}
}
