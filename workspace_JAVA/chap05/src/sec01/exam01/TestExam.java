package sec01.exam01;

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
		for(int i = 0; i <arr5.length; i++) {
			arr4[i+1] = arr5[i];
		}
		for(int i = 0; i <arr4.length; i++) {
			System.out.println("arr4["+i+"] :" + arr4[i]);
		}
		System.out.println("-=-------------------");

		// 문제 7
		// 오른쪽으로 이동 하는데 맨 끝에 값을 맨 처음으로 보내기
		System.out.println("-=-------------------");
		int[] arr6 = new int[arr5.length];
		arr6[0] = arr5[arr5.length-1];
		for(int i = 1; i < arr5.length; i++) {
			arr6[i] = arr5[i-1];
		}
			
		System.out.println("-=-------------------");
		for(int i = 0; i < arr6.length; i++) {
			System.out.println(arr6[i]);
		}

		System.out.println("-=-------------------");
		// 문제 8
		// 임시 8자리 비밀번호 생성
		// 8-1 : 숫자만
		int[] arr7 = new int[8];
		for(int i = 0; i <arr7.length; i++) {
			arr7[i] = (int) (Math.random()*9 +1);
		}
		for(int i = 0; i < arr7.length; i++) {
			System.out.print(arr7[i]);
		}
		System.out.println();
		System.out.println("-=-------------------");
		// 8-2 : 소문자
		int snum = 0;
		char[] arr8 = new char[8];
		for(int i = 0; i <arr8.length; i++) {
			snum = (int)(Math.random()*25 + 1);
			snum +=97;
			arr8[i] = (char)snum;				
		}
		
		for(int i = 0; i < arr8.length; i++) {
			System.out.print(arr8[i]);
		}
		
		System.out.println();
		System.out.println("-=-------------------");
		// 8-3 : 숫자 2개 이상 대/소문자 각 1개 이상
		snum = ((int)(Math.random()*25 + 1)) + 97;
		int bnum = ((int)(Math.random()*25 + 1)) + 65;
		int num = (int)(Math.random()*6 + 1);
		for(int i = 0; i <arr8.length; i++) {
			
			arr8[i] = snum >1 || num >2 || bnum > 1 ; 
			
			
		}
		
		
		
		// 문제 9
		// 자리가 10개 있는 소극장의 예약 시스템
		// 자리 번호는 1~10번까지 번혼의 자리가 있음
		// 메뉴 : 1.예약, 2.모든 작성 현황 3. 잔여 좌석 0. 종료
		// 만약에 1 : 예약이 가능하면 "n번 자리 예약했습니다."

		// 만약에 2 : 예약이 불가능하다면 " 이미 예약되어 있습니다."

		// 문제 10
		// 로또 6개 생성 단, 중복 없이

			
/////////////////////////////////////////////		
	}

}
