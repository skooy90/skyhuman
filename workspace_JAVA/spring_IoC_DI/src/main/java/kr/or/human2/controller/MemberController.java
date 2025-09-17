package kr.or.human2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.human2.service.MemberService;

@Controller
public class MemberController {

	 MemberController(){
		 System.out.println(" MemberController 생성자 실행");
	 }
	 @Autowired
	 MemberService mService;
	 
	 // 메소드 실행을 위한 주소 연결
	 @RequestMapping("/member")
	 String listMerber() {
		 
		 System.out.println(" List Merber 실행");
		 List list = mService.getList();
		 System.out.println("list : "+list);
		 return "home";
		 
	 }
	 
	 
	 
}
