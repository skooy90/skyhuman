package sec01.exam01;

import java.util.Scanner;

public class TestExam {

	public static void main(String[] args) {
		// 문제 0
		// 배열 깊은 복사 1,2,3
		int[] arr1 = new int[] { 1, 2, 3 };
		int[] arr2 = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
			System.out.println("arr2[" + i + "] =" + arr2[i]);
		}

		// 문제 1
		// 배열 뒤집기 1,2,3
		for (int i = 1; i <= arr1.length; i++) {
			arr2[i - 1] = arr1[arr1.length - i];
		}
		for (int i = 0; i < arr1.length; i++) {
			System.out.println("arr2[" + i + "] =" + arr2[i]);
		}

		System.out.println("-=-------------------");
		// 문제 2 배열 여기서 [3,4,7,5,1,9,4]
		// 문제 2-1
		// 홀수의 개수 찾기
		int[] arr3 = new int[] { 3, 4, 7, 5, 1, 9, 4 };
		int count = 0;
		for (int i = 0; i < arr3.length; i++) {
			if (arr3[i] % 2 != 0) {
				count++;
			}
		}
		System.out.println("홀수의 개수 : " + count);
		System.out.println("-=-------------------");

		// 문제 2-2
		// 여기서 4보다 큰 수의 개수 구하기
		count = 0;
		for (int i = 0; i < arr3.length; i++) {
			if (arr3[i] > 4) {
				count++;
			}
		}
		System.out.println("4보다 큰 숫자 : " + count);
		System.out.println("-=-------------------");

		// 문제 4
		// 여기서 최대값 구하기
		int max = arr3[0];
//		max = Integer.MIN_VALUE; //최소값 넣기
		for (int i = 1; i < arr3.length; i++) {
			if (max > arr3[i]) {
				max = max;
			} else if (max < arr3[i]) {
				max = arr3[i];
			}
		}
		System.out.println("최댓값 : " + max);
		System.out.println("-=-------------------");

