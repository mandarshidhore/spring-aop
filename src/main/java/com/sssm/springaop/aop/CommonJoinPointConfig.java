package com.sssm.springaop.aop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

	@Pointcut("execution(* com.sssm.springaop.dao.*.*(..))")
	public void dataLayerPointCutExecution() {

	}

	// only track one particular class
	@Pointcut("execution(* com.sssm.springaop.somelayer.SomeLayerClass1.*(..))")
	public void beanStartingWithSomeLayerClassPointCutExecution() {

	}

	@Pointcut("@annotation(com.sssm.springaop.somelayer.TrackThisAnnotation)")
	public void TrackAnnotationPointCutExecution() {

	}

}
