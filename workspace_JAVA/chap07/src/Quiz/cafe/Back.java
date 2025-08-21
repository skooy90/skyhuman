package Quiz.cafe;

import java.util.HashMap;

public class Back extends Cafe{

	
	HashMap<String, Integer> menu = new HashMap<>();
	
	Back(){
		
	menu.put("아아",2000);
	menu.put("뜨아",1500);
	menu.put("라떼",3000);
	menu.put("티",3000);
	menu.put("디져트",5000);
	}
	int total;
	@Override
	int jumun(String key, int n) {
		int sel = menu.get(key); 
		int ea = n;
		total = sel*n;
		System.out.println(key+""+n+"개 주문하셨습니다");
		System.out.println("총합은 :" + total+ "원 입니다.");
		return total;
	}
	@Override
	void sel( int mo) {
		System.out.println("총금액: " + this.total + "내신돈 :" + mo + "거스르돈 : " + -( this.total- mo));;
		
	}
	
	void seemenu(){
		System.out.println("메뉴판 보기");
		for (String key : menu.keySet()) {
			System.out.println("메뉴 : "+ key +" : " + menu.get(key));
		}
	}
	
	
	
}
