package com.sssm.springaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// combination of PointCut and advice below is called an Aspect
@Aspect
@Configuration
public class BeforeAspect {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	// @Before executes before the method call actually happens
	// value inside @Before annotation is called a PointCut
	// PointCut is an expression that defines what kind of methods are being intercepted
	// first asterix indicates any return type
	// second asterix indicates any class inside specified package
	// third asterix indicates any method
	// (..) indicates any argument type(s)
	// JoinPoint gives details - JoinPoint is a specific interception of a method call
	// Weaving - process where this whole Aspect gets woven around your code and Weaver does that
	@Before("execution(* com.sssm.springaop.service.*.*(..))")
	public void beforeService(JoinPoint jp) {
		// the logic inside intercepted method is called an Advice
		// Advice
		LOGGER.info("---> before invoking class(es) inside service");
		LOGGER.info("Intercepted method call {}", jp);
	}
	
	@Before("com.sssm.springaop.aop.CommonJoinPointConfig.beanStartingWithSomeLayerClassPointCutExecution()")
	public void beforeSomeLayerClass(JoinPoint jp) {
		LOGGER.info("---> before invoking class(es) inside somelayer");
		LOGGER.info("Intercepted method call {}", jp);
	}

}
