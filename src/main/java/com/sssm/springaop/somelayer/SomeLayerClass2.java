package com.sssm.springaop.somelayer;

import org.springframework.stereotype.Service;

@Service
public class SomeLayerClass2 {
	
	@TrackThisAnnotation
	public String doSomething() {
		return "something2";
	}

}
