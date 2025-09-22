package kr.or.human4.service;

import java.util.HashMap;
import java.util.List;

import kr.or.human4.DTO.EmpDTO;

public interface EmpService {

	public List<EmpDTO> getEmpList();

	EmpDTO getEmp();

	HashMap selectOneMap();
	List getEmpno(int empno);

	List getEname(String Ename);
	
}
