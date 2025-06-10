
package sec04.exam01.method;

public class Calc {
	
	// 전원 켜기 메소드
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	// 메소드명 powerOff; powerOn 메소드와 동일하게
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	/**
	 * JAVADOC 주석 
	 * 더하기 기능
	 * 두 수를 입력 받아서 더 한 결과를 돌려준다.
	 * 
	 * 메소드명 : plus
	 * 전달인자 : int  x, int y  
	 * 리턴 타입 : int result
	 * 
	 * @param int x, int y
	 * @return int 
	 * @author todair@naver.com
	 * 
	 * 
	 * 
	 */
	
	int plus(int x, int y) {
		System.out.println("x : " + x + " y : " + y );
		
		int result = x + y;
		
		return result;
	}
	
	/**
	 * 나누기 기능
	 * 정수 두 수를 입력받아서 나눈 결과를 돌려준다
	 * 단! 2번째 요소가 0일때는 "안된다"고 출력하고  0을 돌려 줌
	 * 
	 * 메소드명 : divide
	 * 전달인자 : int, int 
	 * 리턴 타입 : double
	 * 
	 */
	double divide(int x, int y) {
		System.out.println("x: " + x + ", y : " + y );
		if(y == 0) {			
			System.out.println("안됩니다. 2번째 요소는 0이 아닌값 입력");
			return 0;
		}
		double result = (double)x / (double)y;
		return result;
		
	}
	// int 배열의 모든 값을 더 하는 메소드 
	int sum(int[] array) {
		int sum = 0;
		for(int i = 0; i <array.length; i++) {
			sum += array[i];
		}
		return sum;
	}
	// 가변인자, 전개연산자, spread op
	// 보내는 곳에서는 sum2(1,2,3,4)
	// 내부에서는 배열로 취급한다.
	int sum2(int ... values) {
		int sum = 0;
		for(int i = 0; i <values.length; i++) {
			sum += values[i];
		}
		return sum;
	}
	
}
