package sec01.exam01;

import java.util.Scanner;

public class IfExam02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		문제 1
//		int 변서에 임의의 수를 넣고
//		그 수가 "양수", "0", "음수" 구분하여 출력
		System.out.printf("임의의 수를 넣으시오: ");
		int q1 = sc.nextInt();
//		int x1 = 75;
		if (q1 > 0) {
			System.out.println("임의수 : " + q1 + "는 양수입니다.");
		} else if (q1 < 0) {
			System.out.println("임의수 : " + q1 + "는 음수입니다.");
		} else {
			System.out.println("임의수 : " + q1 + "는 0입니다.");
			
		}
		
		
	/**
	 * 문제 2
	 * a 와 b 두수 중에서 큰 값을 출력
	 */
		System.out.printf( "a값을 입력하세요: ");
		int a = sc.nextInt();
//		int a = 3;
		System.out.printf( "b값을 입력하세요: ");
		int b = sc.nextInt();

		
		
		if ( a > b ) {
			System.out.println("a는 b보다 크다.");
		} else if ( a < b) {
			System.out.println("b는 a보다 크다.");			
		} else {
			System.out.println("b는 a와 같다.");						
		}
		
		
	 /* 	 
	 * 문제 3 
	 * 시 와 분이 있을 때 
	 * 35분이 지난 시간을 출력
	 */
		System.out.printf( "시간을 입력해주세요 :");
		int hour = sc.nextInt();
		System.out.printf( "분을 입력해주세요 :");
		int min = sc.nextInt();
		
		System.out.println( "35분 후");
		min += 35;
		
		if (min >= 60) {
			hour += 1;
			min -= 60;
			System.out.printf("현재 시간은 %d시 %d분 입니다.\n",hour,min );
		} else {
			System.out.printf("현재 시간은 %d시 %d분 입니다.\n",hour,min );			
		}
		
		
	/* 문제 4
		어떤 수가 15와 20 (포함)  사이에 있는가?	
	 */ 
		System.out.printf("임의 수 입력 : ");
		int rana = sc.nextInt();
		System.out.println("임의값 " + rana + "는");
		if (15 <= rana && rana <20) {
			System.out.println("15 와 20 사이에 있어요");
		} else {
			System.out.println("범위 밖에 있는 숫자입니다.");
		}
		
			 
	/* 
	 * 문제 5
	 * 통장 잔액이 10000원 있을 때 
	 * 출금액에 따라
	 * "잔액이 부족합니다", "얼마 출금 했고 얼마 남았습니다.
	 * "정확히 입력 해주세요"
	 */
		int jan = 10000;
		
	 /* 
	 * 문제 6
	 * 입력한 수에 따라  (단, 0은 양수 + 짝수)
	 * "100 보다 큰 수이며, 양수이고, 홀수입니다."
	 * 
	 * 
	 * 문제 7
	 * 어제 온도, 오늘온도 변수 두개
	 * 어제 2도, 오늘 -3 일때.
	 * "오늘 온도는 영하 3도 입니다."
	 * "어제 보다 5도 낮습니다."
	 * 
	 * 
	 * 문제 8
	 * 
	 * 변수에 두자리 숫자(10~99)가 있을 때
	 * 10의 자리와 1의 자리가 같은 수 인지 판단하기. 
	 * 
	 * 
	 * 문제 9
	 * 사각형의 한쪽 x1 : 10, y1:20
	 * 대각선 모서리는 x2: 90 , y2 : 100
	 * 일때, 새로운 점 x3, y3는 사각형에 포함되는가?
	 */
		int x1 = 10;
		int x2 = 90;
		int y1 = 20;
		int y2 = 100;
		System.out.printf("x3의 지점을 넣으세요 : ");
		int x3 = sc.nextInt();
		System.out.printf("y3의 지점을 넣으세요 : ");
		int y3 = sc.nextInt();
		if (x3 >= x1 && x3 <= x2) {
			if (y3 >=y1 && y3 <= y2) {
				System.out.println("사각형 안에 포함이 됩니다");
			}else {				
				System.out.println("사각형 안에 포함이 안됩니다");
			}
		}else {
			System.out.println("사각형 안에 포함이 안됩니다");			
		}
	 /* 
	 * 
	 * 
	 */
	}
}
