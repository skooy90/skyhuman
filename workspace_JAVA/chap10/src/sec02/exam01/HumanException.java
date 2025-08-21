package sec02.exam01;

public class HumanException extends Exception {
	
	HumanException(){
		System.out.println("휴먼 생성");
	}
	
	HumanException(String message){
		super(message);
		System.out.println("휴먼 스트링 생성");
	}
	
	
}
