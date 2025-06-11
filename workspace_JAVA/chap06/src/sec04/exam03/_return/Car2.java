package sec04.exam03._return;

public class Car2 {
	
	int gas;	
	int speed;
	
	void setSpeed( int s ) {
		speed = s;
		System.out.println("속도를 " + speed +"로 바꿉니다.");
		
	}
	
	void setGas(int g) {
		gas = g;
	}
	
	
	
	
	
	/**
	 * Gas 남아있는지 확인 하는 메소드
	 * 가스가 없다면 거짓, 있다면 참으로 출력
	 * 메소드 명 : isLeftGas
	 * 매개변수 : 없음.(setGas.gas를 참조)
	 * 리턴 타입 : boolean
	 * 
	 */
	
	
	
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("가스없음");
			return false;
		}
		System.out.println("gas가 있음");
		return true;
	}
	boolean isLeftGas2() {
		boolean result = true;
		if(gas == 0) {
			System.out.println("가스없음");
			result = false;
		}else {
			System.out.println("gas가 있음");			
			result = true;
		}
		
		return result;
	}
	
	void run() {
		while(true) {
			if ( gas > 0 ) {
				System.out.println("주행중 ~ 잔량 : " + gas );
				setSpeed(gas * 10);
				gas--;
			}else {
				System.out.println("멈춰!  잔량 : " + gas);
				return;
			}		
		}
	}
	
	
	
	
	
//////////////////////////////
}
