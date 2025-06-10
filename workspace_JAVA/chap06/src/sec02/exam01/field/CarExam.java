package sec02.exam01.field;

public class CarExam {
	static int a = 10;
	public static void main(String[] args) {
		
		//객체 (클래스) 생성
		Car mycar = new Car();
		
		System.out.println( mycar.compay );
		mycar.compay = "제규어";
		System.out.println( mycar.compay );

		System.out.println(mycar.speed);
		mycar.speed = 140;
		System.out.println(mycar.speed);
		
		Car mycar2 = new Car();
		System.out.println( mycar2.compay );
		
		System.out.println(a);
		
	}

}
