package sec03.exam02._abstract;

public class AnimalExam {
	public static void main(String[] args) {
		
	Animal a = new Tiger();
	a.sound();
	Tiger tiger = (Tiger) a;


	System.out.println(tiger.kind);
	testSound(tiger);
	System.out.println(tiger.kind);
	
}

static void testSound(Animal animal) {
	animal.sound();
	animal.kind = "개";
	
}
}
