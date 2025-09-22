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
	
}
