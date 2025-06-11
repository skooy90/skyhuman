package sec04.exam03._return;

public class StudentExam {

	public static void main(String[] args) {
		
		Student st1 = new Student();
		
		st1.name = "홍길동"; 
		st1.age = 20; 
		
		Student st2 = new Student();
		
		st2.name = "김철수"; 
		st2.age = 22; 
		System.out.println("첫번째 학생 정보");
		System.out.println("나이 : " + st1.age);
		System.out.println("이름 : " + st1.name);
		System.out.println("두번째 학생 정보");
		System.out.println("나이 : " + st2.age);
		System.out.println("이름 : " + st2.name);
		
		Student s1 = new Student();
		
		s1.student("길동이", 20);
		
		String name1 = s1.getName();
		int age1 = s1.getAge();
		System.out.println("이름 : " +name1 + " , " + "나이 : " + age1);
		
		Student s2 = new Student();
		s2.student("둘리", 140);
		
		String name2 = s2.getName();
		int age2 = s2.getAge();
		System.out.println("이름 : " +name2 + " , " + "나이 : " + age2);
			
		
		
	}

}
