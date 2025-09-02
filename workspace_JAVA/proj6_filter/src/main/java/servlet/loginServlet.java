package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spw = request.getParameter("pw");
		if("1234".equals(spw)) {
			HttpSession sess = request.getSession();
			sess.setAttribute("login", "Y");
			
			response.sendRedirect("main");
			
		}else {
			response.sendRedirect("login.html");
		}
		
	}

}
