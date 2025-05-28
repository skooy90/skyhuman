package sec01.exam01;

import java.util.Scanner;

public class KeyCodeExam04 {

	public static void main(String[] args) {
		// 출력하는 방식에 따라 출력하는 값이 달라진다.
		// 
		System.out.println(1);
		System.out.println(2);
		System.out.print(3);
		System.out.print(4);
		// print 와 println은 다음 띄어쓰가 있냐 없냐 차이다. 
		System.out.println(5);
		System.out.println(6);
		
		
		System.out.printf("이름 : %s ", "감자바");
		System.out.println();
		System.out.printf("이름 : %d \n", 25);
		System.out.printf("이름: %s, 나이: %d\n", "감자바", 25);
		
		System.out.printf("이름: %6s, 나이: %-4d \n", "김자바", 25);
//////////////////////////////////////////////////////////////////////
		
//		int keyCode;
//		try {
//			keyCode = System.in.read();
//			System.out.println("keyCode : " + keyCode);
//			keyCode = System.in.read();
//			System.out.println("keyCode : " + keyCode);
//			keyCode = System.in.read();
//			System.out.println("keyCode : " + keyCode);
//			keyCode = System.in.read();
//			System.out.println("keyCode : " + keyCode);
//			keyCode = System.in.read();
//			System.out.println("keyCode : " + keyCode);
//			keyCode = System.in.read();
//			System.out.println("keyCode : " + keyCode);
//				
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		Scanner scan = new Scanner(System.in);
		
//		String inputData = scan.nextLine();
//		System.out.println("inputData : " + inputData);

		// next는 띄어쓰기하면 끝 nextLine 띄어 쓰기 가능
		
		
		int input = scan.nextInt();
		
		System.out.printf("input : ");
		System.out.println();
		System.out.println("input : " + (input*10));
		
		System.out.printf("x값을 입력하시오 : ");
		int inputData2 = scan.nextInt();
		System.out.println();
		System.out.println("입력한 x 값은 : " + inputData2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
