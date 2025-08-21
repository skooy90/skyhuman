package Quiz.class1;

public class MinsuService {
	
	MinsuDAO minsuDAO = new MinsuDAO();
	
	// 머리속
	String getInfo(String q) {
		String result = minsuDAO.selectAnswer(q);
		if(result == null ) {
			result = "(신중하게 고민하는 중)";
		}else {
			result = "흠,,,,,어...."+ result +"이거여!!";			
		}
		return result;
	}
	
	// Gpt
	// 노션
	
}
