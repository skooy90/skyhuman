package sec01.exam01;

import java.util.Scanner;

public class ForExam {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println("100까지 더한 sum : " + sum);

		int sum1 = 0;
		int ban = 10;
		for (int i = 0; i < ban; i++) {
			sum1 += 1;
		}

		System.out.println(sum1);

		// 구구단 2단을 출력하시오

		int dan = 2;
		for (int i = 1; i < 10; i++) {
			int result = dan * i;
			System.out.println(dan + " x " + i + " = " + result);
		}

		// 2~ 10 중 짝수만 출력
		System.out.println(2);
		System.out.println(4);
		System.out.println(6);
		int i1 = 2;
		System.out.println(i1);

		i1 += 2;
		System.out.println(i1);

		i1 += 2;
		System.out.println(i1);

		i1 += 2;
		System.out.println(i1);

		i1 += 2;
		System.out.println(i1);
		System.out.println("--------------------------");
		for (int i2 = 2; i2 <= 10; i2 += 2) {
			System.out.println(i2);
		}

		System.out.println("1번--------------------------");
		// 10 ~ 1 출력
		for (int i4 = 10; i4 > 0; i4--) {
			System.out.println(i4);
		}
		System.out.println("2번--------------------------");

		for (int i5 = 1; i5 <= 10; i5++) {

			if (i5 % 2 == 0) {
				System.out.println(i5 + ": 짝수");
			} else {
				System.out.println(i5 + ": 홀수");
			}
		}
		// 1~10 까지 다음과 같이 출력
		// 1: 홀수
		// 2: 짝수
		// q5 . 1~10까지 출력 3개씩 옆으로 찍시
		// 1 2 3
		// 4 5 6
		// 7 8 9
		// 10

		System.out.println("3번--------------------------");

		for (int i6 = 1; i6 <= 10; i6++) {
			System.out.printf(i6 + " ");
			if (i6 % 3 == 0) {
				System.out.println("");
			}

		}
		System.out.println("");

		System.out.println("4번--------------------------");
		// 1부터 100까지 홀수 의 갯수

		int count = 0;
		for (int i6 = 1; i6 <= 100; i6++) {
			if (i6 % 2 != 0) {
				count++;
			}
		}
		System.out.println("1부터 100까지 홀수 의 갯수: " + count);

		System.out.println("5번--------------------------");

		for (int i9 = 2; i9 < 10; i9++) {
			System.out.println("======" + i9 + "단==========");
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d x %d = %d \n", i9, j, (i9 * j));
			}
		}
		System.out.println("6번--------------------------");
		// 구구단 전체 출력
		System.out.println(count);
		for (int i9 = 2; i9 < 10; i9++) {
			System.out.println("======" + i9 + "단==========");
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d x %d = %d ", i9, j, (i9 * j));
			}
			System.out.println("");
		}

		// 9. 두단씩 옆으로 출력
		//

		for (int k = 2; k < 10; k += 2) {
			for (int j = 1; j < 10; j++) {

				System.out.print(k + " x " + j + " = " + (k * j) + " ");
				if ((k + 1) < 10) {
					System.out.println((k + 1) + " x " + j + " = " + ((k + 1) * j) + " ");
				}
			}
			System.out.println(" ");
		}

		// 별찍기 피라미드 찍기는 별도 파일

		// 문제 1
		// 주사위 2개를 굴려서 나올 수 있는 모드 조합을 출력한다
		// [1,1] [1,2] [2,2] .....[6,6] 출력
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				System.out.printf("[%d,%d]\t", i, j);
			}
			System.out.println();
		}

		System.out.println();
		// 문제 2
		// 주사위 2개의 합 별로로 나올 수 있는 조합
		// 합2 " [1,1]
		// 합3 : [1,2] [2,1]
		int sum2 = 0;
		for (int k = 2; k <= 12; k++) {
			System.out.print("합 " + k + ": ");
			for (int i = 1; i <= 6; i++) {
				for (int j = 1; j <= 6; j++) {
					sum2 = i + j;
					if (sum2 == k) {
						System.out.printf("[%d,%d]\t", i, j);
					}
				}
			}
			System.out.println();
		}

		// 문제 3
		// 합 별 조합의 수

		for (int k = 2; k <= 12; k++) {
			System.out.print("합 " + k + ": ");
			int cnt = 0;
			for (int i = 1; i <= 6; i++) {
				for (int j = 1; j <= 6; j++) {
					sum2 = i + j;
					if (sum2 == k) {
						cnt++;
					}
				}
			}
			System.out.println("총 갯수 : " + cnt);
			System.out.println();
		}

		// 문제 4
		// 순서에 관계 없이 중복 제거
		// [1,2] [2,1] 중복
		sum2 = 0;
		for (int k = 2; k <= 12; k++) {
			System.out.print("합 " + k + ": ");
			for (int i = 1; i <= 6; i++) {
				for (int j = i; j <= 6; j++) {
					sum2 = i + j;
					if (sum2 == k) {
						System.out.printf("[%d,%d]\t", i, j);
					}
				}
			}
			System.out.println();
		}

		// 문제6
		Scanner sc = new Scanner(System.in);
		System.out.print("3 또는 4 입력");
		int scnum = sc.nextInt();

		for (int i2 = 0; i2 < scnum; i2++) {
			for (int j2 = 0; j2 < scnum; j2++) {
				System.out.printf("%d%d\t", i2, j2);
			}
			System.out.println();
		}

		// 3 4
		/*
		 * 00 01 02 00 01 02 03 10 11 12 10 11 12 13 20 21 22 20 21 22 23 30 31 32 33
		 */

		System.out.print("입력받운 정수을 입력하세요 : ");
		int scnum2 = sc.nextInt();
		for (int i = 1; i <= scnum2; i++) {
			System.out.print("*");
			for (int j = i; j >= 2 && j < scnum2; j++) {
				if (i == 2) {
					System.out.print("*");
				}
				System.out.println(".");
				if (i == scnum2) {
					System.out.print("*");
				}
			}
			System.out.println();
			System.out.print("*");
		}

//

		// 문제 5
		// 입력받은 정수에 따라 다음과 같이 출력
		// 3 5
		/*
		 * +++ +.+ +++
		 * 
		 * +++++ +...+ +...+ +...+ +++++
		 */

	}
}
