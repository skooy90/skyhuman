package sec01.exam03.override;

public class Computer extends calc {
	//@로 붙는게 어노테이션이다 해석이 주석이란다.
	
	
	@Override // 부모의 해당 메소드가 똑같이 선언되어
				//있는지 확인 해줌
	double areaCircle(double r) {
		System.out.println("Computer의  areaCircle");
		return r * r * Math.PI;
	}

	@Override
	public int plus(int x, int y) {
		int result = super.plus(x, y);
		System.out.println("Computer의 plus 실행");
		System.out.println("정답은 바로 "+(result)+"입니다.");
		return result;
	}
	
}