		// 문제 5
		// 여기서 2번째 큰 수 구하기
		// 정렬을 이용한 2번째 값 구하기
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3.length; j++) {
				if (arr3[i] > arr3[j]) {
					int temp = arr3[j];
					arr3[j] = arr3[i];
					arr3[i] = temp;
				}

			}

		}
		System.out.println("2번째로 큰 수는: " + arr3[1]);
		System.out.println("-=-------------------");
		// max값을 구한 후 제외한 max 2번째 구하기.
		max = arr3[0];
		for (int i = 1; i < arr3.length; i++) {
			if (max > arr3[i]) {
				max = max;
			} else if (max < arr3[i]) {
				max = arr3[i];
			}
		}
		int max2 = 0;
		for (int i = 1; i < arr3.length; i++) {
			if (arr3[i] != max) {

				if (max2 > arr3[i]) {
					max2 = max2;
				} else if (max2 < arr3[i]) {
					max2 = arr3[i];
				}
			}
		}
		System.out.println("2번째로 큰 수는: " + max2);

		// 문제 6
		// 오른쪽으로 한칸 밀기(왼쪽은 0으로 채우기)
		int[] arr5 = new int[] { 3, 4, 7, 5, 1, 9, 4 };
		int[] arr4 = new int[arr5.length + 1];
		arr4[0] = 0;
		for (int i = 0; i < arr5.length; i++) {
			arr4[i + 1] = arr5[i];
		}
		for (int i = 0; i < arr4.length; i++) {
			System.out.println("arr4[" + i + "] :" + arr4[i]);
		}
		System.out.println("-=-------------------");

		// 문제 7
		// 오른쪽으로 이동 하는데 맨 끝에 값을 맨 처음으로 보내기
		System.out.println("-=-------------------");
		int[] arr6 = new int[arr5.length];
		arr6[0] = arr5[arr5.length - 1];
		for (int i = 1; i < arr5.length; i++) {
			arr6[i] = arr5[i - 1];
		}

		System.out.println("-=-------------------");
		for (int i = 0; i < arr6.length; i++) {
			System.out.println("arr6["+ i + "] : " + arr6[i]);
		}

		System.out.println("-=-------------------");
		// 문제 8
		// 임시 8자리 비밀번호 생성
		// 8-1 : 숫자만
		int[] arr7 = new int[8];
		for (int i = 0; i < arr7.length; i++) {
			arr7[i] = (int) (Math.random() * 9 + 1);
		}
		for (int i = 0; i < arr7.length; i++) {
			System.out.print(arr7[i]);
		}
		System.out.println();
		System.out.println("-=-------------------");
		// 8-2 : 소문자
		int snum = 0;
		char[] arr8 = new char[8];
		for (int i = 0; i < arr8.length; i++) {
			snum = (int) (Math.random() * 25 + 1);
			snum += 97;
			arr8[i] = (char) snum;
		}

		for (int i = 0; i < arr8.length; i++) {
			System.out.print(arr8[i]);
		}

		System.out.println();
		System.out.println("-=-------------------");
		//범위 값 랜덤 코드
		int start = 97;
		int end = 122;
		int randoms = (int) (Math.random()*(end - start + 1)) + start;
		// 범위값 지금은 소문자만 
		// 8-3 : 숫자 2개 이상 대/소문자 각 1개 이상
		// 조금더 정답인 코드
		// 결국 카운트로 인한 계산하기
		
		
		// 여기는 내가 하거
		snum = ((int) (Math.random() * 25 + 1)) + 97;
		int bnum = ((int) (Math.random() * 25 + 1)) + 65;
		int num = (int) (Math.random() * 9 + 1);

		System.out.print((char) bnum);
		System.out.print((char) snum);
		for (int i = 0; i < arr8.length - 4; i++) {
			snum = ((int) (Math.random() * 25 + 1)) + 97;
			bnum = ((int) (Math.random() * 25 + 1)) + 65;
			num = (int) (Math.random() * 9 + 1);
			int[] hnum = new int[] { snum, bnum, num };
			int ran = (int) (Math.random() * 3);
			if (ran > 1) {
				System.out.print(hnum[ran]);
			} else if (ran <= 1) {
				System.out.print((char) hnum[ran]);
			}
		}
		System.out.print(num);		
		num = (int) (Math.random() * 9 + 1);
		System.out.print(num);
		System.out.println();
		// 문제 9
		// 자리가 10개 있는 소극장의 예약 시스템
		// 자리 번호는 1~10번까지 번혼의 자리가 있음
		// 메뉴 : 1.예약, 2.모든 작성 현황 3. 잔여 좌석 0. 종료
		// 만약에 1 : 예약이 가능하면 "n번 자리 예약했습니다."
		System.out.println("-=-------------------");
		int[] ja = new int[10];
		Scanner sc = new Scanner(System.in);
		boolean isStop = false;
		int sel = 1;
		while (true) {
			System.out.println("1.예약, 2.모든 자석 현황 3. 잔여 좌석 0. 종료");
			sel = sc.nextInt();

			switch (sel) {
			case 1:
				System.out.println("예약시스템");
				System.out.println("1 ~ 10 자리");
				System.out.print("예약할 자리를 선택하세요! :");
				int res = sc.nextInt();
				sel = res - 1;
				if (ja[sel] == 0) {
					ja[sel] = 1;
					System.out.println(res + "번 자리를 예약했습니다.");
				} else if(ja[sel] != 0) {
					System.out.println(res + "번 자리는  이미 예약되어있습니다.");					
				}
				continue;

			case 2:
				System.out.println("모든 자석 현황 시스템");
				for (int i = 0; i < ja.length; i++) {
					num = 0;
					if (ja[i] == 0) {
						num = i+1;
						System.out.println((num) + "자리는 공석입니다.");
					} else if (ja[i] == 1) {
						num = i+1;
						System.out.println((num) + "자리는 예약된 자리입니다.");
					}
				}
				continue;

			case 3:
				count = 0;
				System.out.println("잔여 좌석 확인 시스템");
				for (int i = 0; i < ja.length; i++) {
					if (ja[i] == 0) {
						count++;
					}
				}
				System.out.println(count + "개 잔여 자리 개수입니다.");
				continue;

			case 0:
				isStop = true;
				System.out.println("시스템 종료");
				break;

			default:
				System.out.println("보기에 제한된 숫자만 입력");
				continue;
			}
			if (isStop == true) {
				break;
			}
		}

		// 만약에 2 : 예약이 불가능하다면 " 이미 예약되어 있습니다."

		// 문제 10
		// 로또 6개 생성 단, 중복 없이
		System.out.println("-=-------------------");
		System.out.println("로또 6 개 생성기");
		int[] lotto = new int[6];
		int i = 0;
		while(i < 6) {
			
			int ran = (int) (Math.random()*45 + 1);
			for(int j = 0; j < lotto.length; j++ ) {
				if(lotto[j] != ran) {
					lotto[i] = ran;
				}else if (lotto[j] == ran) {
					continue;
				}
			}
			i++;
		}
		for(i = 0; i < lotto.length; i++) {
			if(i < lotto.length-1) {
				System.out.print(lotto[i] + ", ");				
			}else if (i == lotto.length-1) {
				System.out.print(lotto[i]);								
			}
		}
		
/////////////////////////////////////////////		
	}

}
