package Quiz;

public class Fruitstore {

	String storeName;

	Fruit f1 = new Fruit("사과", 3000, 6);
	Fruit f2 = new Fruit("배", 4000, 2);
	Fruit f3 = new Fruit("앵두", 2000, 6);
	Fruit f4 = new Fruit("자두", 5000, 4);
	Fruit f5 = new Fruit("멜론", 10000, 5);

	Fruit[] fruit = { f1, f2, f3, f4, f5 };

	Fruitstore(String store) {
		storeName = store;
	}

	void allQu() {
		System.out.println("과일 종류 갯수 : " + fruit.length + "개");
		for (int i = 0; i < fruit.length; i++) {
			System.out.println(fruit[i].name + "의 현재 갯수 : " + fruit[i].ea + "개");

		}
	}

	void salQu(String x) {
		for (int i = 0; i < fruit.length; i++) {
			if (fruit[i].name.equals(x)) {
				System.out.println(fruit[i].name + "의 개당 금액은 : " + fruit[i].sal);
			}
		}
	}

	int exsalQu(String x, int y) {
		int sal = 0;
		for (int i = 0; i < fruit.length; i++) {
			if (fruit[i].name.equals(x)) {
				sal = fruit[i].sal * y;
			}
		}

		return sal;
	}

	int chageSal(String x, int y, int z) {
		int chageSal = 0;
		for (int i = 0; i < fruit.length; i++) {
			if (fruit[i].name.equals(x)) {
				if (fruit[i].ea > y) {
					int sal = fruit[i].sal * y;
					chageSal = (z - sal);
						if(chageSal < 0) {
							System.out.println("금액이 부족합니다.");
						}
				} else {
					System.out.println("남은 재고 보다 더 많은 수량을 주문했슴");
				}
			}
		}

		return chageSal;
	}
	
	String parcel(String x, String y, int z) {
		boolean a = false;
		int num =(int) (Math.random()*10) +1;
		System.out.println(num);
		if(num > 4) {
			a = true;
		}
		String s;
		
		if( a == true) {
			s = "배송 성공";
		}else {
			s = "배송 실패";
		}
		
		return s; 
	}

/////////////////////////
}
