package sec05.exam02._static;

import java.util.Scanner;

public class Calc {

	static double pi = 3.14;
	static int price;
	// ststic 이긴 하지만 그래 봤자 필드다.
	String color;
	
	//	price = 10000; 이건 안됨.... 필드에서는 행동이 안되니간 
	
	static {
//		System.out.println("값을 입력 하시요 ");
//		Scanner s = new Scanner(System.in);
//		price = s.nextInt();
	}	// static 블록으로 자바가 실행되면 바로 실행이 된다.
	
	
}
