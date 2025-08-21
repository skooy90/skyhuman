package sec02.exam01;

import java.io.FileInputStream;
import java.io.IOException;

public class ThrowsExam {
	public static void main(String[] args) {

		try {
			test();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			test2(15);
		} catch (HumanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("c:\\tmp\\text.txt");
			// 뭔가 함
			// 예외가 발생할 수 있다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {

				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// try-with-resoutces
		// close() 자동 실행
		// Closable 인터 페이스가 있는 클래스만 ()에 넣을 수 있다.

		try (FileInputStream fis2 = new FileInputStream("c:\\tmp\\text.txt");) {
			System.out.println("뭔가 함");
			System.out.println(fis2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static void test() throws ClassNotFoundException, IOException {

		Class.forName("asdqwelkjfjoi");

	}

	static void test2(int vol) throws HumanException {

		if (vol > 10) {
			throw new HumanException("시끄럽다 10 이하로 주려");
		}

		System.out.println("vol :" + vol);
	}

	static void tes3(int vol) throws HumanException {
		"a".equals(null);
	}

}
