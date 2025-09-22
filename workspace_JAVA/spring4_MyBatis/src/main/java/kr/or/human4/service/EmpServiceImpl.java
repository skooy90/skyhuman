package kr.or.human4.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.human4.DAO.EmpDAO;
import kr.or.human4.DTO.EmpDTO;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpDAO empDAO;
	
	@Override
	public List<EmpDTO> getEmpList(){
			
		List<EmpDTO> result = empDAO.selectEmpList();
		
		return result; 
	}
	
	@Override
	public EmpDTO getEmp(){
		
		EmpDTO result = empDAO.selectOneEmp();
		
		return result; 
	}
	
	@Override
	public HashMap selectOneMap(){
		
		HashMap result = empDAO.selectOneMap();
		
		return result; 
	}
	
	@Override
	public List getEmpno(int empno) {
		return empDAO.selectEmpno(empno);
	}
	
	@Override
	public List getEname(String Ename) {
		return empDAO.selectEname(Ename);
	}
	
}
