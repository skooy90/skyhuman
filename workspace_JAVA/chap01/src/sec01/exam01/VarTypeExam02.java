package sec01.exam01;

public class VarTypeExam02 {

	public static void main(String[] args) {
		
		byte b1;
		// byte타입의 b1변수를 생성했다
		b1 = 127;
		System.out.println(" b1 : " + b1);
//		b1 = 128;
//		System.out.println(" b1 : " + b1);
//		바이트의 용량이 127이기 때문에 128이 들어가면 에러 발생
		// 문자도 유니코드번호가 있다. 
		char c1 = 65;
		System.out.println("c1 : " + c1);
		c1 = 65 + 2;
		System.out.println("c1 : " + c1);
		char c2 = 'F';
		
		System.out.println("c2 : " + c2);
		System.out.println("c1 - c2 : " + (c2 - c1));
		
		char c3 = '한'; 
		// char에 한글도 넣을 수 있다. 단, 한글자만
		
		System.out.println("c3 " + c3);
		System.out.println("c3 : " + (c3 + 1));
		
		
		
		String s1 = "송구영";
		System.out.println("s1 : " + s1);
		
		String s2 = "송\"구영";
		System.out.println("s2 : " + s2);
		
		// \(역슬래쉬) 는 escape문자로 \뒤는 하나의 문자로 본다.
		
		String s3 = "송\t구\n영";
		// \t : tap 탭 기능 , \n : newline 엔터 기능 
		System.out.println("s3: " + s3);
		
		s3 = s3 + "글씨";
		// 글씨 더하기 글씨는 글씨가 된다
		// s3 = s3 + 13;
		s3 = s3 + 1 + 3 + (1+3);
		// 글씨 더하기 숫자도 글씨로 인식이 된다.
		// 더하기는 왼쪽부터 진행이 되어 숫자가 글자로 인식이 된다
		// 단, (괄호) 안에 숫자먼저 더하면 숫자+숫자로 인식하게 된다.
		System.out.println("s3 :" + s3);

		
		String s4 = 3+3+"글씨";
		System.out.println("s4 : " + s4);
		// 숫자를 먼저 더하고 글씨를 더하면 숫자+숫자+글씨가 되어
		// 숫자 계산을 먼저하고 글자가 된다.
		
		int i1 = 2100000000;
//		int i2 = 2200000000; 안된다.
		
		long l1 = 2200000000L;
		// -> int타입에 L를 붙혀 명시적인 long탑으로 바뀐다
		// L 이 없으면 int형으로 봐서 21억 이상은 못넣는다
		// 21억 이하 숫자는 L없이 가능하다
		long l2 = 123; // 가능
		
/////////////////////////////////////////////////////////////////////		
		
		float f1 = 3.14f;
		double d1 = 3.14;
		System.out.println("f1 : " + f1);
		System.out.println("d1 : " + d1);
		
				
		float f2 = 0.123456789f;
		System.out.println("f2 : " + f2);
		// 9가 반올림이 된다 부동소수점
		// float은 소수점 8자리까지만 저장이 가능하여 반올림한다.
		// float는 7자리 까지만 신뢰가 가능하다.
		// 정밀도 : 소수점 7자리
		
		double d2 = 0.12345678901234567890;
		System.out.println("d2 : " + d2);
		// 16까지 나오며 17자리에서 반올림을 한다.
		// double의 정밀도 : 소수점 16자리
		
///////////////////////////////////////////////////////////////////////
		//논리 타입
		
		boolean stop = true;
		boolean start = false;
		// 참 과 거짓을 구분한다.
		
///////////////////////////////////////////////////////////////////
		//문제 1
		// 1. 내 나이를 저장하시오
		int age = 30;
		System.out.println("나이는 : " + age + "살");
		// 2. 내 소유 차가 있다.
		boolean car = true; 
		System.out.println("차 소유 여부 :" + car);
		// 3. 우리집에 있는 스마트폰의 개수
		int phone = 5;
		System.out.println("스마트폰 갯수 : " + phone + "개");
		// 4. 내 이름 정하시오
		String name = "송구영";
		System.out.println("이름은 : " + name + "입니다.");
		// 5. 1평은 3.3제곱미터입니다. 5평은 몇?
		double area = 5.0 * 3.3;
		System.out.println("5평은 : " + area + "입니다.");
		
		
		
		
		// 문제 2
	// 퀴즈1.
		/* 
		 * 두 변수 a,b에 각각 3,4를 넣고
		 * 출력 "3과 4". 단, 변수를 활용해서
		 * */
		int a = 3;
		int b = 4;
		System.out.println(a+"과"+b);
		
		
		
	// 퀴즈1-1.
		/*
		 * 두 변수 a,b에
		 * 출력 결과 : " 3 > 4의 결과는 false 입니다. */
		System.out.println("3 > 4 의 결과는 " + (a>b) + "입니다");
	// 퀴즈 1-2 두변수의 값을 6,5변경
		// 출력 결과 : " 6 > 5의 결과는 true 입니다
		a = 6;
		b = 5;
		System.out.println(a + " > " + b + "의 결과는 " + (a>b) + "입니다");
		
		/*퀴즈 2
		 * 숫자 132
		 * 출력결과 예)
		 * "백의 자리 : 1"
		 * "십의 자리 : 3"
		 * "일의 자리 : 2"
		 * 
		 * */
		int num = 987;
		int n1 = num / 100;
		int n2 = num % 100 / 10;
		int n3 = num % 10;
		System.out.println("숫자는 : " + num);
		System.out.println("백의 자리는 : " + n1);
		System.out.println("십의 자리는 : " + n2);
		System.out.println("일의 자리는 : " + n3);
		
		
		/*
		 * 두 변수 h, m에 각각 시간과 분을 넣습니다.
		 * +35분 한 결과를 출력
		 * 		 * 
		 * */
		int h = 1;
		int m = 54;
	System.out.println((h+(m+35)/60) + "시" + ((m+35)%60) + "분");
		
	
	}

}
