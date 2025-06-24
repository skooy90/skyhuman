package Quiz;

import java.util.Scanner;

public class UpDownGame {

	// 필드
	// 입력 숫자 , 정답 숫자, 횟수
	Scanner sc = new Scanner(System.in);
	int num;
	int cnum;
	int count;

	// 생성자
	// 게임 생성시 랜덤으로 숫자 생성
	UpDownGame() {
		cnum = (int) (Math.random() * 50 + 1);
	}
	UpDownGame(int start, int end) {
		cnum = (int) (Math.random() * (end- start+ 1) + start);
	}
	// 메소드
	// 정답일 경우

	void answer() {
		System.out.println("정답입니다.");
		System.out.println("게임 횟수 : " + count);
	}

	// UP일 경우
	void up() {
		System.out.println("UP");
		count++;
		System.out.print(" 다시 숫자를 입력 하시오 : ");
		num = sc.nextInt();
	}

	// Douw일 경우
	void down() {
		System.out.println("Down");
		count++;
		System.out.print(" 다시 숫자를 입력 하시오 : ");
		num = sc.nextInt();
	}

	// 게임이 진행

	void game() {
		System.out.println("UP & DOWN 게임을 진행하지");
		System.out.print(" 1  ~ 50 사이의 숫자를 입력 하시오 : ");
		num = sc.nextInt();

		while(true) {
			
		if (num > 0 && num < 51) {
			if (cnum == num) {
				answer();
				break;
			} else if (cnum > num) {
				up();
				continue;
			} else if (cnum < num) {
				down();
				continue;
			}
		} else {
			System.out.println(" 1 ~ 50 숫자만 입력하세요 !");
			continue;
		}
	}

	}

	void game(int start, int end) {
		System.out.println("UP & DOWN 게임을 진행하지");
		System.out.print( start +" ~ "+ end + " 사이의 숫자를 입력 하시오 : ");
		num = sc.nextInt();

		while(true) {
			System.out.println(num +","+ cnum);
		if (num > start && num < end) {
			if (cnum == num) {
				answer();
				break;
			} else if (cnum > num) {
				up();
				continue;
			} else if (cnum < num) {
				down();
				continue;
			}
		} else {
			System.out.println(start +" ~ "+ end + "숫자만 입력하세요 !");
			num = sc.nextInt();
			continue;
		}
	}

	}
	
	
	
}
