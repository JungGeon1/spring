package com.petsite.members.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession(false);
		
		// 로그인 되어있을 때
		if(session!=null && session.getAttribute("login")!=null) {
			return true;
		}
		
		// 로그인 안되어있을 때
		response.sendRedirect(request.getContextPath()+"/members/login");
		return false;
	}
	
	
}
