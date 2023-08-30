package kr.kh.study.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.study.service.MemberService;
import kr.kh.study.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/test")
	public String test() {
		int count = memberService.count();
		System.out.println(count);
		return "redirect:/";
	}
	@GetMapping("/member/signup")
	public String memberSignup() {
		return "member/signup";
	}
	
	@PostMapping("/member/signup")//@RequestMapping(value="/member/signup", method=RequestMethod.POST) �� ����
	public String memberSignupPost(Model model, MemberVO member) {
		String msg, url;
		if(memberService.signup(member)) {
			msg="ȸ������ ����!";
			url="/";
		}else {
			msg="ȸ������ ����!";
			url="/member/signup";
		}
		
		System.out.println(member);
		model.addAttribute("url", url);
		model.addAttribute("msg",msg);
		return "util/message";
	}
	
	@GetMapping("/member/login")
	public String memberLogin() {
		
		return "/member/login";
	}
	
	@PostMapping("/member/login")
	public String memberLoginPost(Model model, MemberVO member) {
		String msg, url;
		
		MemberVO user = memberService.login(member);
		
		if(user!=null) {
			msg="�α��� ����!";
			url="/";
		}else {
			msg="�α��� ����!";
			url="/member/login";
			
			
		}
		model.addAttribute("url",url);
		model.addAttribute("msg",msg);
		model.addAttribute("user",user);

		
		return "util/message";
		
	}
		@GetMapping("/member/logout")
		public String memberLogout(Model model, HttpSession session) {
			
			String msg = "�α׾ƿ� ����";
			String url = "/";
			session.removeAttribute("user");
			
			model.addAttribute("url",url);
			model.addAttribute("msg",msg);
			
			
			return "/util/message";
		}
}

