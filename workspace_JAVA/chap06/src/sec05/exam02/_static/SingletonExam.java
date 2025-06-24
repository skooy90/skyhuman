package sec05.exam02._static;

public class SingletonExam {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		// private으로 직접 생성은 못하게 막아놨다.
		// static get 함수를 불러 new를 생성하게 하고
		// 함수 내용을 통해 이젠 get함수의 singleton 변수는 
		// s1에 스택에 주소가 있으니깐 s2가 같아 진다.
		
		
		if (s1 == s2 ) {
			System.out.println("같은 객체 ");
		}
		
		
	}
}
