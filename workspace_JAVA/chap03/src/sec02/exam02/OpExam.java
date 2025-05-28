package sec02.exam02;

public class OpExam {

	public static void main(String[] args) {

		int x = 10;
		
		x++;
		System.out.println(x);
		++x;
		System.out.println(x);
		x = 10;
		x = x + 1; // x= 11
		x += 1; // x = 12 
		x++; // 위와 같은 코드 이면서
			 // 단, 1을 증가할때만 가능
		
		int y = 10;
		y--; // 9
		--y; // 8
		System.out.println("y : " + y);
		
		x=10;
		int z = ++x;
		System.out.println("z : " + z);
		x=10;
		z = x++;
		System.out.println("z : " + z);
		System.out.println("x : " + x);
		
		x=10;
		System.out.println("++x : " + ++x);
		x=10;
		System.out.println("x++ : " + x++);
	
		x = 1;
		z = x++ + ++x;
		System.out.println("z : " + z);
		System.out.println("x : " + x);
		
		
		x = 1;
		z = x++ - --x * x++ - x--;
//			1		1	1       2 -> 1
		System.out.println("z : " + z);
		System.out.println("x : " + x);
		
		boolean a = false;
		a = !a;
		System.out.println("a : " + a);
		
		int b = 10;
//		int c = b / 0;
		double d = 7.3;
		double e = d / 0;
		System.out.println(e);
//		나누기 할 때 0으로 나누지 않기로 조심할 것

			
		System.out.println(0.1 == 0.1f);
		System.out.println(0.1 == 0.1);
//	소수점을 비교할 때는 같은 타입으로 변환해서 비교하자.
		
		
		
		String s1 = "s1";
		String s2 = "s"+1;
		System.out.println(s1.equals(s2));
//		글씨는 무조건 equals로 비교한다.
		System.out.println("s2".equals(s2));
		System.out.println(!"ssss".equals(s2));
		
		
				
		// 퀴즈 
		// 난 돈이 10000원 있다
		// 1. 4500원짜리 프라프치노를 최대 몇 잔 살 수 있나여?
		// 2. 그리고 남은 돈
		int mon = 10000;
		int pra = 4500;
		
		int count = mon / pra;
		int nmon = mon % pra;
		
		System.out.println("내가 살 수 있는 최대잔: " + count);
		System.out.println("남은돈 : " + nmon);
		
		
		// 올리브영 꿀홍차가 8000
		// 15% 세일중이면
		int hon = 8000;
		double mo = hon * 0.85;
		System.out.println(mo);
		
		
		
		int score = 87;
		System.out.println(" 내 점수는 80과 90사이다 참? 거짓?");
		// true / false 출력
		
		System.out.println(  80 < score && score < 90 );
		
		// 어떤 숫자를 1-의 자리 이하 버림 
		int k = 1937;
		
		// v1 / v2를 소수점 3자리까지 출력하시오
		double v1 = 1000.0;
		double v2 = 794;
		double v3 = v1 / v2;
		double v4 = (int)(v3 * 1000);
		System.out.println(v4);
		v3 = v4 / 1000;
		System.out.println(v3);
//		System.out.printf("%.3f" , v3);
		
		
	}

}
