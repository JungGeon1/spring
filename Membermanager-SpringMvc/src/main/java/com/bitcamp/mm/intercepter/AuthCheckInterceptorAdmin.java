package com.bitcamp.mm.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptorAdmin extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 현재요청에서 세션이 존재하면 return true

		// 현재 요청에서 세션 개겣 받기
		HttpSession session = request.getSession(false);

//		if(session!=null) {
//			//세션에서 로그인 속성 값을 받아온다.
//			Object auth =session.getAttribute("loginInfo");
//			
//			if(auth!=null) {
//				
//				return true;
//			}
//		} 
		if (session != null && session.getAttribute("admin_id") != null) {
			return true;
		}
		response.sendRedirect(request.getContextPath()+"/member/login");
		
		return false;
	}

	

}
