package sec04.exam03._return;

public class Student {
	/*
	 * 클래스
	 * 필드문제1.
	 * 학생 클래스를 만들고 
	 * 이름과 나이필드를 만든다
	 * 학생 Exam 클래스를 만들고
	 * 첫번째,두번째 각각 학생을 등록하고
	 *  두 학생의 정보를 각각 출력해보세요
	 * 
	 * 메소드 문제
	 * 메소드를 통해서 이름과 나이를 전달해서 저장하기
	 * 
	 * 이름과 나이를 전달해서 저장하기
	 * 이름과 나이를 돌려받아서 출력하기
	 */
	
	int age;
	String name;


	void student( String x, int y ) {
		name = x;
		age = y;
	}
	
	String getName() {
		return name;
	}
	
	int getAge() {
		return	age;
	}
	
	
	
	
}

