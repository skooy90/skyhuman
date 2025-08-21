package sec02.exam01.driver;

public class Car extends Object {
	
	Car(){
		super();
	}
	// 깨알 위에 extends 와 Car() 생성자는 생략이 된거다.
	
	void start() {
		System.out.println("시동을 켜기");
	}
	
	void stop() {
		System.out.println("시동 끄기");
	}
	
	void run() {
		System.out.println("주행중......");
	}
	
	
}
