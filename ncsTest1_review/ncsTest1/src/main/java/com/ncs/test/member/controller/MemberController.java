package com.ncs.test.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberServiceImpl;
	
//	1) 로그인 요청 URL을 매핑하여 서비스 호출 및 뷰 연결처리를 하는 메소드
//	public String memberLogin() 작성.
//	(매개변수는 자유롭게 선언, 반환값은 return "redirect:/";)
	
	
	// 로그인 요청 URL을 매핑하여 서비스 호출 및 뷰 연결처리를 하는 메소드
	@GetMapping("/")
	public String index() {
		//1) 로그인 요청 URL을 매핑하여 서비스 호출 및 뷰 연결처리를 하는 메소드
		return "index";
	}
	
	@GetMapping("/error")
	public String errorPage() {
		return "errorPage";
	}
	
	@PostMapping("/login")
	public String memberLogin(Member vo
			//, @RequestParam("memberId") String id, @RequestParam("memberPwd") String pwd
			, Model model
			, HttpSession session
			, RedirectAttributes rtts
			) {
		//memberServiceImpl.lo
//		Map<String, String> mapParam = new HashMap<String, String>();
//		mapParam.put("id", id);
//		mapParam.put("pwd", pwd);
		Member result = memberServiceImpl.loginMember(vo);
		if(result == null) {
			// 2) 로그인 실패시 "로그인 실패" 메시지 출력
			rtts.addFlashAttribute("msg", "로그인 실패");
			return "redirect:/error";
		}
		//model.addAttribute("loginMember", result);
		session.setAttribute("loginMember", result);
		
		return "redirect:/";
	}
}
