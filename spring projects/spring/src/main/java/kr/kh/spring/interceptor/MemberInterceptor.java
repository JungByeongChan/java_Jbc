package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		//세션에 회원 정보가 없으면 메인 페이지로 이동
		Object user = request.getSession().getAttribute("user");
		//object user로 해도 상관없음 - 회원정보를 활용이아닌, 존재 유무만 따지기때문
		
		//MemberVO user = (MemberVO)request.getSession().getAttribute("user");

		// 로그인 하지않았으면
		if(user == null) {
			//메인 페이지로 이동
			response.sendRedirect(request.getContextPath()+"/member/login");
			//기존에 가려던 URL은 방문하지 않고 메인으로 이동
			return false;
		}
		//로그인 했으면 기존에 가려던 URL을 방문해서 작업
		return true;
	}

}
