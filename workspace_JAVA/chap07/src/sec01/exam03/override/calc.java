package sec01.exam03.override;

public class calc {
	double areaCircle(double r) {
		System.out.println("Calc의  areaCircle");
		return r * r * Math.PI;
	}
	
	public int plus(int x, int y) {
		System.out.println("Calc의 plus실행");
		return x + y;
	}
	
}