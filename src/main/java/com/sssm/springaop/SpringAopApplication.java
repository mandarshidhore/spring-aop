package com.sssm.springaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sssm.springaop.service.Business1;
import com.sssm.springaop.service.Business2;
import com.sssm.springaop.somelayer.SomeLayerClass1;
import com.sssm.springaop.somelayer.SomeLayerClass2;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(SpringAopApplication.class);

	@Autowired
	Business1 business1;

	@Autowired
	Business2 business2;
	
	@Autowired
	SomeLayerClass1 someLayerClass1;
	
	@Autowired
	SomeLayerClass2 someLayerClass2;

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info(business1.getData() + "\n");
		LOGGER.info(business2.getData() + "\n");
		try {
			LOGGER.info(business2.getExceptionDuringDataRetrieve() + "\n");
		} catch (Exception e) {
			LOGGER.error("^^^^ Caught Exception ^^^^" + "\n");
		}
		LOGGER.info(someLayerClass1.doSomething() + "\n");
		LOGGER.info(someLayerClass2.doSomething() + "\n");
	}

}
