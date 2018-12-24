package com.sssm.springaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionTimeCalculationAspect {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	// ProceedingJoinPoint allows you to continue execution of a method - intercept a method and allow to proceed
	@Around(value = "execution(* com.sssm.springaop.service.*.*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		Long startTime = System.currentTimeMillis();
		Object value = jp.proceed();
		Long endTime = System.currentTimeMillis();
		LOGGER.info("==== Around ====");
		LOGGER.info("Time taken by {} is {} ms", jp, (endTime - startTime));
		return value;
	}
	
	// if method return type is void as below, then null would be returned all the way back - hence need to make it Object - check above
	/*@Around(value = "execution(* com.sssm.springaop.service.*.*(..))")
	public void around(ProceedingJoinPoint jp) throws Throwable {
		Long startTime = System.currentTimeMillis();
		jp.proceed();
		Long endTime = System.currentTimeMillis();
		LOGGER.info("==== Around ====");
		LOGGER.info("Time taken by {} is {} ms", jp, (endTime - startTime));
		LOGGER.info("\n");
	}*/

}
