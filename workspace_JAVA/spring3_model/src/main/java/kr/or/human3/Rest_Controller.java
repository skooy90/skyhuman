package kr.or.human3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller + //@ResponseBody
// =>
@RestController
public class Rest_Controller {

	@RequestMapping("/a")
	//	@ResponseBody
	public String a() {
		return "a";
	}
	
	@RequestMapping("/b")
	//	@ResponseBody
	public String b() {
		return "b";
	}
	
	
}
