package kr.or.human3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/main")
	public String main(Model model, HttpServletRequest req) {
		System.out.println("/main");
		
		model.addAttribute("id","abcd");
		
		HttpSession sess = req.getSession();
		sess.setAttribute("level", "admin");
		
		return "main";
		
	}
	
}
