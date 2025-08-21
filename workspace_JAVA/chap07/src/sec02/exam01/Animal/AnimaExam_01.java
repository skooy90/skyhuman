package sec02.exam01.Animal;

public class AnimaExam_01 {

	public static void main(String[] args) {

		Animal a1 = new Animal();
		a1.think();
		a1.eat();
		
		Cat cat = new Cat();
		cat.eat();
		cat.grooming();
		
		Animal a2 = (Animal)cat;  //부모타입으로 형변환
		// 자식이 부모가 될때 
		Animal a3 = cat;	// 형변환 연산자 생략 가능(자동 형변환)
		
		a2.eat();
		// a2.clean(); a2는 부모타입이여서
		// cat에 있는건 오버라이딩이 되지만 부모한테 없음 안됨

		
		
//		Dog dog = new Dog();
//		Animal a4 = dog; ↓와 같다.
		
		Animal a4 = new Dog();		
		
		//static을 사용을 안하면
		// new Animal().catMom(cat); 으로 사용해야한다.
		
		catMom(cat);
		//catMom(dog);는 타입이 안되서 안됨
		a4.age = 10;
		animalCare(a4);
		animalCare(new Cat());
		// new로 해서 받음 age는 animal의 값으로 한다
		// 하나의 animal로 다양하게 받는게 다향성이다.
		// 부모의 것에서 오버로딩된거만 쓰겠다.
	}

	
	static void catMom(Cat cat) {
		System.out.println("캣맘 실행");
		cat.eat();
		cat.grooming();
	}
	
	static void animalCare(Animal animal) {
		System.out.println("나이는 :" + animal.age);
		animal.eat();
		animal.think();
		
	}
	
	
	
}
