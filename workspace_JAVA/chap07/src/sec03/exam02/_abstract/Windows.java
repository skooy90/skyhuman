package sec03.exam02._abstract;

public abstract class Windows {
	void boot() {
		System.out.println("CMOS 실행");
		System.out.println("윈도우 실행");
		start();
		System.out.println("마우스 커서는 로딩 중 ........");
		System.out.println("마우스 커서는 로딩 중 ........");
	}
	
	
	
	abstract void start();
//	private abstract void start();
//	abstract final void start();
	//이건 말이 안되는거지

	
//	abstract void desktop(); 
	void desktop() {
		// abstract가 갑자기 생기면 기본 라이브러리를 바꿔야해서 힘들다
		// 그래서 그냥 해서 쓸 놈만 사용하면 된다.
	};
}
