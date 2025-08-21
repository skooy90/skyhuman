package Quiz.cafe;

import java.util.HashMap;

public class Cafe {
	
	// 필드
	// 가격s + 메뉴s
	
	HashMap<String, Integer> menu = new HashMap<>();
	int total;
	

	
	// 비품s
	String bee;
	int beeCount;
	// 건물 = null
	// 
	// 생성자
	// 건물 , 직원, 
	// 
	// 메소드
	// 주문받기(메뉴 , 갯수)
	int jumun(String key , int n) {
		System.out.println(key+ " " + n + "개 주문");
		return n;
	}
	//  결제하기 ( 지불한 금액)
	void sel( int n) {
		System.out.println(this.total+ " " + n +"개 얼마 :");
	}
	// 리턴 잘된건지 잘못된지 . 커피 커피만들기(메뉴)
	void made(String key) {
		System.out.println(key + "만들기");
	}
	// 메뉴판 보기 
	void seemenu(){
		System.out.println("메뉴판 보기");
		for (String key : menu.keySet()) {
			System.out.println("메뉴"+ key + "가격 :" + menu.get(key));
		}
	}
	// 서빙, 설거지, 일마감
	void subing() {
		System.out.println("서빙하기");
	}
	void clean() {
		System.out.println("설거지하기");
	}
	void close() {
		System.out.println("마감하기~~");
	}
	// 부모 클래스 : cafe
	// 자식 클래스 : 각종 커피숍
	// 활용 클래스 : Alba
		// - 전달인자로 자식 클래스 받아서 활용
	// main 클래스 : 자식 생성, 활용 클래스에 전달해서 사용
	
}
