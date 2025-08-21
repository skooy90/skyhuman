package sec03.exam01;

public class Phoneexam {

	public static void main(String[] args) {
		
		//abstract 클래스는 new 할 수 없다.
		//	Phone p = new Phone();
		
		SmartPhone sp = new SmartPhone();
		
		Phone p = (Phone)sp;
		
	}

}
