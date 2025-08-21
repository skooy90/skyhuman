package Quiz.class1;

public class MinsuController extends Student {

	MinsuController(){
		super("민수");
	}
	
	MinsuService minsuS = new MinsuService();
	
	@Override
	String answer(String q) {
		String result = minsuS.getInfo(q);
		return result;
	}
}
