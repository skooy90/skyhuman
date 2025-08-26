package emp.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.DTO2.EmpDTO;
import emp.service.EmpService;

@WebServlet("/add")
public class EmpAddController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			int result = empService.addEmp(dto);
			System.out.println("삽입 결과 :" + result);
			
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
