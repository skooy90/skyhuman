package Quiz;

import java.util.Scanner;

public class CoffeShopExam {
	public static void main(String[] args) {
		CoffeShop cs = new CoffeShop();
		Scanner sc = new Scanner(System.in);
		int menu = -1;
		while (menu != 0) {
			System.out.println("메뉴를 고르세요");
			System.out.println("1: 커피, 2:차, 3:결제하기 0: 종료");
			System.out.print("메뉴 : ");
			menu = sc.nextInt();
			if (menu == 1) {
				cs.coffe();
				System.out.println("커피 드릴께여");
			} else if (menu == 2) {
				cs.tea();
				System.out.println("차드릴게여");
			} else if (menu == 3) {
				System.out.println("결제 해드릴게요~");
				int sal = cs.sal();
				System.out.println("총액 : " + sal + "원 입니다.");
			} else if (menu == 0) {
				System.out.println("주문을 종료 합니다.");
			} else {
				System.out.println("주문판을 보세여");
			}
		}

	}
}