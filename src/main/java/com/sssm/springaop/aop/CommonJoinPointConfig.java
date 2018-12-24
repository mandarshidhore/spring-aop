package com.sssm.springaop.aop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

	@Pointcut("execution(* com.sssm.springaop.dao.*.*(..))")
	public void dataLayerPointCutExecution() {

	}
	
	@Pointcut("execution(* com.sssm.springaop.somelayer.*.*(..))")
	public void beanStartingWithSomeLayerClassPointCutExecution() {

	}
	
	@Pointcut("@annotation(com.sssm.springaop.somelayer.TrackThisAnnotation)")
	public void TrackAnnotationPointCutExecution() {

	}

}
