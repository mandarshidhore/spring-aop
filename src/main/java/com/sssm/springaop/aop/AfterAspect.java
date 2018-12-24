package com.sssm.springaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	// method name is not really important, but same as annotation here
	// either of @AfterReturning annotation below works - first is explicit expression and second is configuration where this is defined at one place for reuse - prefer second over first
	//@AfterReturning(value = "execution(* com.sssm.springaop.dao.*.*(..))", returning = "result")
	@AfterReturning(value = "com.sssm.springaop.aop.CommonJoinPointConfig.dataLayerPointCutExecution()", returning = "result")
	public void afterReturning(JoinPoint jp, Object result) {
		LOGGER.info("#### After Dao ####");
		LOGGER.info("{} returned value {}", jp, result);
	}

	// to test this method, uncomment first line in method getData() in Dao2.java
	@AfterThrowing(value = "execution(* com.sssm.springaop.dao.*.*(..))", throwing = "exception")
	public void afterThrowing(JoinPoint jp, Object exception) {
		LOGGER.info("#### After Throwing Exception ####");
		LOGGER.info("{} threw exception {}", jp, exception);
	}
	
	// the last annotation is @After which is used common for both happy path and exception scenarios - it does not take second argument of Object
	@After(value = "com.sssm.springaop.aop.CommonJoinPointConfig.TrackAnnotationPointCutExecution()")
	public void after(JoinPoint jp) {
		LOGGER.info("#### After Tracking Annotation ####");
		LOGGER.info("{} returned value {}", jp);
	}

}
