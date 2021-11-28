package com.ajn.util.thymeleaf;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DecoupledLogicSetup {
	
	//== fields == 
	private final SpringResourceTemplateResolver resourceTemplateResolver;

	// == constructor == 
	public DecoupledLogicSetup(SpringResourceTemplateResolver resourceTemplateResolver) {
		this.resourceTemplateResolver = resourceTemplateResolver;
	}

	// == init methods == 
	@PostConstruct
	public void init() { // this method will be called only once
		log.info("Thymeleaf dcoupled logic called");
		resourceTemplateResolver.setUseDecoupledLogic(true); // to implement decoupled logic within thymeleaf 
															// (In the recording, Spring Boot version 2.0.3 does not have built in SpringResourceTemplateResolver)
															// therefore, we need to call that instance from thymeleaf and set this Decoupledlogic to true
	}
	

}
