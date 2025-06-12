package Quiz;

import java.util.Scanner;

public class FruitstoreExam {

	public static void main(String[] args) {
		
		Fruitstore frust = new Fruitstore("짜증나");
		Scanner sc = new Scanner(System.in);

		
		
		System.out.println("1. 전체 목록 보기 2. 과일 금액 보기 "
				+ "3. 과일 갯수 총합 4.주문하기 5.택배 서비스 ");
		int num = sc.nextInt();
		switch (num) {
		case 1:{			
			frust.allQu();
			break;
		}
		case 2:{
			System.out.println("금액이 궁금한 과일의 입력해주세요 : ");
			String name = sc.next();
			frust.salQu(name);
			break;
		}
		case 3:{
			System.out.println("총액이 궁금한 과일 이름 먼저: ");
			String name = sc.next();
			System.out.println("총액이 궁금한 과일 갯수를 적으세요: ");
			int ea = sc.nextInt();
			int sal = frust.exsalQu(name, ea);
			System.out.println(name + "총합 : " + sal);
		}
		case 4: {
			System.out.println("주문할 과일을 입력하세요: ");
			String name = sc.next();
			System.out.println("주문할 과일의 갯수를 입력하세요: ");
			int ea = sc.nextInt();
			System.out.println("지불할 금액을 입력하세요 : ");
			int sal = sc.nextInt();
			int chageSal = frust.chageSal(name, ea, sal);
			System.out.println("거스름돈 : " + chageSal);
			
		}
		case 5: {
			System.out.println("배송 지역을 입력하세요: ");
			String ju = sc.next();
			System.out.println("주문할 과일의 이름를 입력하세요: ");
			String name = sc.next();
			System.out.println("주문할 갯수를 입력하세요 : ");
			int ea = sc.nextInt();
			String result = frust.parcel(ju, name, ea);
			System.out.println(result);
		}
			
		default:
			break;
		}
		
		
	}

}
