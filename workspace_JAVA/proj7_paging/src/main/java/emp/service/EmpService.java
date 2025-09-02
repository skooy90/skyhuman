package emp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import emp.DAO2.EmpDAO;
import emp.DTO2.EmpDTO;

public class EmpService {
	EmpDAO empDAO = new EmpDAO();

	public List getAllEmp(){
		List<EmpDTO> list = empDAO.selectAllEmp();
		return list;
	}
	public List getPageEmp(EmpDTO dto){
		
		int pagePerRows = dto.getPagePerRows();
		int page = dto.getPage();
		
		int start = 0;
		int end = 0;
		
		end = pagePerRows * page; 
		start = end - (pagePerRows - 1);
		
		dto.setStart(start);
		dto.setEnd(end);
		List list = empDAO.selectPageEmp(dto);
		int total = empDAO.selectTotalEmp();
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("map", map);
		
		list = empDAO.selectPageEmp(dto);
		return list;
	}
	public EmpDTO getOneEmp(EmpDTO empDTO) {
		EmpDTO dto = empDAO.selectOneEmp(empDTO);
		return dto;
	}
	public int removeEmp(EmpDTO empDTO) {
		return empDAO.deleteEmp(empDTO);
	}
	public int addEmp(EmpDTO empDTO) {
		return empDAO.insertEmp(empDTO);
	}
	public int editEmp(EmpDTO empDTO) {
		return empDAO.updateEmp(empDTO);
	}
	
}
