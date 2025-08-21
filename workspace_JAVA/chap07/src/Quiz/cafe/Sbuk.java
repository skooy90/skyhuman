package Quiz.cafe;

import java.util.HashMap;

public class Sbuk extends Cafe {

	HashMap<String, Integer> menu = new HashMap<>();
	Sbuk(){
		
	menu.put("아아",5000);
	menu.put("뜨아",4500);
	menu.put("라떼",5500);
	menu.put("티",6000);
	menu.put("디져트",7000);
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
	void coupon() {
		System.out.println("쿠폰 적립");
	}
	
	
	
}
