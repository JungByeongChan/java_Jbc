package kr.kh.study.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.kh.study.service.MemberService;
import kr.kh.study.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		//이미 로그인 되어 있으면 건너뜀
		HttpSession session = request.getSession();
		//부모클래스 객체(Object)를 자식 클래스(MemverVO) 객체로 형변환
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user != null) {//유저가 이미 로그인이 되어있다면
			return true;//건너뜀
		}
		Cookie cookie = WebUtils.getCookie(request, "lc");
		//쿠키가 없으면 건너뜀(자동로그인 X)
		if(cookie == null) {
			return true;
		}
		user = memberService.getMemberBySession(cookie.getValue());
		if(user != null) {
			session.setAttribute("user", user);
		}
		return true;
	}
}
