package com.test.departmentProject.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class DepartmentAdvice {
	
Logger log = LoggerFactory.getLogger(DepartmentAdvice.class);
	
	@Pointcut(value="execution(* com.test.departmentProject.*.*.*(..) )")
	public void myPointcut() {
		System.out.println("==============================Im at my point cut ---=================");
	}
	
	
	  @Around("myPointcut()")
	  public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable { 
		  
	  System.out.println("======================3333333========applicationLogger---=================");
	  ObjectMapper mapper = new ObjectMapper(); String
	  methodName = pjp.getSignature().getName(); String className =
	  pjp.getTarget().getClass().toString(); Object[] array = pjp.getArgs();
	  log.info("method invoked " + className + " : " + methodName + "()" +
	  "arguments : " + mapper.writeValueAsString(array)); Object object =
	  pjp.proceed(); log.info(className + " : " + methodName + "()" + "Response : "
	  + mapper.writeValueAsString(object)); return object; }
	 

}
