package com.sssm.springaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// combination of point-cut and advice below is called an Aspect
@Aspect
@Configuration
public class BeforeAspect {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	// @Before executes before the method call actually happens
	// value inside @Before annotation is called a PointCut
	// point-cut is an expression that defines what kind of methods are being intercepted
	// first asterix indicates any return type
	// second asterix indicates any class
	// third asterix indicates any method - (..) indicates any return type
	// add JoinPoint for details - JoinPoint is a specific interception of a method call
	// Weaving & Weaver - process where this whole Aspect gets weaved around your code and Weaver does that
	@Before("execution(* com.sssm.springaop.service.*.*(..))")
	public void beforeService(JoinPoint jp) {
		// the logic inside intercepted method is called an Advice
		// Advice
		LOGGER.info("---- Before Service ----");
		LOGGER.info("Intercepted method call {}", jp);
	}
	
	@Before("com.sssm.springaop.aop.CommonJoinPointConfig.beanStartingWithSomeLayerClassPointCutExecution()")
	public void beforeSomeLayerClass(JoinPoint jp) {
		LOGGER.info("---- Before Some Layer ----");
		LOGGER.info("Intercepted method call {}", jp);
	}

}
