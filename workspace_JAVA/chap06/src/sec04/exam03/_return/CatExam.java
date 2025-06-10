package sec04.exam03._return;

public class CatExam {

	public static void main(String[] args) {
		
		Car car = new Car();
		
		boolean status = car.isLeftGas();
		
		car.gas = 3;
		car.setGas(3);
		
		status = car.isLeftGas();
		if(status) {
			System.out.println(" 출발 ~ ! ");
			car.run();
		}
		
	}
		
}
