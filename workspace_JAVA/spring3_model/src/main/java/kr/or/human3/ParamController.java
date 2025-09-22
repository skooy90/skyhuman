package kr.or.human3;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParamController {
	// 방법 서블릿이용한 1
	@RequestMapping("/join.do")
	public void joinForm(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8;");
			request.getRequestDispatcher("/WEB-INF/views/join.jsp").forward(request, response);

		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 방법 2
	@RequestMapping("/join2.do")
	public ModelAndView joinForm2() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("join");
		return mav;
	}

	// 방법3
	@RequestMapping("/join3.do")
	public ModelAndView joinForm3() {
		ModelAndView mav = new ModelAndView("join");
		System.out.println("잘들어옴");
		return mav;
	}

	// 방법4
	@RequestMapping("/join1")
	public void login1(HttpServletRequest request) {
		String id = request.getParameter("id");
		System.out.println("id : " + id);
	}

	// 방법4 -> 다음단계
	@RequestMapping("/join2")
	public ModelAndView login2(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		System.out.println("id : " + id);

		request.setAttribute("id", id);
		ModelAndView mav = new ModelAndView("result");

		return mav;
	}

	// 방법4 -> 다음단계
	@RequestMapping("/join3")
	public ModelAndView login3(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		System.out.println("id : " + id);

//		request.setAttribute("id", id);

		ModelAndView mav = new ModelAndView("result");
		mav.addObject("id", id);

		return mav;
	}

	// 방법4 -> 다음단계
	@RequestMapping("/join4")
	public ModelAndView login4(HttpServletRequest request) {
		MemberDTO mDTO = new MemberDTO();

		try {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String sAge = request.getParameter("age");
			int age = Integer.parseInt(sAge);

			mDTO.setId(id);
			mDTO.setPw(pw);
			mDTO.setAge(age);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

//		request.setAttribute("id", id);

		ModelAndView mav = new ModelAndView("result");
		mav.addObject("mDTO", mDTO);

		return mav;
	}

	// 방법4 -> 다음단계
	@RequestMapping("/join5")
	public ModelAndView login5(

			// requst.getParmaeter 와 같음
			// 기본적으로 필수 값. 그래서 없으면 400에러 Bad Request 코드 발생
			@RequestParam("id") String id, @RequestParam("pw") String pw,

			// 필수가 아님, 값이 없으면 null
			@RequestParam(value = "nm", required = false)
			// null도 인정하는거
			String nm,

			@RequestParam("age") int age,
			// parameter의 변수명과 같다면 @RequestParam을 생략할 수 있다
			// key가 없으면 null
			// 이 경우 아래줄이 생략된다. 필수가 아님에 주의!
			// @RequestParam("tel")
			String tel,

			@RequestParam Map map

	// 아직 안됨
//			@RequestParam
//			,MemberDTO dto

	) {

		System.out.println("id: " + id);
		System.out.println("pw: " + pw);
		System.out.println("nm: " + nm);
		System.out.println("age: " + age);
		System.out.println("tel: " + tel);
		System.out.println("map: " + map);

		ModelAndView mav = new ModelAndView("result");

		return mav;
	}

	// 방법4 -> 다음단계
	@RequestMapping("/join6")
	public ModelAndView login6(HttpServletRequest request, HttpServletResponse response, String id, String pw,
			String nm, int age) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		ModelAndView mav = new ModelAndView("result");
		mav.addObject("id", id);
		mav.addObject("pw", pw);
		mav.addObject("nm", nm);
		mav.addObject("age", age);
		return mav;
	}
	// 방법4 -> 다음단계
	@RequestMapping("/join7")
	public ModelAndView login7(
			
			
			//parameter에서 꺼내서 DTO에 알아서 넣어 줌
			@ModelAttribute
			MemberDTO dto1,
			
			// DTO를 자동으로 채우고
			// 모델에 넣어주기까지 함.
//			@ModelAttribute("mDTO2")
//			MemberDTO dto2
//			
			// @ModelAttribute생략 가능함
			// 생략하면 타입(클래스)의 앞글자를 소문자로 변경한 key로
			// 모델에 넣어줌
			//@ModelAttribute("memberDTO")
			MemberDTO dto3
			
			
			)  {
		System.out.println("dto1: " + dto1);
		System.out.println("dto3: " + dto3);
		ModelAndView mav = new ModelAndView("result");
//		mav.addObject("mDTO", dto1);
		return mav;
	}
	
	// 방법4 -> 다음단계
		@RequestMapping("/join8")
		public ModelAndView join7(String id, MemberDTO dto) {
			ModelAndView mav = new ModelAndView("result");
			return mav;
		}
		

		@RequestMapping("cal/1")
		public void cal() {
			System.out.println("1월! 달력");
		}
		
		@RequestMapping("cal/{month}")
		public void cal2(
				@PathVariable("month")
				int mon
				
				) {
			System.out.println(mon + "월 달력");
		}
		
		
		@RequestMapping("/lunch/{store}/order/{menu}")
		public void cal3(
				@PathVariable("store")
				String store,
				@PathVariable("menu")
				String menu
				) {
			System.out.println(store + "에서 " + menu +"를 준비합니다.");
		}
		
		@RequestMapping("/join9")
		public String join9() {
			return "join";
		}
		@RequestMapping("/join10")
		public String join10() {
			return "redirect:join3.do";
		}
		
		
		// 최종 버젼
		
		@RequestMapping("/join11")
		public String join11( Model model,String id   ) {
			System.out.println("/join11 실행, id: "+id);
			model.addAttribute("id", id);
			
			return "result";
		}
		@RequestMapping("/join12")
		public String join12(  ) {
			
			return "result";
		}
		@RequestMapping({"/join13","/join14"})
		public String join13(  ) {
			
			return "result";
		}
		
		@RequestMapping(value="/join15", method=RequestMethod.POST)
		public String doPost(  ) {
			
			return "result";
		}
		@RequestMapping(value="/join15", method=RequestMethod.GET)
		public String doGet(  ) {
			
			return "result";
		}
		
		@RequestMapping(value="/join16", method= { RequestMethod.GET, RequestMethod.POST})
		public String doGet16(  ) {
			
			return "result";
		}
		@RequestMapping("/join")
		public void join17() {
			System.out.println("/join 실행");
		}
		
}
