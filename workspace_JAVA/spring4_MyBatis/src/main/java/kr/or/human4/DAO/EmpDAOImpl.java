package kr.or.human4.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.human4.DTO.EmpDTO;


@Repository
public class EmpDAOImpl implements EmpDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<EmpDTO> selectEmpList(){
		List<EmpDTO> resultList = null;
		resultList = sqlSession.selectList("mapper.emp.selectEmp");
		EmpDTO id = resultList.get(1);
		System.out.println("resultList : " + resultList + "??");
		System.out.println(id);
		return resultList;
	}
	
	@Override
	public EmpDTO selectOneEmp(){
		EmpDTO dto = null;
		dto = sqlSession.selectOne("mapper.emp.selectOneEmp");
		System.out.println("dto : " + dto);
		return dto;
	}

	@Override
	public HashMap selectOneMap(){
		HashMap map = null;
		map = sqlSession.selectOne("mapper.emp.selectOneEmpMap");
		System.out.println("map :" + map);
		return map;
	}
	
	@Override
	public List selectEmpno(int empno){
		return sqlSession.selectList("mapper.emp.selectEmpno",empno);
	
	}
	@Override
	public List selectEname(String ename){
		return sqlSession.selectList("mapper.emp.selectEname",ename);
		
	}
	
	@Override
	public List selectEmpnoEname(EmpDTO dto){
		return sqlSession.selectList("mapper.emp.selectEmpnoEname",dto);
		
	}

	@Override
	public int insertEmp2(EmpDTO dto) {
		return sqlSession.insert("mapper.emp.insertEmp2",dto);
	}

	@Override
	public EmpDTO selecOneEmpno(int empno){
		EmpDTO dto = null;
		dto = sqlSession.selectOne("mapper.emp.selectEmpno",empno);
		return dto;
	
	}

	@Override
	public EmpDTO updateEmp2(EmpDTO dto) {
		return sqlSession.selectOne("mapper.emp.updateEmp2",dto);
	}
	@Override
	public EmpDTO deleteEmp2(int empno) {
		return sqlSession.selectOne("mapper.emp.deleteEmp2",empno);
	}
	
	// java로 구현
	private void testSeq(EmpDTO dto){
		// insert 전에 seq 따오기
		int seq_empno = sqlSession.selectOne("mapper.emp.getSeqEmp2");
		
		// dto에 저장하기
		dto.setEmpno(seq_empno);
		
		// 활용라기 (2군데 이상 동일한 empno 전달 가능)
		sqlSession.insert("mapper.emp.insertEMP2222", dto); //empno 유지
		sqlSession.insert("mapper.emp.insertEMP4444", dto); //empno 유지
	}
//		↑↓ 같은 코드임 seq를 따오는게 위치가 다를 뿐 
	// 실무편 selectKey 사용 
	private void testSeq2(EmpDTO dto){

		// 내부에서 seq를 따서 setEmpno로 dto에 저장함
		sqlSession.selectOne("mapper.emp.insertEmp3",dto);
		// 얕은 복사라서 현재 요 줄의 dto 에도 empno 저장되어 있음
		
		
		
	}
	
	//검색
	@Override
	public List<EmpDTO> selectEmp(EmpDTO empDTO){
		List<EmpDTO> resultList = null;
		resultList = sqlSession.selectList("mapper.emp.dynamic.selectEmp", empDTO);
		return resultList;
	}

	@Override
	public List<EmpDTO> foreach(EmpDTO empDTO) {
		
		List<EmpDTO> resultList = null;
		resultList = sqlSession.selectList("mapper.emp.dynamic.foreach", empDTO);
		return resultList;
	}
	
	
	
	
}
