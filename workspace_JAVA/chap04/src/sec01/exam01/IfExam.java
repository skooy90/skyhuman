package sec01.exam01;

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
		if(score >= 90) {

			System.out.println("A등급");
		
		} else if(score >= 80) {

			System.out.println("B등급");
		
		} else if (score >= 70) {

			System.out.println("C등급");
		
		} else {
			
			System.out.println("D등급");
		}
		
		
		score = 97;
		if(score >= 95 ) {
			System.out.println("95점 이상");
		} else if (score >= 90) {
			System.out.println("90점 이상");			
		}
		// => 둘다 출력하고 싶으면		
		
		if(score >=95) {
			System.out.println("95점 이상");			
			if(score >= 90 ) {
				System.out.println("90점 이상");
			} 
		}
		
		if (score >= 90) {
			System.out.println("90점 이상");			
		}
//		위의 if와 관계 없이 무조건 판단한다.		
		if(score >= 95 ) {
			System.out.println("95점 이상");
		} 
		
		
		
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
		
		
		
		
		
	}

}
