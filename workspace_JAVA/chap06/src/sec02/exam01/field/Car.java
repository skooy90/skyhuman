package sec02.exam01.field;

public class Car {
	// 필드
	
	//필드의 선언과 동시에 초기화
	String compay = "현대자동차";
	String model = "아반떼";
	String color = "사이버그레이";
	int maxSpeed = 200;
	//필드 선언
	// 초기화 하지 않은 경우 0,false, null로 생성할때(new) 자동 초기화된다. 
	int speed;
//	speed = 50;   안됨 별도 값을 바꾸는 행위는 행동으로 보기때문에 필드에서 안된다.
	
	//필드 영역에는 실행(행동)하면 에러발생.
	
}
