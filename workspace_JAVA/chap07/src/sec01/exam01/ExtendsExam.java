package sec01.exam01;

public class ExtendsExam {

	public static void main(String[] args) {
		
		Child ch = new Child();
		System.out.println("=======================================");
		ch.printName();
		
		System.out.println("ch.name : "+ch.name);
		//parent의 name아닌 child의 name이 나옴
		// child의 name이 주석이면 parent 의 name이 나옴
		
		
		System.out.println( "ch.getName() : " + ch.getName() );		
		ch.setName("바뀐 이름");
		System.out.println( "ch.getName() : " + ch.getName() );
		
	}

}
