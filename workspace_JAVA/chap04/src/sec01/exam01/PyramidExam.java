package sec01.exam01;

import java.util.Scanner;

public class PyramidExam {
	public static void main(String[] args) {

///////////////////////////////////////
//문제 10 피라미드

// 0 단계
//+
//+
//+
//+
//+
		String mark = "+";
		for (int s = 0; s < 5; s++) {
			System.out.println(mark);
		}
// 1단계
		for (int s = 0; s < 5; s++) {
			System.out.print(mark);
		}
		System.out.println("");
// 2단계 mark 
		String space = ".";
		for (int s = 0; s < 5; s++) {
			System.out.print(mark + space);
		}
		System.out.println("");
		/*
		 * /3단계 +++++ +++++ +++++
		 */
		for (int s1 = 0; s1 < 3; s1++) {

			for (int s = 0; s < 5; s++) {
				System.out.print(mark);
			}
			System.out.println("");
		}
// 3.5단계
		/*
		 * 111111 222222 333333 444444 555555
		 */
		for (int s = 1; s <= 5; s++) {

			for (int j = 1; j <= 5; j++) {
				System.out.print(s);
			}
			System.out.println("");
		}

// 4단계
		/*
		 * 1 22 333 4444 55555 한번일때 한번 두번일때 2번
		 * 
		 * 
		 */

		for (int s = 1; s <= 5; s++) {
			for (int j = 1; j <= s; j++) {
				System.out.print(s);
			}
			System.out.println("");
		}

		for (int s = 1; s <= 5; s++) {
			for (int j = 1; j <= s; j++) {
				System.out.print(mark);
			}
			System.out.println("");
		}

		/*
		 * 7단계 11111 2222 333 44 5
		 * 
		 */
		System.out.println("-------------------------------");
		for (int s = 1; s <= 5; s++) {
			for (int j = 5; j >= s; j--) {
				System.out.print(s);
			}
			System.out.println("");
		}

// 8단계
//+....
//++...
//+++..
//++++.
//+++++

		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.printf(mark);
			}
			for (int j = 5; j > i; j--) {
				System.out.printf(space);
			}
			System.out.println("");
		}
		System.out.println("======================");
//// 9단계
//....+
//...++
//..+++
//.++++
//+++++
//
		for (int i = 1; i <= 5; i++) {
			for (int j = 5; j > i; j--) {
				System.out.printf(space);
			}
			for (int j = 0; j < i; j++) {
				System.out.printf(mark);
			}
			System.out.println("");
		}
		System.out.println("10.======================");
//// 10단계
//....+
//...+++
//..+++++
//.+++++++
//+++++++++
//
		int i = 0;
		int j = 0;
		for (i = 1; i <= 5; i++) {
			for (j = 5; j > i; j--) {
				System.out.printf(space);
			}
			for (j = 0; j < i; j++) {
				System.out.printf(mark);
			}
			for (i = 1; j > i; i++) {
				System.out.printf(mark);
			}
			System.out.println("");
		}
		System.out.println("======================");
//// 11단계
//....+....
//...+++...
//..+++++..
//.+++++++.
//+++++++++
//
		System.out.println("11.======================");
		for (i = 1; i <= 5; i++) {
			for (j = 5; j > i; j--) {
				System.out.printf(space);
			}
			for (j = 0; j < i; j++) {
				System.out.printf(mark);
			}
			for (i = 1; j > i; i++) {
				System.out.printf(mark);
			}
			for (j = 5; j > i; j--) {
				System.out.printf(space);
			}
			System.out.println("");
		}
		System.out.println("======================");
//// 12단계
//// 입력 받은 줄 수대로 출력
//// 예를 들어 3이면
//..+..
//.+++.
//+++++
		System.out.println("12.======================");
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 숫자 입력 : ");
		int num = sc.nextInt();
		for (i = 1; i <= num; i++) {
			for (j = num; j > i; j--) {
				System.out.printf(space);
			}
			for (j = 0; j < i; j++) {
				System.out.printf(mark);
			}
			for (i = 1; j > i; i++) {
				System.out.printf(mark);
			}
			for (j = num; j > i; j--) {
				System.out.printf(space);
			}
			System.out.println("");
		}
		System.out.println("======================");

	}
}
