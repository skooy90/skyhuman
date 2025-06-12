package Quiz;

import java.util.Scanner;

public class QuizExam {
	public static void main(String[] args) {
		Quiz word = new Quiz();
		Scanner sc = new Scanner(System.in);
		System.out.println("사전 시스템 시작 버튼 1를 누르세요");
		int num = sc.nextInt();
		while (num != 0) {
			System.out.println("1. 영단어사전 2. 단어 사전 0. 종료");
			num = sc.nextInt();
			switch (num) {
			case 1: {
				System.out.println("사용 가능 영단어");
				System.out.println("love, hate, devil, angel");
				String menu = sc.next();
				System.out.println();
				word.en2Ko(menu);
				String kword = word.getEn2Ko();
				System.out.println(kword);
				break;
			}
			case 2: {
				System.out.println("사용 가능 단어");
				System.out.println("사랑, 증오, 악마, 천사");
				String menu = sc.next();
				word.ko2En(menu);
				String eword = word.getKo2En();
				break;
			}
			}
		}

	}

}
