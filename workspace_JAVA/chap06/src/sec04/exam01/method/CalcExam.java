package sec04.exam01.method;

public class CalcExam {

	public static void main(String[] args) {
		
		Calc calc = new Calc();
		
		calc.powerOn();
		calc.powerOff();
		
		
		
		int sum = calc.plus(145, 25);
		System.out.println("sum : " + sum);
		int x = 5;
		int y = 12;
		sum = calc.plus(x, y);
		System.out.println("sum : " + sum);
		
		
		double div = calc.divide(x, y);

		System.out.println("div : " + div );
		y = 0;
		double div2 = calc.divide(x, y);
		System.out.println("div : " + div2 );
	}


}
