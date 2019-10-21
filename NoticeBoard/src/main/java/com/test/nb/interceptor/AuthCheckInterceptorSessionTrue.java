package com.test.nb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptorSessionTrue extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 현재요청에서 세션이 존재하면 return true

		// 현재 요청에서 세션 개겣 받기
		HttpSession session = request.getSession(false);


		if ( session == null) {
			return true;
		}
		response.sendRedirect(request.getContextPath()+"/logout");
		
		return false;
	}

	

}
