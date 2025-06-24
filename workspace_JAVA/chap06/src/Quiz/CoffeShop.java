package Quiz;

import java.util.Scanner;

public class CoffeShop {

	Scanner sc = new Scanner(System.in);

	int sal;
	int aa = 0;
	int ta = 0;
	int ht = 0;
	int nt = 0;

	void coffe() {
		System.out.println("커피 메뉴");
		System.out.print("1. 아아 5000원, 2. 뜨아 5000원: ");
		int x = sc.nextInt();
		switch (x) {
		case 1: {
			System.out.println("아아 드리겠습니다");
			aa++;
			break;
			}
		case 2: {
			System.out.println("뜨아 드리겠습니다");
			ta++;
			break;
			}
		default: {
			System.out.println(" 아직 메뉴가 안만들어 졌어요 ");
			break;
			}
		}
	}
	void tea() {
		System.out.println("차 메뉴");
		System.out.print("1.홍차, 2. 녹차 : ");
		int x = sc.nextInt();
		switch (x) {
		case 1: {
			System.out.println("홍차 5000원 드리겠습니다");
			ht++;
			break;
			}
		case 2: {
			System.out.println("녹차 5000원 드리겠습니다");
			nt++;
			break;
			}
		default: {
			System.out.println(" 아직 메뉴가 안만들어 졌어요 ");
			break;
			}
		}
	}
	
	
	int sal() {
		int sum = aa + ta + ht + nt;
		return (sum * 5000);
	}

}
