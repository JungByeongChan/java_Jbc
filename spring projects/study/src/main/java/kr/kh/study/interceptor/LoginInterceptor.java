package kr.kh.study.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.study.service.MemberService;
import kr.kh.study.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	MemberService memberService;
	
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler,
			ModelAndView modelAndView) throws Exception {
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");

		if(user != null) {
			request.getSession().setAttribute("user", user);
			if(user.isAutoLogin()) {
				String value = request.getSession().getId();
				Cookie cookie = new Cookie("lc", value);
				cookie.setPath("/");
				int day = 7;
				int time = day * 24 * 60 * 60;
				cookie.setMaxAge(0);//쿠키 유지시간
				response.addCookie(cookie);
				
				Date date = new Date(System.currentTimeMillis() + time * 1000);
				user.setMe_session_id(value);
				user.setMe_session_limit(date);
				memberService.updateMemberSession(user);
			}
		}
	}
}
