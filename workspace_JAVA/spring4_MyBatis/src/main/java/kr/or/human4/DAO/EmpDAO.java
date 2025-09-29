package kr.or.human4.DAO;

import java.util.HashMap;
import java.util.List;

import kr.or.human4.DTO.EmpDTO;

public interface EmpDAO {
	
	List<EmpDTO> selectEmpList();

	EmpDTO selectOneEmp();

	HashMap selectOneMap();
	
	List selectEmpno(int empno);

	List selectEname(String ename);
	
	List selectEmpnoEname(EmpDTO dto);
	
	int insertEmp2(EmpDTO dto);
	
	EmpDTO selecOneEmpno(int empno);
	
	EmpDTO updateEmp2(EmpDTO dto);

	List<EmpDTO> selectEmp(EmpDTO empDTO);

	EmpDTO deleteEmp2(int empno);
	List<EmpDTO> foreach(EmpDTO empDTO);
}
