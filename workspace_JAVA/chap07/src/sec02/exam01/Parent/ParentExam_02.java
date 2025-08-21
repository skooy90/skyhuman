package sec02.exam01.Parent;

public class ParentExam_02 {

	public static void main(String[] args) {
		
		Parent1_1_1 p1_1_1 = new Parent1_1_1();
		
		Parent1_1 p1_1 = (Parent1_1)p1_1_1;
		
		Parent1 p1 = p1_1;
		p1 = p1_1_1;
		
		// ↑코드를 줄이면 ↓코드로 만들 수 있다
		
		Parent1 pp1 = new Parent1_1_1();
		
		///////////////////////////////////////////////////////
		
		Parent1_2 p1_2 = new Parent1_2(); 
		Parent1 ppp1 = p1_2;
		
		// 부모가 자식으로 될 때는 
		// 형 변환 연산자 생략 불가능하다.
		Parent1_2 pp1_2 = (Parent1_2)ppp1;
		
		// 런타임 오류 : 실행을 해봐야아는 것
		// Parent1_2 ppp1_2 = (Parent1_2)pp1;
		
		
		
		
		
	}

}
