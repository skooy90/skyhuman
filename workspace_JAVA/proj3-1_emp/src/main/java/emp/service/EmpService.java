package emp.service;

import java.util.List;

import emp.DAO.EmpDAO;
import emp.DTO.EmpDTO;

public class EmpService {
	EmpDAO empDAO = new EmpDAO();

	public List getAllEmp(){
		List<EmpDTO> list = empDAO.selectAllEmp();
		return list;
	}
	public EmpDTO getOneEmp(EmpDTO empDTO) {
		EmpDTO dto = empDAO.selectOneEmp(empDTO);
		return dto;
	}
	public int removeEmp(EmpDTO empDTO) {
		return empDAO.deleteEmp(empDTO);
	}
	
}
