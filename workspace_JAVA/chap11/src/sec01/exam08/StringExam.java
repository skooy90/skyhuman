package sec01.exam08;

import java.util.ArrayList;
import java.util.List;

public class StringExam {

	public static void main(String[] args) {

		String s1 = "영일이삼사오육칠팔구삼사";
		
//		char c = 'a';
		
		char c = s1.charAt(0);
		System.out.println("char c : " + c);
		
		int i1 = s1.indexOf("삼사");
		
		System.out.println("i1 : " + i1);
		int i2 = s1.lastIndexOf("삼사");
		System.out.println("i2 :" + i2);
		
		int i3 = s1.indexOf("a");
		System.out.println("i3 :" + i3);
		
		//이메일 양식 점검
		
		// @ 와 . 이 하나 이상 있는가??
		
		String email = "todair@naver.com";
		
		
		if(email.indexOf("@") != -1 
				&& email.indexOf(".") >=0) {
			System.out.println("합격");
		}else {
			System.out.println("이메일 아님");
		}
		
		
		int idx = -1;
		// indexOf 구현
		// email에 첫 @가 어느 인덱스에 있는지 for , if 만으로 
		
		
		for(int i = 0; i < email.length(); i++) {
			char c1 = email.charAt(i);
			if(c1 == '@' ) {
				idx = i;
				break;
			}
		}
		
		System.out.println("idx : " + idx); 
		
		
		
		String s2 = s1.replace("삼사", "34");
		System.out.println("s1 : " + s1);
		System.out.println("s2 : " + s2);
		// relpace는 모두 바꿔준다
		
		String s3 = s1.substring(5, 8);
		System.out.println("s3 : " + s3);
		
			
		
		// 주미번호 로 남자인지 여자 인지 출력
		
		
		String ssn = "123456-1234567";
		int mn = ssn.indexOf("-");
				
		System.out.println(ssn.substring(mn, mn+2));
		
		String ss1 = ssn.substring(mn, mn+2);
		
		if(ss1.equals("-1") || ss1.equals("-3")) {
			System.out.println("남자!");
		}else if (ss1.equals("-2") || ss1.equals("-4")) {
			System.out.println("여자!");
		}
		
		
		
		// 문제 1
		// blog.naver.co.kr 에서 naver 만 추출하기
		
		String b1 = "blog.naver.co.kr";
		String b2 = "naver";
		int start = b1.indexOf(b2);
		int end = start + b2.length();
		
		System.out.println(b1.substring(start , end));
	
		
		
		
		
		// 문제 2 응원 전광판
		// "Hello world "
		// "ello World H"
		// "llo World He"
		
		String h1 = "Hello world";
		List list = new ArrayList();
		

	
		// 문제 3 마스킹
		// humanec@naver.com 이걸 
		// hu*****@naver.com 이케 
		// love@naver.com 이것도 
		// lo**@naver.com 이케이케
		
		// 문제 4 검색어 찾기

		// 키 query의 값이 검색어 
		// 검색어만 출력
		
		///////////////////////////////////////////////
		
		// trim
        String s5 = "   글씨  중간공백  ";
        System.out.println( "[" + s5 + "]" );
        System.out.println( "[" + s5.trim() + "]" );
        // [   글씨  중간공백  ]
        // [글씨  중간공백]

        // split
        String menu = "김밥,라면,돈까스,제육 덮밥";
        String[] menus = menu.split( "," );
        for( String m : menus ) {
        System.out.println( m );
        }
        // 김밥
        // 라면
        // 돈까스
        // 제육 덮밥

        String url = "blog.naver.com";
        // split 정규 표현식을 사용 ( String 아님에 주의 )
        // . 은 정규 표현식에서 사용하는 의미있는 예약어라서
        // 문자 . 으로 인식하지 않음
        // String[] urls = url.split( "." );
        // 0
        // String[] urls = url.split( "\." ); // . 을 표현하는 방법 1
        // 3
        String[] urls = url.split( "[.]" ); // . 을 표현하는 방법 2
        // 3
        System.out.println( urls.length );

        String a = "a";
        a += "b";
        a = a + "c";

        // StringBuffer
        // 메모리를 효율적으로 사용함
        // StringBuilder 보다 쪼끔 느림
        // 스레드에 안전함 ( Thread-safe )
        StringBuffer sb = new StringBuffer ( "a" );
        sb.append( "b" );
        sb.append( "c" );
        String d = sb.toString();
        System.out.println(d);
        // 스레드에 안전하지 않음
        StringBuilder sbb = new StringBuilder( "a" );
        sbb.append( "b" );
        String d2 = sbb.toString();
        
        System.out.println(d2);
                
        long e = 3000000000L;
        float f = 2.5f;
		
		
		
	}

}
