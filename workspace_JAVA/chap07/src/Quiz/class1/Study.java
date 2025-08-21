package Quiz.class1;

public class Study {
	void getAnswer(Student student, String q) {
		System.out.println(q + "에 대하여");
		System.out.println(student.name + "물어봅니다.");
		System.out.println(q+"의 대답 :" + student.answer(q));;
	}
}
