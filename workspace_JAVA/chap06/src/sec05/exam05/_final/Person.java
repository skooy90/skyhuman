package sec05.exam05._final;

public class Person {
	
	final String nation = "Korea";
	final String ssn;
	String name;
	
	Person(){
		this.ssn = "주민번호";
		this.name = "이름";
//		this.nation = "다른나라";  final필드는 재활당이 안된다.
		
//		this.ssn = "주민번호2"; 
//		final 필드에서 선언만 해서 생성자에서 값 초기화는 가능하나
//		2번의 재할당은 안된다.
		// 메소드에서도 초기화는 안된다.
		this.name = "이름2";
		
		
	}
	
}
