package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.DTO2.EmpDTO;
import emp.service.EmpService;

@WebServlet("/list")
public class EmpListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("list toGet 실행");
		
		// BD 조회
		EmpService empService = new EmpService();
		List<EmpDTO> list = empService.getAllEmp();
		
		//===============================
		// 화면에 출력 ( 응답 정적 자원 만들기 )
		PrintWriter o = response.getWriter();
		
		o.println("<table border = 1>");
		o.println("<tr>");
		o.println("		<th>empno</th>");
		o.println("		<th>ename</th>");
		o.println("		<th>sal</th>");
		o.println("</tr>");
		
		
		for(EmpDTO d : list ) {
			System.out.println(d);
			o.println("<tr>");
			o.println("		<td>" + d.getEmpno() + "</td>");
			o.println("		<td><a href='detail?empno="+ d.getEmpno() +"'>" + d.getEname() + "</a></td>");
			o.println("		<td>" + d.getSal() + "</td>");			
			o.println("</tr>");

		// 스미스씨의 정보만 다 가져오는 디테일 콘트롤러 만들기
		// 
		}
		
		o.println("</table>");
	}
	

}
