package sec01.exam01;

public class VarExam01 {

	public static void main(String[] args) {

		int value;
		//변수 선언
		value = 5;
		// 변수 초기화
		int result = value + 10;
		//변수 2번 선언 및 초기화
		
		int val;
		// 변수 3번 선언
		val = result + value;
		//변수 3번 초기화 및 값설정
		System.out.println( "val : " + val);
		// 프린트함수로 출력
		
		/////////////////////////////////////////////////
		
		int hour = 3;
		int minute = 5;
		System.out.println(hour + "시간" + minute + "분");
		
		
		///////////////////////////////////////////////////
		
		value = value + 1;
		System.out.println("value : " + value);
		value += 1;
		System.out.println("value : " + value);
		
		
		// 이클립스 단축키
		/*
		 * 한줄 지우기 : Ctrl + d
		 * 한줄 복사 : Ctrl + Alt + 방향키
		 * 주석 단축키 : Ctrl + / (해당 줄 그래그)
		 * 한줄 이동 : Alt + 방향키 (위아래 이동)
		 * 자동 정렬 : Ctrl + Shift + f
		 */
		///////////////////////////////////////////////////
		
		int a = 10;
		// 변수 a를 선언과 동시에 10으로 초기화
		int b;
		// 변수 b 선언
//		System.out.println(b); b가 초기화가 안되서 출력시 에러 발생 
		
		///////////////////////////////////////////////////
		
		int x = 10;
		int y = x;
		
		System.out.println(y);
		System.out.println(x);
		
		{
			System.out.println(x);
			int z = 5;
			System.out.println("z : " + z);
		}
		
//		System.out.println("z : " + z); 
//		중괄호{}안에 변수는 지역변수 밖에서는 인식을 못한다.
		
		int z = 5;
		
		System.out.println("z : " + z);
		
//		{}이 끝나고 z라는 변수는 사라져서 
//		 z는 새로 변수호출을 할 수 있다
		
		int x1 = 26845;
		int x2 = 684684;
		int temp;
		// 값을 잠시 넣을 변수를 만들어줌
		temp = x1;
		x1 = x2;
		x2 = temp;
		// 사이에 코딩을 해 출력할 때 x1 
		System.out.println("x1 : " + x1); //684684
		System.out.println("x2 : " + x2); //26845
	
		
		/* ex/
		 * user + info
		 * 
		//카멜케이스 camel case
		 * : userInfo
		//스네이크케이스 snake case
		 * : user_info
		//캐밥 케이스 kebab case
		 * : user-info
		 */
	}
}
