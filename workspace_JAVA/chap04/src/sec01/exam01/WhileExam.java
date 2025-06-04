package sec01.exam01;

import java.util.Scanner;

public class WhileExam {

	public static void main(String[] args) {

		int i = 1;
		while (i <= 10) {
			System.out.println(i);
			i++;
		}

		/*
		 * 메뉴를 고르시오 1: 커피, 2: 차, 0: 종료
		 */
		Scanner sc = new Scanner(System.in);

//		System.out.println("메뉴를 고르세요");
//		System.out.println("1: 커피, 2:차, 0: 종료");
//		while(true) {
//			System.out.print("메뉴 : ");
//			int menu = sc.nextInt();
//		
//			if(menu == 1) {
//				System.out.println("커피 드릴께여");
//			}else if (menu == 2) {
//				System.out.println("차드릴게여");
//			}else if (menu == 0) {
//				System.out.println("주문을 종료 합니다.");
//				break;
//			}else {
//				System.out.println("주문판을 보세여");
//			}
//			
//		}
		int menu = -1;
//		for( ; menu !=0; ) {
		while (menu != 0) {

			System.out.println("메뉴를 고르세요");
			System.out.println("1: 커피, 2:차, 0: 종료");

			System.out.print("메뉴 : ");
			menu = sc.nextInt();

			if (menu == 1) {
				System.out.println("커피 드릴께여");
			} else if (menu == 2) {
				System.out.println("차드릴게여");
			} else if (menu == 0) {
				System.out.println("주문을 종료 합니다.");
			} else {
				System.out.println("주문판을 보세여");
			}
		}

	}
}
