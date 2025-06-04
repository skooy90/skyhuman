package sec01.exam01;

import java.util.Scanner;

public class IfExam {

	public static void main(String[] args) {
		
		
		
		int score = 93;

		// 생 if문
//		if(score>=90) {
//			System.out.println("점수가 90 이상이다");
//			System.out.println("A등급");
//		} 
//		
//		if(score<90) {
//			System.out.println("점수가 90 미만이다");
//			System.out.println("B등급");
//			
//		}
		
//		if- else 문
//		if(score >= 90) {
//		
//			System.out.println("점수가 90 이상이다");
//			System.out.println("A등급");
//		
//		}else {
//			
//			System.out.println("점수가 90 미만이다");
//			System.out.println("B등급");
//		}
		// else가 있다는 건 무조건 하나의 실행 블럭이 실행된다.
		
		// if - else if - else 문
		score = 68;
		if(score >= 90) {

			System.out.println("A등급");
		
		} else if(score >= 80) {

			System.out.println("B등급");
		
		} else if (score >= 70) {

			System.out.println("C등급");
		
		} else {
			
			System.out.println("D등급");
		}
		
		if(score >= 95 ) {
			System.out.println("95점 이상");
		} else if (score >= 90) {
			System.out.println("90점 이상");			
		}
		// => 둘다 출력하고 싶으면		
		//2
		if(score >=95) {
			System.out.println("95점 이상");			
			if(score >= 90 ) {
				System.out.println("90점 이상");
			} 
		}
		/////////////////////////
		//1
		if(score >= 95 ) {
			System.out.println("95점 이상");
		} 
		if (score >= 90) {
			System.out.println("90점 이상");			
		}
//		위의 if와 관계 없이 무조건 판단한다.		
		/////////////////////////
		
		
		int x = 3;
		
		if(x % 2 == 0){
		System.out.println("짝수");
		} else {
//		else if ( x%2 != 0)
//		else if ( x%2 == 1)
			System.out.println("홀수");
		}
		////////////////////////////////
		// random
		double random1 = Math.random();
		System.out.println(random1);
		
		// Math.random은 무조건 0이 나올 수 있다.
		// 0 <= Math.random() < 1
		// 주사위 : 1 ~ 6 까지
		// 대충 나머지로 구하는법
		int num =  (int)(Math.random() * 10000)%6 + 1 ;
		System.out.println(num);
		
		// 0 <= Math.random() < 1
		
		
		// 로또 번호 : 1~45 >> 0~44 + 1
		
		int lotto = (int) (Math.random() * 45 ) + 1;
		System.out.println("로또번호 : " + lotto );
		
		
		int num2 = 1;
		if (num2 == 1 ) {
			System.out.println("num은 1입니다.");
		} else if (num2 == 2) {
			System.out.println("num은 2입니다.");
			
		} else {
			System.out.println("1과2 이 아닌 다른 값입니다.");
		}
		// char, byte, short, int, String만 사용 가능하다.
		// boolean, long ,loat,double 못함
		
		switch (num2) {
			case 1:			
				System.out.println("switch num은 1입니다.");
//				break;
			case 2:			
				System.out.println("switch num은 2입니다.");
				break;

			default:
				System.out.println("1과2 이 아닌 다른 값입니다.");			
				break;
			}
		// 봄 3 ~ 5, 여름 6 ~ 8, 가을 9 ~ 11 겨울은 12 ~ 1 
	
		int month = 10;
		
		if (month >= 3 && month <= 5) {
			System.out.println("봄입니다");
		}else if (month >= 6 && month <= 8) {
			System.out.println("여름입니다");
		}else if (month >= 9 && month <= 11) {
			System.out.println("가을입니다");
		}else if (month == 12 || month == 2  || month == 1) {
			System.out.println("겨울입니다");	
		}
		else {
			System.out.println("없는 달입니다.");
		}
		
		month = 3;
		switch (month) {
		case 3:
		case 4:
		case 5:
			System.out.println("봄입니다.");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("여름입니다.");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("가을입니다.");
			break;
		case 12:
		case 1:
		case 2:
			System.out.println("겨울입니다.");
			break;
		default:
			System.out.println("없는 달입니다.");
			break;
		}
		
		
		int i = 10;
		if(i > 5) System.out.println("5보다 크다");
		

		
		for(int dan = 2; dan <=9; dan++) {
			System.out.println(dan + "단");
			for(int j = 1; j <=9; j++) {
				System.out.println(dan +" * "+ j +" = " + (dan*j));
				
			}
			System.out.println("==============================");
		}
		
		Scanner sc = new Scanner(System.in);
		
//		문제 1
//		int 변서에 임의의 수를 넣고
//		그 수가 "양수", "0", "음수" 구분하여 출력
		
		
	/**
	 * 문제 2
	 * a 와 b 두수 중에서 큰 값을 출력
	 * 	
	 * 
	 * 
	 * 문제 3 
	 * 시 와 분이 있을 때 
	 * 35분이 지난 시간을 출력
	 * 
	 * 문제 4
	 * 어떤 수가 15와 20 (포함)  사이에 있는가?
	 * 
	 * 문제 5
	 * 통장 잔액이 10000원 있을 때 
	 * 출금액에 따라
	 * "잔액이 부족합니다", "얼마 출금 했고 얼마 남았습니다.
	 * "정확히 입력 해주세요"
	 * 
	 * 
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
	 *  
	 * 
	 * 
	 * 
	 */

	}

}
