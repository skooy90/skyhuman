package sec03.exam01.constructor;

public class Car {
	String model = "아반떼";
	String color;
	int maxSpeed;
	Car() {
		color = "빨강";
	}
	
//	Car(String c){
//		color = c;
//	}
	
	Car(String c){
		this("아반떼",c,240);  // this() -> 다른 생성자를 호출하는 방법 
		// this() 생성자는 무조건 첫번째 줄에 있어야한다.
		
//		model ="아반떼";
//		color = c;
//		maxSpeed = 240;
//		
		
	}
	
	
	Car(String m, String c, int ms){
		model = m;
		color = c;
		maxSpeed = ms;
	}
	
//	void setColor() {
//		String color;
//		color = "빨강";
//		보인 지역에 있는 color를 본다
//	}
	void setColor(String color) {
//		color = "빨강";
		this.color = color;
	}
	
}
