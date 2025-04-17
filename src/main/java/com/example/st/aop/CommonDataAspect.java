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

	@Before("execution(* com.example.st.controller.*Controller.*(..))")
	public void setCustomContext() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String userId = request.getHeader("userId");
		String channel = request.getHeader("channel");
		String traceId = request.getHeader("traceId");
		
		CommonContext commonContext = CommonContextHolder.get();
	}
	
}
