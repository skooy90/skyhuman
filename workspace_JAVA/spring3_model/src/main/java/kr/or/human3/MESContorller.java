package kr.or.human3;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mes")
public class MESContorller {
//
//	@RequestMapping("/mes/bom")
//	public String bom() {
//		return "bom";
//	}
//	
//	@RequestMapping("/mes/standard")
//	public String standard() {
//		return "standard";
//	}
	
	// 별로 추천안하는 조합
	@RequestMapping("/bom")
	public String bom() {
		return "bom";
	}
	
	@RequestMapping("/standard")
	public String standard() {

		
		
		return "standard";
	}
	
	
}
