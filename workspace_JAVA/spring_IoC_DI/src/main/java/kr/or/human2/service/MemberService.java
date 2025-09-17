package kr.or.human2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.or.human2.DAO.MemberDAO;

@Service
public class MemberService {
	

	//1.전달 받아서 의존성을 낮춘 상태 
//	public List getList() {
//		
//	MemberDAO memberDAO = new MemberDAOImp1();
//	return memberDAO.select();
//	}
	
	// 자동엮어준다.
	// 빈(커피콩)에서 new되거나 자동 현변환이 되는 애들을 찾아줌.
	// new 까지 해준다.
	@Qualifier("dao1") // 1. 직접 지정
	@Autowired // 2. 프라이머리 기준
	MemberDAO memberDAO; // 3. 변수명과 일치한거 지정
	
//	public void setMemberDAO(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}
//	
//	public MemberService(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}
	
	public List getList() {
		
	return this.memberDAO.select();
	
	}
	
}
