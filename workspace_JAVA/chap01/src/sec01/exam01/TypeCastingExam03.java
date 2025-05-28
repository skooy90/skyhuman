package sec01.exam01;

public class TypeCastingExam03 {

	public static void main(String[] args) {
		
		
		
		
		
		// 형변환 연산자
		// type casting operator
		
		int intValue = 10;
		byte byteValue = (byte) intValue;
		
		System.out.println(byteValue);
		intValue = 200;
		byteValue = (byte) intValue;
		
		System.out.println(byteValue);
		// 127을 넘어가니까 예측할 수 없는 값이 나온다.
		/* 이유 : 1byte는 128까지 저장할 수 있으니깐 
		 * -> 비트를 2의 보수로 계산한 결과가 나온다.(어려움 이해안해도됨)
		 */
		
//		double d = 3.14;
		double d = -3.14;
		// 소수점은 버린다.
		int i = (int) d;
		
		System.out.println(i);
		// 결과 3 or -3 으로 나온다
		// 
		
		// 여기서 ( ) 우선 순위 연산자
		int a = 2 * (3 + 4);
		
		
		////////////////////////////////////////////////////
		
		int i2 = 100;
		long l1 = i2;
		// 형변환 ()이 생략이 가능하다.
		// int가 아무리 커도 long범위 안에 들어가기 때문에.
		System.out.println(l1);
		
		
		
		int i3 = 3;
		long l3 = 4L;
		long l4 = i3 + l3;
		
		// -> (long)i3 + l3; long으로 자동 형변환이 된다.
		
		
		int i7 = 10;
		double d7 = 5.5;
		double d8 = i7 + d7; //-> (double) i7 + d7 ()이 생략된거다.
		System.out.println("d8 : " + d8);
		
		
		
//		double d9 = 10/4; // -> (int)10 / (int)4 => (int)2
							// ->  (double)2.0 으로 값이 나옴
		
		double d9 = (double)10/4; 
		// -> int를 강제형변환을 해서 원하는 값이 나오게함
		System.out.println("d9: " + d9);
		
		
		// 졸업까지 사용하는 방식
		// 문자를 숫자로 바꾸는 방법
		String s1 = "123";
//		int i8 = (int)s1; // 불가능 문자를 숫자로 안됨
		int i8 = Integer.parseInt(s1); //pasrseInt()라는 함수다
		// 위 방식으로 하면 문자를 숫자로 바꿀수 있다.
//		String s1 = "123a"; //불가능
		// 단, 문자가 숫자로 구성이 되어 있어야한다.
		System.out.println(s1);
		
		// 숫자를 문자로 바꾸는 방법
		String s2 = ""+i8;
		
		System.out.println(s2);
		
		
		// 퀴즈
		// 회식을 했다. 회식비 43000원
		// 참석인원 4명 
		// 이 때 인당 얼마?
		// 1. 디테일 하게 원단위까지 
		// 2. 참석인원은 망원단위로만 회식비를 낸다 
		// [3]. 2번처럼 받으면 주최자는 얼마를 내야 하나?
		double total = 4.3;
		int count = 4;
		
		double coTo = total / count;  //(double)count 생략
		System.out.println("원단위 인당 비용 : " + (int)(coTo * 10000) + " 원");
		int inTo = (int) coTo;
		System.out.println("만원단위 회식비 : "  + inTo +" 만원");
		double juTo = total - (inTo * (count-1));
		juTo = Math.ceil(juTo * 10000); //Math.ceil은 나중에 다시배움, 반올림 함수
		System.out.println("주최자의 지불 비용 : " + juTo + " 원" );

		
		
		
		
		
		
		
	}

}
