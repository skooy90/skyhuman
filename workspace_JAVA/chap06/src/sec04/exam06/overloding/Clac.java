package sec04.exam06.overloding;

public class Clac {
	
//	int plus (int x, int y) {
//		System.out.println("intint 실행");
//		int result = x + y;
//		return result;
//	}
	// 전단인자가 달라서 오버로딩으로 같은 메소드명이 가능하다.
	// 	
	double plus (double x, double y) {
		System.out.println("doubledouble 실행");
		double result = x + y;
		return result;
	}
		
	double plus (int x, double y) {
		System.out.println("intdouble 실행"); 
		return x + y;
	}
	int plus (int x) {
		System.out.println("int 실행");
		int result = x + x;
		return result;
	}
	
			
/////////////////////////////
}
