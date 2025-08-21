package sec01.exam01;

public class Tv extends Display implements RemoteControl, OTT {

	int vol;
	
	@Override
	public void turnOn() {
		System.out.println("tv를 켭니다");
	}

	@Override
	public void turnOff() {
		System.out.println("tv를 끕니다");
	}

	@Override
	public void setVolume(int vol) {
//		if(vol > RemoteControl.MAX_VOLUME ) {
//			System.out.println("소리가 너무 커여~ 귀아파여"+RemoteControl.MAX_VOLUME + "이하 설정");
//			this.vol = RemoteControl.MAX_VOLUME;
//		} else if (vol < RemoteControl.MIN_VOLUME) {
//			System.out.println(MIN_VOLUME + "이하 0 설정");
//			this.vol = RemoteControl.MIN_VOLUME;
//		} else {			
//			this.vol = vol;
//		}
		
		if(vol > RemoteControl.MAX_VOLUME )	 vol = RemoteControl.MAX_VOLUME;
		else if(vol > RemoteControl.MIN_VOLUME )	 vol = RemoteControl.MIN_VOLUME;
		
		this.vol = vol;
	}

	@Override
	public void netflix() {
		System.out.println("누누 tv 시청");
	}
	
}
