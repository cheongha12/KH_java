package com.ncs.test.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberServiceImpl;
	
	
@GetMapping("/")
public String index(HttpSession session) {
	session.getAttribute("loginMember");
	return "index";
}
@GetMapping("/error")
public String errorPage(HttpSession session) {
	session.getAttribute("msg");
	return "errorPage";
}
@PostMapping("/login")
public String memberLogin(@RequestParam String memberId, @RequestParam String memberPwd, HttpSession session) {
	Member member  = new Member();
	member.setMemberId(memberId);
	member.setMemberPwd(memberPwd);
	member= memberServiceImpl.loginMember(member);
	if(member != null) {
		session.setAttribute("loginMember", member);
		return "redirect:/";
	}else {
		session.setAttribute("msg", "로그인 실패");
		return "redirect:/errorPage";
	}
}

}	
	
//	1) 로그인 요청 URL을 매핑하여 서비스 호출 및 뷰 연결처리를 하는 메소드
//	public String memberLogin() 작성.
//	(매개변수는 자유롭게 선언, 반환값은 return "redirect:/";)
	
//@GetMapping("/")
//public String index(HttpSession session) {
//	session.getAttribute("loginMember");
//	return "index";
//	
//}
//@GetMapping("/error")
//public String errorPage(HttpSession session) {
//	session.getAttribute("msg");
//	return "errorPage";
//}
//@PostMapping("/login")
//public String memberLogin(@RequestParam String memberId,@RequestParam String memberPwd, HttpSession session) {
//	Member member = new Member();
//	member.setMemberId(memberId);
//	member.setMemberPwd(memberPwd);
//	member= memberServiceImpl.loginMember(member);
//	if(member != null) {
//		session.setAttribute("loginMember", member);
//		return "redirect:/";
//	}else {
//		session.setAttribute("msg", "로그인 실패");
//		return "redirect:/ errorPage";
//	}
//}

