package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.DTO2.EmpDTO;
import emp.service.EmpService;

@WebServlet("/detail")
public class EmpDetailController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		System.out.println("/detail doGet 실행 :하면 상세 정보");
		int empno = 0;

		// 파라메터 empno를 int로 형변환
		try {
			String strEmpno = request.getParameter("empno");
			if (strEmpno != null) {
				empno = Integer.parseInt(strEmpno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		EmpDTO empDTO = new EmpDTO();
		empDTO.setEmpno(empno);

		// DB 다녀와서 출력하기
		try {
			EmpService empService = new EmpService();
			EmpDTO empDTO2 = empService.getOneEmp(empDTO);
			
			PrintWriter o = response.getWriter();
			 
			o.println("<table border=1>");
			o.println("<tr><td>empno</td><td>"	+empDTO2.getEmpno()+"</td><tr>");
			o.println("<tr><td>ename</td><td>"	+empDTO2.getEname()+"</td><tr>");
			o.println("<tr><td>job</td><td>"	+empDTO2.getJob()+"</td><tr>");
			o.println("<tr><td>mgr</td><td>"	+empDTO2.getMgr()+"</td><tr>");
			o.println("<tr><td>hiredate</td><td>"+empDTO2.getHiredate()+"</td><tr>");
			o.println("<tr><td>sal</td><td>"	+empDTO2.getSal()+"</td><tr>");
			o.println("<tr><td>comm</td><td>"	+empDTO2.getComm()+"</td><tr>");
			o.println("<tr><td>deptno</td><td>"+empDTO2.getDeptno()+"</td><tr>");
			
			o.println("</table>");
			
			o.println("<form method='post' action='remove'>");			
			o.println("	<input type='hidden' name='empno' value='"+ empDTO2.getEmpno() +"'> ");
			o.println("	<input type='submit' value='삭제'>");
			o.println("</form>");
			o.println("<form method='get' action='edit'>");			
			o.println("	<input type='hidden' name='empno' value='"+ empDTO2.getEmpno() +"'> ");
			o.println("	<input type='submit' value='수정'>");
			o.println(" <a href='list'><input type='button' value='목록으로'></a>");
			o.println("</form>");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
