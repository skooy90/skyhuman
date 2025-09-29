package kr.or.human4.DAO.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.or.human4.DTO.EmpDTO;

@Mapper
public interface EmpMapperDAO {
	
	List<EmpDTO> selectEmp();
	
	@Select("select * from emp where empno= #{empno}")
	EmpDTO detail(@Param("empno") int empno);
	
}
