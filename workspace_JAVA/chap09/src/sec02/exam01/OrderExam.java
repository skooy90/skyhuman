package sec02.exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class OrderExam {

	public static void main(String[] args) {

		
		MemberDTO m1 = new MemberDTO() ;
		MemberDTO m2 = new MemberDTO() ;
		MemberDTO m3 = new MemberDTO() ;
		
		m1.name="이름1";
		m1.age=25;
		
		m2.name="이름2";
		m2.age=32;
		
		m3.name="이름3";
		m3.age=29;
		
		List list = new ArrayList();
		list.add(m1);
		list.add(m2);
		list.add(m3);

		System.out.println(m1.toString());
		
		
		// 클래스로 구현한 경우
		Comparator c1 = new ComparatorImpl();

		// 익명 객체로 구현한 경우
		// 여기서만 사용 할 경우에 익명 객체를 사용한다.
		Comparator c2 = new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				MemberDTO dto1 = (MemberDTO)o1;
				MemberDTO dto2 = (MemberDTO)o2;
				
				int result = dto1.age -dto2.age;
				// 오름차순
				
				return result;
			}
		
	};
	
	// 원본은 수정한다.
		Collections.sort(list, c2);
		
		for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = (MemberDTO)list.get(i);
			System.out.println(dto.age);
		}
	
	}
}
