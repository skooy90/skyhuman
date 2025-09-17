package kr.or.human2.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

// db에 갓다오는 예외처리 잡아줌
@Repository("dao1")
public class MemberDAOImpl implements MemberDAO {

	@Override
	public List select() {
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		return list;
	}
	
	
}
