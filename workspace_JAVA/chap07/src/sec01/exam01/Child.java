package sec01.exam01;

public class Child extends Parent {
	
	void printName() {
		System.out.println("Child의 printName 실행");
		System.out.println("name: " + name);
		System.out.println("this.name: " + this.name);
		
		String pName = getName();
		System.out.println("pName : " + pName);
		System.out.println("super.name : " + super.name);
		
		
	}
	// 전달인자가 필드를 가리는 현상
	// shadow
	void setName(String name) {
		this.name = name;
	}
	
	// 부모의 필드를 가리는 현상
	// overshadow
	String name = "Child의 name";
	
	Child(){
//		super(); // 부모의 생성자 호출(생략 가능)
//				// 첫줄에 적어야 한다. (기본)
		
		super(1); // 전달인자 맞춰줘야 한다.
		
//		this(1); // super(), this() 모두
				// 첫줄에 적어야 해서 같이
				// 사용할수 없다
		
		System.out.println("Child 생성자");
	}
	
	Child(int a) {
		super(1);
	}
	
	
	
	String getName() {
		System.out.println("Child의 name 실행");
		return this.name;
	}
}


/*
생략된 것들
Child(){ 기본 자기 호출 
	super()  부모를 호출
} 
 */