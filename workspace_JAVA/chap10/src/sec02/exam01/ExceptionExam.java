package sec02.exam01;

public class ExceptionExam {

	public static void main(String[] args) {

		System.out.println("시작");
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(i + " : " + args[i]);

		}
		int a = -1;
		try {

			String name = " 송구영 ";
			a = Integer.parseInt(name);
			
			
			System.out.println(args[100]);
			System.out.println("1번자리");

//		} catch (Exception ex) {
//			System.out.println("4번자리");
//			ex.printStackTrace();
//			
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("2번자리");
			//catch에서는 이거는 무조건 사용하자
			ex.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("3번째 자리");
			e.printStackTrace();
			System.out.println("-------------------");
			System.out.println(e);
			System.out.println("---:-----:----:----:---");
			System.out.println(e.getMessage());
		} finally {
			// 무조건 실행이 되어 야 할때
			// 권한 값 반환해야 하는 것
			System.out.println("finally 무조건 실행");
		}
		System.out.println("출력");
		System.out.println(a);

	}
	
	//그나마 70점 코드
		
	void test() {
		try {
			// 코딩 실시
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
