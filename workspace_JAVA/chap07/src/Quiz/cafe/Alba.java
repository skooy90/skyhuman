package Quiz.cafe;

public class Alba {
	Cafe cafeName;

	Alba() {

	}

	Alba(Cafe cafe) {
		cafeName = cafe;
		System.out.println(" 스벅 알바 고용 ");
	}

	void coffee(Cafe cafe, String menu, int n, int mo) {
		System.out.println("알바 한방 주문");
		cafe.jumun(menu, n);
		cafe.sel(mo);
	}

	void coffee(String menu, int n, int mo) {
		if (cafeName instanceof Sbuk) {
			System.out.println("스벅 알바 주문");
			cafeName.jumun(menu, n);
			cafeName.sel(mo);
			((Sbuk) cafeName).coupon();
		} else {
			System.out.println("알바 고용 안됨");
		}
	}

}
