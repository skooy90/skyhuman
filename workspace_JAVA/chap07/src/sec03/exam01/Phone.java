package sec03.exam01;

public abstract class Phone {
	String owner;
	Phone(String owner){
		this.owner = owner;
		
	}
	void turnOn() {
		System.out.println("전원을 킵니다.");
	}
	
}
