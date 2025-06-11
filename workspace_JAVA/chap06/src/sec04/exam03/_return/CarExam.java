package sec04.exam03._return;

public class CarExam {

	public static void main(String[] args) {
		
		Car car = new Car();
		Car2 car2 = new Car2();
		boolean status = car.isLeftGas();
		
		car.gas = 3;  // 필드에 작성
		car.setGas(3); // 메소드만들어서 작성
		
		
		status = car.isLeftGas();
		if(status) {
			System.out.println(" 출발 ~ ! ");
			car.run();
		}
		car2.setGas(4);
		car2.run();

		
		
		
		
////////////////////////
	}
		
}
