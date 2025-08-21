package sec01.exam01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cs")
public class calcServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
		int sum = n1 + n2;
		System.out.println(sum);
	
		PrintWriter out = response.getWriter();
    	out.println("<h1>");
    	out.println("NUM1 : "+num1 + "<br>");
    	out.println("NUM2 : "+num2 + "<br>");
    	out.println("SUM : "+sum + " <br>");
    	out.println("</h1>");
	
	
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
