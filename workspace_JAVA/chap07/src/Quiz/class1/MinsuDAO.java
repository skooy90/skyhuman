package Quiz.class1;

import java.util.HashMap;

public class MinsuDAO {
	HashMap map = new HashMap();
	MinsuDAO(){
		map.put("사탕", "청포도");
		map.put("점심", "흠....");
		map.put("휴식", "네네!!");
	}
	
	String selectAnswer(String q) {
		return (String) map.get(q);
	}
	
}
