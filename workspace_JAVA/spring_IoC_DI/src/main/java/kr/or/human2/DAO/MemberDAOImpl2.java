package kr.or.human2.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

// db에 갓다오는 예외처리 잡아줌
@Repository("memberDAOImpl2") // 생략하면 기본 클래스명에서 앞글자만 소문자
@Primary
public class MemberDAOImpl2 implements MemberDAO {

	@Override
	public List select() {
		List list = new ArrayList();
		list.add("pk");
		list.add(2);
		list.add(3);
		list.add(4);
		return list;
	}
	
	
}
