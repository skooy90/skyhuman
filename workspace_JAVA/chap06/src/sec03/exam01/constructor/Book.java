package sec03.exam01.constructor;

import java.util.Scanner;

public class Book {
	Scanner sc = new Scanner(System.in);
	String title;
	String author;
	boolean isBorrwed;
	
	Book(String x, String y){
		title = x;
		author = y;
		isBorrwed = false;
	}
	
	void borrowBook() {
		if(isBorrwed == false) {
			System.out.println("책을 대여 할 수 있습니다.");
			System.out.println("책을 대여 할 실?? ");
			System.out.print("1. 예 , 2. 아니요 : ");
			int borr = sc.nextInt();
			switch(borr) {
			case 1: {
				System.out.println(" 책을 대여 했습니다.");
				isBorrwed = true;
				break;
			}
			case 2: {
				System.out.println(" 책 대여를 취소 했습니다.");
				break;
			}
			default : {
				System.out.println("1 또는 2 를  입력해주세요.");
				break;
			}
			
			}
				
		}else if (isBorrwed == true) {
			System.out.println("이미 대여된 책입니다.");
		}
		
	}
	
	void returnBook() {
		System.out.println("책을 반납했습니다.");
		isBorrwed = false;
	}
	
	void displayInfo() {
		System.out.println(title);
		System.out.println(author);
		if(isBorrwed == false) {
			System.out.println(" 대여 가능 ");
		}else {
			System.out.println("대여 불가능");
		}
	}
	
}
