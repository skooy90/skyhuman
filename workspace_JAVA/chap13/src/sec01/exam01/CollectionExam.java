package sec01.exam01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionExam {

	public static void main(String[] args) {

		
		List list = new ArrayList();
		
		System.out.println(list.isEmpty());
		
		
		// 추가
		list.add(123);
		list.add("글씨");
		
		// 중간 삽입 
		list.add(1, "삽입");
		System.out.println(list);
		
		// 검색
		System.out.println(list.contains(123));
		
		System.out.println( list.get(1) );
		String a = (String)list.get(1);
		String b = list.get(1).toString();
		
		
		//
		
		list.remove(1);
		System.out.println(list);
		
		list.clear();
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		
		list = new ArrayList();

		 System.out.println("-=-=-=-=-=-=-=-===========-=-=-=-=-=-=-=-=-=");
		 Map map = new HashMap();
		 
		 
		 // 추가 
		 map.put("k1", "v1");
		 map.put("list",list);
		 map.put("k1", "v2"); // key가 같은경우 덮어 쓴다 
		 
		 
		 // 가져오기
		String k1 = (String)map.get("k1");
		List list2 = (List)map.get("list");
		
		
		System.out.println(map);

		
		
		System.out.println("-=-=-=-=-=-=-=-===========-=-=-=-=-=-=-=-=-=");
		
		list = new ArrayList();
		
		map = new HashMap();
		map.put("제목", "golden");
		map.put("가수", "헌트릭스");
		list.add(map);
		
		System.out.println(list);
		System.out.println("+++++++++++++++++++++++++++++++++");
		// 얕은 복사로 인해
		map = new HashMap(); // new를 해줘서 다른 힙 영역에 저장을한다
		map.put("제목","나는 반딧불");
		map.put("가수", "황가람");
		
		list.add(map);
		
		System.out.println(list);
		
		// 제네릭 : < String, Integer > <> 다이아몬드 태그 라고도 한다
		// 60 점 짜리 : 추가할 자료형을 제한 한다 
		List<String> list3 = new ArrayList<String>();
		
//		list3.add(123);
		list3.add("qweqwewq");
		String s  = list3.get(0);
		// 100 점 짜리 : 전달인자나 리턴타입의 자료형을 동적으로 변경한다. 
		// 동적으로 리턴 타입을 바꿀 수 있다.
		//
		
		
		// 제너릭에 원시타입은 사용할 수 없고 , wrapper 클래스 사용
		
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("str", 123);
		map2.get("str");
		int c = map2.get("str");
		
	}

}
