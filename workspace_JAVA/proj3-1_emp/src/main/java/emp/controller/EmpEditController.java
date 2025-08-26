package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.DTO2.EmpDTO;
import emp.service.EmpService;

@WebServlet("/edit")
public class EmpEditController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("edit toGet 실행");
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
			 
			
			o.println("<form method='post' action='edit'>");			
			o.println("<table border=1>");
			o.println("<tr><td>empno</td><td><input type='text' name='empno' value='"	+empDTO2.getEmpno()+"'</td><tr>");
			o.println("<tr><td>ename</td><td><input type='text' name='ename' value='"	+empDTO2.getEname()+"'</td><tr>");
			o.println("<tr><td>job</td><td><input type='text' name='job' value='"	+empDTO2.getJob()+"'</td><tr>");
			o.println("<tr><td>mgr</td><td><input type='text' name='mgr' value='"	+empDTO2.getMgr()+"'</td><tr>");
			o.println("<tr><td>hiredate</td><td><input type='date' name='hiredate' value='"+empDTO2.getHiredate()+"'</td><tr>");
			o.println("<tr><td>sal</td><td><input type='text' name='sal' value='"	+empDTO2.getSal()+"'</td><tr>");
			o.println("<tr><td>comm</td><td><input type='text' name='comm' value='"	+empDTO2.getComm()+"'</td><tr>");
			o.println("<tr><td>deptno</td><td><input type='text' name='deptno' value='"+empDTO2.getDeptno()+"'</td><tr>");
			o.println("</table>");
			o.println("	<input type='submit' value='수정완료'>");
			o.println(" <a href='list'><input type='button' value='목록가기'></a>");
			o.println(" <a href='detail?empno="+empDTO2.getEmpno()+"'><input type='button' value='상세정보'></a>");
			o.println("</form>");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("edit toPost 실행");
		EmpDTO dto = new EmpDTO();
		String sEname = request.getParameter("ename");
		String sJob = request.getParameter("job");
		String sMgr = request.getParameter("mgr");
		String sHiredate = request.getParameter("hiredate");
		String sSal = request.getParameter("sal");
		String sComm = request.getParameter("comm");
		String sDeptno = request.getParameter("deptno");
		
		try {
			String sEmpno = request.getParameter("empno");
//			int empno = Integer.parseInt(sEmpno);
			dto.setEmpno((int)getParam(sEmpno));
			dto.setEname(sEname);
			dto.setJob(sJob);
			dto.setMgr((int)getParam(sMgr));
			dto.setHiredate(Date.valueOf(sHiredate));
			dto.setSal((int)getParam(sSal));
			dto.setComm((int)getParam(sComm));
			dto.setDeptno((int)getParam(sDeptno));
			
			EmpService empService = new EmpService();
			int result = empService.editEmp(dto);
			System.out.println("수정 결과 :" + result);
			
			response.sendRedirect("list");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 파라메터 String 값을 줌
	// 만약에
	// 		원래 String인 값이라면 String을 돌려줌
	//		원래 int인 	값이라면 int를 돌려줌
	private Object getParam(String param) {
		// 일단 모든걸 try안에서 int로 변경
		Object o = param;
		try {
		o = Integer.parseInt(param);	
		} catch (Exception e) {
			
		}
		
		return o;
	}
	
	
	
}
