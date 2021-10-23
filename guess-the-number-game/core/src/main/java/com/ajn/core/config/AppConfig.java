package com.ajn.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//we are not using beans.xml anymore

//AppConfig Class is now Obsolete

// @Configuration class acts as a representative of the Spring Container

@Configuration
@Import(GameConfig.class) 
//@ComponentScan(basePackages = "com.ajn")  //acts as <context:component-scan base-package="com.ajn" /> 
public class AppConfig {
	
	
	// == Bean methods == 
//	@Bean
//	public NumberGenerator numberGenerator() {
//		return new NumberGeneratorImpl();
//	}

//	@Bean
//	public Game game() {
//		return new GameImpl();
//	}
//	
//	@Bean
//	public MessageGenerator messageGenerator() {
//		return new MessageGeneratorImpl(game());  //Constructor DI
//	}
	
}
