package sec01.exam03.override;

public class ComputerExam {

	public static void main(String[] args) {

		Computer pc = new Computer();
		calc calc = new calc();
		System.out.println(calc.areaCircle(10));
		System.out.println(pc.areaCircle(10));
		
		System.out.println(pc.plus(10,20));
	}

}