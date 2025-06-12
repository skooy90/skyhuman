package Quiz;

import java.util.Scanner;

public class Quiz {

	/*
	 * 전자 사전 단어 En2Ko(영단어) 영단어 Ko2En(단어)
	 *
	 *
	 * String[] en = {love, hate, devil, angel} String[] 
	 * 			ko = {사랑, 증오, 악마 , 천사}
	 * 
	 * 
	 */
	Scanner sc = new Scanner(System.in);

	String[] en = { "love", "hate", "devil", "angel" };
	String[] ko = { "사랑", "증오", "악마", "천사" };

	boolean b;
	String koWord;
	String enWord;
	
	
	void en2Ko(String x) {
		for (int i = 0; i < en.length; i++) {

			if (x.equals(en[i])) {
				koWord= ko[i];
				break;
			}

		}
	}
	
	String getEn2Ko() {
		return koWord;
	}

	void ko2En(String x) {
		for (int i = 0; i < ko.length; i++) {

			if (ko[i].equals(x)) {
				enWord = en[i];
				break;
			}

		}
	}
	String getKo2En() {
		return enWord;
	}

}
