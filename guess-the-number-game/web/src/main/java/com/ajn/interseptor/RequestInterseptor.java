package com.ajn.interseptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestInterseptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.debug("prehandle method called. handler = {}",handler);
		log.debug("URL = {}",request.getRequestURL());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.debug("posthandle method called. handler = {}",handler);
		log.debug("URL = {}",request.getRequestURL());
		
		if(modelAndView!=null) {
			log.debug("model = {}",modelAndView.getModel());
			log.debug("view = {}",modelAndView.getViewName());
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		log.debug("afterCompletion method called. handler = {}",handler);
		log.debug("URL = {}",request.getRequestURL());
	}
	
	

}
