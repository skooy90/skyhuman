package sec01.exam01;

public class RefExam01 {

	public static void main(String[] args) {

		int a = 10;
		int b = a;
		System.out.println(a + ", " + b);
		
		b = 12;
		System.out.println(a + ", " + b);

		String c = "송구영";
		// = 을 기준으로 오른쪽이 먼저 실행된다.
		// 즉 글씨를 힙heap영역의 비어있는 번지에 할당(놓기)
		// 스택stack 영역의 변수 c에 방금 그 번지를 저장
		System.out.println("c : " + c);
		
		System.out.println( a == b);
		
		String d = new String("송구영");
		
		System.out.println("c == d " + (c == d));
		System.out.println("c.equals(d) "+(c.equals(d)));
		// String 값 비교는 무조건 equals()를 사용
		
		String e = d;
		System.out.println("e == d " + (e == d));

		String f0 = "송구영";
		String f = "송" + "구영";
		// String은 참조타입이지만 String은 별도 룰이 적용이되어 
		// String은 별도로 생각해야한다.
		System.out.println("c == f " + (c == f));
		System.out.println("f == f0 " + (f == f0));
		
		// 스택과 힙영역을 구분을 잘하면된다. 지금은.....
		
		// 기본 타입에는 null을 넣을 수 없다
		
		// null : 참조하는 주소가 없는 상태
		String g = "휴먼";
		System.out.println("g == null ?" + (g == null));
		System.out.println("g != null ?" + (g != null));
		
		String h = ""; // 저건 null이 아니다
		System.out.println("h : " + (h));
		g = null;
		System.out.println("g == null ?" + (g == null));
		System.out.println("g + \"abc\" : " + (g+"abc"));
		
		System.out.println(h.equals(g));
//		System.out.println(g.equals(h)); 에러 발생 g는 null이라 아무것도 안된다.
		
		
		
	}

}
