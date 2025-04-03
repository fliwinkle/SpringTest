package com.example.st.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.example.st.context.CommonContext;
import com.example.st.context.CommonContextHolder;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LogAspect {
	
	@Value(value = "${msName}")
	String msName;
	@Value(value = "${cmpName}")
	String cmpName;
	
    // com.aop.controller 이하 패키지의 모든 클래스 이하 모든 메서드에 적용
    @Pointcut("execution(* com.example.demo.controller..*.*(..))")
    private void controllerCut(){}
    // Pointcut에 의해 필터링된 경로로 들어오는 경우 메서드 호출 전에 적용
    @Before("controllerCut()")
    public void beforeParameterLog(JoinPoint joinPoint) {
    	CommonContext commonContext = CommonContextHolder.get();
    	String traceId = commonContext.getTraceId();
    	String userId = commonContext.getUserId();
    	String apiId = "";
    	
        // 메서드 정보 받아오기
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        //spring doc 에 들어갈 apiId 어노테이션 파싱
    	if(!ObjectUtils.isEmpty(method.getAnnotation(Operation.class))) {
    		apiId = method.getAnnotation(Operation.class).summary();
    	}
        log.info("======= METHOD START = {} =======", method.getName());
        
        MDC.put("traceId", traceId);
    	MDC.put("userId", userId);
    	MDC.put("msName", msName);
    	MDC.put("cmpName", cmpName);
    	MDC.put("apiId", apiId);
    	
		// 파라미터 받아오기 
		Object[] args = joinPoint.getArgs(); 
		if (args.length <= 0) { 
			 log.info("no parameter"); 
			 for (Object arg : args) {
				 log.info("parameter type = {}", arg.getClass().getSimpleName());
				 log.info("parameter value = {}", arg); 
			 }
		 }
    }
    @After("controllerCut()")
    public void afterParameterLog(JoinPoint joinPoint) {
    	// 메서드 정보 받아오기
    	Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
    	
    	log.info("======= METHOD END = {} =======", method.getName());
    	
    	CommonContextHolder.clear();    	
    }
}
