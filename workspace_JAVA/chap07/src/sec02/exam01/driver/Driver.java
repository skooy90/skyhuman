package sec02.exam01.driver;

public class Driver {
	
	void driveTico(Tico tico) {
		System.out.println("오직 티코!");
		tico.run();
		tico.autoRun();
	}
	
	void drive(Car car) {
		System.out.println("run 박습니다. 손님");
		car.start();
		car.run();
		
		if(car instanceof Tico ) {
			System.out.println("아따 티고다잉");
			Tico tico =(Tico)car;
			tico.autoRun();
			((Tico)car).autoRun();
		}
		
		car.stop();
		
	}

}
