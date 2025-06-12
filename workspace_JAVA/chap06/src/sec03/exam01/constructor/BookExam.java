package sec03.exam01.constructor;

import java.util.Scanner;

public class BookExam {

	public static void main(String[] args) {

		
		Book b1 = new Book("책1", "저자1");
		Book b2 = new Book("책2", "저자2");
		Book b3 = new Book("책3", "저자3");
		Book b4 = new Book("책4", "저자4");
		Book b5 = new Book("책5", "저자5");
		Book b6 = new Book("책6", "저자6");

		Book[] book = {b1,b2,b3,b4,b5,b6};
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("책 대여 시스템에 오시걸 환영합니다.");
		System.out.println(" 서비스를 실행 하실거면 1번을 눌러주세요 ");
		int menu = sc.nextInt();

		while (menu != 0) {
			System.out.print("서비스 항목 1. 책정보보기 2, 대여하기 3, 반납하기 0, 종료");
			menu = sc.nextInt();
			switch (menu) {
			case 1: {

				for(int i = 0; i < book.length; i++) {
					if(i%3 == 0) {
						System.out.println();
					}
					if(i == book.length-1) {
						System.out.println((i+1)+"번 책 ");						
					}else {
						System.out.print((i+1)+"번 책, ");						
					}
				}
				
				System.out.println("원하시는 책 번호를 입력하세요 : ");
				int menu2 = (sc.nextInt()-1);
				book[menu2].displayInfo();
				break;
			}
			case 2:{
				System.out.println("대여하실 책 번호를 입력하세요 : ");
				int menu2 = (sc.nextInt()-1);
				book[menu2].borrowBook();
				break;
			}
			case 3:{
				System.out.println("대여하실 책 번호를 입력하세요 : ");
				int menu2 = (sc.nextInt()-1);
				book[menu2].returnBook();
				break;
			}
			case 0:
				System.out.println(" 서비스 종료 !");
				break;
			}

		}

	}

}
