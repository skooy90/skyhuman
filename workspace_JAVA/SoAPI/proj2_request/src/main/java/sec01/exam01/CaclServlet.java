package sec01.exam01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CaclServlet")
public class CaclServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("CaclServlet의 doGet 실행");
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");

		try {
			
			int n1 = Integer.parseInt(num1);
			int n2 = Integer.parseInt(num2);
			int n3 = n1 + n2;
			
			PrintWriter out = response.getWriter();
			out.println("<h1>NUM1 " + n1 +"</h1>");
			out.println("<h1>NUM2 " + n2 +"</h1>");
			out.println("<h1>SUM " + n3 +"</h1>");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
