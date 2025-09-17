package emp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.DTO.EmpDTO;
import emp.service.EmpService;

@WebServlet("/remove")
public class EmpRemoveController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. 언제 : 디테일에서 삭제 버튼 누르면 동작 post로 받으면
		// 1. empno 확보
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
		// 2. DTO에 담아주기
		EmpDTO empDTO = new EmpDTO();
		empDTO.setEmpno(empno);

		// 3. DB에 다녀오기
		EmpService empService = new EmpService();
		int result =empService.removeEmp(empDTO);
		System.out.println(result + " 만큼 삭제 됐습니다.");
		
		// 4. 전체목록페이지 표시		
		
		response.sendRedirect("list");
		
		//  1. 기능 : empno받아 실행되는곳에 전달인자 넣어 sql 문 실행
		// 	1-1 파라미터로 empno 확보
		// 	1-2 DTO에 empno를 이용한 메소드 
		//  1-3 메소드를 이용한 DB이동  
		//  2. 전체 목록 페이지로 가기
		
		
	}

}
