package sec05.exam02._static;

public class CalcExam {

	public static void main(String[] args) {

		
		
		
		System.out.println("Calc.pi : " + Calc.pi);
		
		Calc c1 = new Calc();
		
		c1.color = "블랙";
		
		c1.pi = 3.141592;
		System.out.println("c1.pi : " + c1.pi);

		Calc c2 = new Calc();
		
		c2.color = "빨강";
		
		System.out.println("c2.pi : " + c2.pi);
		
		System.out.println("Calc.pi : " + Calc.pi);
		test();
		
	}
	// 1. 메소드명 test  만들기
	/* 
	 * 전달 인자 / 리턴 타입 없음
	 * 그냥 이무 말이나 출력
	 */
	static void test(){
		System.out.println("아무말");
	}
}
