package sec01.exam01;

import java.util.Scanner;

public class TestExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/*
		 * Integer.parseInt(문자) 특정 수(0)가 오기 전까지 반복
		 * 
		 * 수를 입력하세요 -3 음수 나머지는 "양수"
		 * 
		 */
		int rnum = 0;
		while (true) {
			System.out.println("0입력을 하면 종료 됩니다.");
			System.out.print("수를 입력하세요 : ");
			rnum = sc.nextInt();

			if (rnum < 0) {
				System.out.println("음수입니다.");
			} else if (rnum > 0) {
				System.out.println("양수입니다.");
			} else if (rnum == 0) {
				System.out.println("종료입니다.");
				break;
			}
			System.out.println();
		}

		/*
		 * 월을 입력하면 계절이 나오고 0을 입력하면 종료
		 * 
		 */
		while (true) {
			System.out.println("궁금한 월의 계절 찾기");
			System.out.println("0입력을 하면 종료 됩니다.");
			System.out.print("월을 입력하세요 :");
			rnum = sc.nextInt();

			switch (rnum) {
			case 0: {
				System.out.println("종료");
				break;
			}

			case 3:
			case 4:
			case 5: {
				System.out.println(rnum + "봄 입니다.");
				System.out.println();
				continue;
			}
			case 6:
			case 7:
			case 8: {
				System.out.println(rnum + "여름 입니다.");
				System.out.println();
				continue;
			}
			case 9:
			case 10:
			case 11: {
				System.out.println(rnum + "가을 입니다.");
				System.out.println();
				continue;
			}
			case 12:
			case 1:
			case 2: {
				System.out.println(rnum + "겨울 입니다.");
				System.out.println();
				continue;
			}
			default: {
				System.out.println("1~12월 또는 0(종료)를 입력하세요");
				System.out.println();
				continue;
			}
			}

			break;
		}

		/*
		 * 가위바위보게임 랜덤 0이 입력될 때 까지 반복 횟수도 나오면 좋음
		 */
		int rcnt = 0;
		int dcnt = 0;
		int wcnt = 0;
		System.out.println("가위바위보 랜덤 게임");
		while (true) {

			System.out.println("1. 가위 2.바위 3.보 0.종료");
			System.out.print("원하는 번호를 입력: ");
			rnum = sc.nextInt();
			int comnum = (int) (Math.random() * 3) + 1;

			if (rnum == 1) {
				if (comnum == 1) {
					System.out.println("내꺼 : 가위 컴퓨터 : 가위 ");
					System.out.println("비겼습니다.");
					dcnt++;
					continue;
				} else if (comnum == 2) {
					System.out.println("내꺼 : 가위 컴퓨터 : 보 ");
					System.out.println("이겼습니다.");
					wcnt++;
					continue;
				} else if (comnum == 3) {
					System.out.println("내꺼 : 가위 컴퓨터 : 주먹 ");
					System.out.println("졌습니다");
					rcnt++;
					continue;
				}

			} else if (rnum == 2) {
				if (comnum == 2) {
					System.out.println("내꺼 : 보 컴퓨터 : 보 ");
					System.out.println("비겼습니다.");
					dcnt++;
					continue;
				} else if (comnum == 3) {
					System.out.println("내꺼 : 보 컴퓨터 : 주먹 ");
					System.out.println("이겼습니다.");
					wcnt++;
					continue;
				} else if (comnum == 1) {
					System.out.println("내꺼 : 보 컴퓨터 : 가위 ");
					System.out.println("졌습니다");
					rcnt++;
					continue;
				}

			} else if (rnum == 3) {
				if (comnum == 3) {
					System.out.println("내꺼 : 주먹 컴퓨터 : 주먹 ");
					System.out.println("비겼습니다.");
					dcnt++;
					continue;
				} else if (comnum == 1) {
					System.out.println("내꺼 : 주먹 컴퓨터 : 가위 ");
					System.out.println("이겼습니다.");
					wcnt++;
					continue;
				} else if (comnum == 2) {
					System.out.println("내꺼 : 주먹 컴퓨터 : 보 ");
					System.out.println("졌습니다");
					rcnt++;
					continue;
				}

			} else if (rnum == 0) {
				System.out.println("게임을 종료합니다.");
				System.out.println("게임 결과");
				System.out.println(" 이긴 횟수 : " + wcnt);
				System.out.println(" 비긴 횟수 : " + dcnt);
				System.out.println(" 진 횟수 : " + rcnt);
				break;
			} else {
				System.out.println("보기 있는 숫자를 입력하세요");
				continue;
			}
			System.out.println();

		}

		/*
		 * 은행에서 1. 예금, 2. 출금 , 3.잔고확인, 4. 종료 조건 예금할 때 음수 불가 출금할 때 음수불가 , 잔고보다 큰 금액 불가
		 * 
		 * 
		 */
		int money = 100000;
		while (true) {

			System.out.println("ATM 서비스");
			System.out.println("1. 예금, 2. 출금 , 3.잔고확인, 4. 종료");
			System.out.print("원하시는 서비스를 입력해주세요: ");
			rnum = sc.nextInt();
			if (rnum == 1) {
				System.out.println("예금 서비스 실행");
				System.out.print("예금 할 금액을 입력해주세요: ");
				int pay = sc.nextInt();
				money = money + pay;
				System.out.println(" 통장 잔액 : " + money + "원 입니다.");
				continue;
			}

			if (rnum == 2) {
				System.out.println("출금 서비스 실행");
				System.out.print("출금 할 금액을 입력해주세요 :");
				int pay = sc.nextInt();
				if (pay <= money) {
					money = money - pay;
					System.out.println(pay + "원이 출금되었습니다.");
					System.out.println("남은 잔액은 : " + money + "입니다.");
					continue;
				} else if (pay > money) {
					System.out.println("잔액이 부족합니다.");
					continue;
				}
			}

			if (rnum == 3) {
				System.out.println("통장 잔액 확인 서비스");
				System.out.println("통장 잔액 : " + money);
			}

			if (rnum == 4) {
				System.out.println("서비스를 종료합니다.");
			}

		}

		
//////////////////////////////////////////
	}
}
