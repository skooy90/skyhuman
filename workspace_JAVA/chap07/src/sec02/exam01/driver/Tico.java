package sec02.exam01.driver;

public class Tico extends Car {
	
	@Override
	void run() {
		System.out.println("틱틱틱틱");
	}
	
	void autoRun() {
		System.out.println("자율 주행");
	}
}
