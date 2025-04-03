package com.example.st.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.st.context.CommonContext;
import com.example.st.context.CommonContextHolder;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class CommonDataAspect {

	//@Before("execution(* com.mirae.micros..application.controller.*Controller.*(..))")
	@Before("execution(* com.example.demo.controller.*Controller.*(..))")
	public void setCustomContext() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String userId = request.getHeader("userId");
		String syncId = request.getHeader("syncId");
		String channel = request.getHeader("channel");
		String traceId = request.getHeader("traceId");
		
		CommonContext commonContext = CommonContextHolder.get();
	}
	
}
