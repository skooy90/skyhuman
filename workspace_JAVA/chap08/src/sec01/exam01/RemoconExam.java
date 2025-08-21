package sec01.exam01;

public class RemoconExam {

	public static void main(String[] args) {
		
		Tv tv = new Tv();
		
		tv.setVolume(15);
		
		System.out.println("TV 볼륨 : " + tv.vol);
	
//		new RemoteControl(); 추상 , 인터페이스라서 new 가 안됨
		RemoteControl rc1 = (RemoteControl) tv;
		RemoteControl rc2 = tv;
		powerOn(tv);
//		powerOn(rc2);
//		powerOn(rc1);
	}
	
	static void powerOn(RemoteControl rc) {
		rc.turnOn();
	}

}
