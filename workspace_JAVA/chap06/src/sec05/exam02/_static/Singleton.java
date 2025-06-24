package sec05.exam02._static;

public class Singleton {

	
	// 버젼 1
//	private static Singleton singleton = null;
//	
//	private  Singleton() {
//		
//	}
//	
//	static Singleton getInstance() {
//		if(Singleton.singleton == null) {
//			Singleton.singleton = new Singleton();
//		}
//		return Singleton.singleton;
//	}
//	
	// 버젼 2 
	private static Singleton singleton = new Singleton();
	
	private  Singleton() {
		
	}
	
	static Singleton getInstance() {
		return Singleton.singleton;
	}
	
}
