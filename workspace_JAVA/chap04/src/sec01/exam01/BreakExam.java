package sec01.exam01;

public class BreakExam {
	public static void main(String[] args) {
		
		System.out.println("game Start");
		int count =0 ;
		while(true) {
			int num = (int)(Math.random()*6) + 1;
			System.out.println("주사위 : " + num);
			
			if(num==6) {
				break;
			}
			count++;
			
		}
		System.out.println(count + "만큼 놀았다");
	
/////////////////////////////////////////////
		
		for(int i =1 ; i < 10; i++) {
			System.out.println(i);
			if(i >= 5 ) {  // 혹시 몰라서 == 대신 사용을 한다.
				break;
			}
		}
		
	///////////////////////////////////////////////////////
		
		for(int i = 0; i<5; i++) {
			System.out.println("i : " + i);
			for(int j=0; j<20; j++) {
				System.out.println("j : " + j);
				if(j >=2) {
					System.out.println("break");
					break;
				}
			}
		}
	
		// 총 5명이 주사위 굴리기
		for(int i=1; i<=5; i++) {
			// 한명당 주사위 3번씩 던지기
			System.out.println(i + "번째");
			for(int j=1; j<=3; j++) {
				int num = (int)(Math.random()*6) + 1;
				System.out.println("주사위 : " + num);
				// 만약 6이 나오면 다음사람으로 넘어감
				if(num==6) {
					break;
				}
			}
		}
			
		
		
		
		// 총 5명이 주사위 굴리기
		
		boolean isStop = false;
		
		
		for(int i=1; i<=5; i++) {
			// 한명당 주사위 3번씩 던지기
			System.out.println(i + "번째");
			for(int j=1; j<=3; j++) {
				int num = (int)(Math.random()*6) + 1;
				System.out.println("주사위 : " + num);
				// 만약 6이 나오면 전체 게임종료
				if(num==6) {
					isStop = true;
					break;
				}
			}
			
			if(isStop) {
				break; //전체 for를 나오게 하기 위한 작업
			}
		}
		
		
/////////////////////////////////////////////////////////
		
		for(int i =1; i < 10; i++) {
			if(i % 2 == 0) {	// 짝수만 출력
				System.out.println(i);
			}
		}
		
		for(int i = 1; i < 10; i++) {
			if(i % 2 != 0) {	// 홀수일때는 넘겨라
				continue;
			}
			System.out.println(i);
		}
		
		                                        
		
		
		
		
		
		
///////////////////////////////////////////////////////////////
	}
}
