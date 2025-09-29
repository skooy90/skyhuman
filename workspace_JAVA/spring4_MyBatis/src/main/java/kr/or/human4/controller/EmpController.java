package kr.or.human4.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.human4.DTO.EmpDTO;
import kr.or.human4.service.EmpService;

@Controller
public class EmpController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	EmpService empService;
	

	@RequestMapping("/listEmp")
	public String listEmp(Model model) {

		List<EmpDTO> list = empService.getEmpList();
		model.addAttribute("list",list);
		return "emp";
	}
	
	@RequestMapping("/EmpOne")
	public String EmpOne(Model model) {
		
		EmpDTO empDTO = empService.getEmp();
		model.addAttribute("empDTO",empDTO);
		
		return "emp";
	}
	
	@RequestMapping("/EmpOneMap")
	public String EmpOneMap(Model model) {
		
		HashMap map = empService.selectOneMap();
		model.addAttribute("map",map);
		
		return "emp";
	}

	@RequestMapping("/getEmpno")
	public String getEmpno(Model model, int empno) {
		System.out.println("empno :" + empno);
		List list = empService.getEmpno(empno);
		model.addAttribute("list",list);
		
		return "emp";
	}
	@RequestMapping("/getEname")
	public String getEname(Model model, String ename) {
		System.out.println("ename :" + ename);
		List list = empService.getEname(ename);
		model.addAttribute("list",list);
		
		return "emp";
	}

	@RequestMapping("/getEmpnoEname")
	public String getEmpnoEname(Model model, EmpDTO dto) {
		System.out.println("dto :" + dto);
		List list = empService.getEmpnoEname(dto);
		model.addAttribute("list",list);
		
		return "emp";
	}
	@RequestMapping("/joinEmp2")
	public String joinEmp2(Model model, EmpDTO dto) {
		System.out.println("dto :" + dto);
		int result = empService.joinEmp2(dto);
		System.out.println("회원 가입 결과 : " + result);
		
//		if (result==0) {
//			
//		}else {
//			
//		}
		
		return "redirect:listEmp";
	}
	
	// 상세 조회 by empno
	@RequestMapping("/empDetail")
	public String empDetail(Model model, int empno) {
		
		EmpDTO empDTO = empService.selecOneEmpno(empno);
		model.addAttribute("empDTO",empDTO);
		
		return "detail";
	}
	
	// 가입하기
	@RequestMapping("/join")
	public String join(Model model) {
		
		return "join";
	}
	
	// 업데이트 가기 
	@RequestMapping("/modify")
	public String updateEmp2(Model model, int empno) {
		EmpDTO empDTO = empService.selecOneEmpno(empno);
		model.addAttribute("empDTO",empDTO);
		return "modify";
	}
	// 업데이트 하기
	@RequestMapping("/updateEmp2")
	public String updateEmp2(Model model, EmpDTO dto) {
		System.out.println("dto :" + dto);
		EmpDTO empDTO = empService.updateEmp2(dto);
		System.out.println("회원 가입 결과 : " + empDTO);
		
		
		return "redirect:listEmp";
	}
	// 삭제 가기 
	@RequestMapping("/delete")
	public String deleteEmp2(Model model, int empno) {
		EmpDTO empDTO = empService.deleteEmp2(empno);
		System.out.println(empDTO);
		return "redirect:listEmp";
	}
	@RequestMapping("/search")
	public String search(Model model, EmpDTO dto) {
		
		List list = empService.selectEmp(dto);
		model.addAttribute("list",list);
		
		
		return "emp";
	}
	
	@RequestMapping("/choice")
	public String chioce(
		@RequestParam("empnos")
		String[] empnos1,		
		@RequestParam("empnos")
		List empnos2,
		
		@ModelAttribute
		EmpDTO empDTO,
		Model model
			) {
		
		System.out.println("String[] :");
		for(String empno : empnos1) {
			System.out.println(empno);
		}
		System.out.println("List :" + empnos2);
		System.out.println("EmpDTO :" + empDTO);
		
		
		List list = empService.foreach(empDTO);
		model.addAttribute("list",list);
		
		return "emp";
	}
	
	@RequestMapping("/log4j")
	public String log4j() {
		
		logger.info("야는 인포넵다 ~");
		logger.warn("경보~ ~");
		logger.error("삐용 ~");
		
		
		
		return"emp";
	}
	
	
	
}
