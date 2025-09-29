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
	
	List getEmpnoEname(EmpDTO dto);

	int joinEmp2(EmpDTO dto);
	
	EmpDTO selecOneEmpno(int empno);
	EmpDTO updateEmp2(EmpDTO dto);

	List selectEmp(EmpDTO dto);

	EmpDTO deleteEmp2(int empno);
	List foreach(EmpDTO dto);
}
