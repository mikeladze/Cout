package sout.config.security;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ucha on 3/6/15.
 */
public class SecurityInterceptor implements HandlerInterceptor {


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		HandlerMethod handlerMethod = (HandlerMethod) handler;

//		System.out.println("this-> " + request.getRequestedSessionId());
//		System.out.println("this-> " + request.getRequestURI());
//		System.out.println("this-> " + request.getRemotePort());
//		System.out.println("this-> " + request.getRemoteAddr());
//		System.out.println("this-> " + request.getRemoteHost());

		request.setAttribute("remoteAddr", request.getRemoteAddr());

		System.out.println("Interceptor");
		return true;
	}

	@Override
	public void postHandle(javax.servlet.http.HttpServletRequest request,
	                       javax.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		System.out.println("POST HANDLER");
	}

	@Override
	public void afterCompletion(javax.servlet.http.HttpServletRequest request,
	                            javax.servlet.http.HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}
