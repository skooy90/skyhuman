package sec01.exam01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc/input")
public class InputSevlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("suuuuuuuuuuuuuu!!! /calc/input ");
		
		request.getRequestDispatcher("/WEB-INF/view/calc/input.jsp").forward(request, response);
		
		
		
		
	
	}


}
