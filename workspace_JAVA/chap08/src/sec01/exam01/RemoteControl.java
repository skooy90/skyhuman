package sec01.exam01;

// new 못함

public interface RemoteControl {

	public static final int MAX_VOLUME = 10;
	// 모든 필드는 static final ( 상수 ) 이다
	// 그래서 생략 가능하다.
	int MIN_VOLUME = 0;
	
	
	public abstract void turnOn();
	// 기본적으로 메소드는 abstract( 추상 ) 메소드다
	// 그래서 생략 가능하다
	
	public void turnOff();
	public void setVolume(int vol);
	
	// default 키워드
	// default 를 이용해서 추상 메소드가
	// 아닌 그냥 메소드를 만들 수 있다.
	default void mic(String text) {
		
	}
	
}
