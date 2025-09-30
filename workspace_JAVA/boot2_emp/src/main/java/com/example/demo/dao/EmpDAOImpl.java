package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.EmpDTO;

@Repository
public class EmpDAOImpl implements EmpDAO{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<EmpDTO> empList() {
		List<EmpDTO> list = sqlSession.selectList("mapper.emp.selectEmp");
		System.out.println(list);
		return list;
	}
	
	
}
