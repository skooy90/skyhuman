package sec04.exam03._return;

public class Calc {
	
	// 두 수를 입력 받아 더 한 결과를 돌려주는 메소드 plus
	
	
	
	
	int plus (int x, int y) {
		int result = x + y;
		return result;
	}
	
	double avg (int x, int y) {
		int sum = plus(x,y);
		
		double result = (double)sum / 2;
		
		return result;
	}
	
	void execute(int x, int y) {
		double result = avg(x, y);
		System.out.println( x +" 과 "+ y + "의 평균은 : " + result );
		
	}
	
	
	
}
