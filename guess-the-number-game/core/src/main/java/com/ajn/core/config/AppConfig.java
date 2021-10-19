package com.ajn.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.ajn.core.Game;
import com.ajn.core.GameImpl;
import com.ajn.core.MessageGenerator;
import com.ajn.core.MessageGeneratorImpl;
import com.ajn.core.NumberGenerator;
import com.ajn.core.NumberGeneratorImpl;

//we are not using beans.xml anymore

// @Configuration class acts as a representative of the Spring Container

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "com.ajn")  //acts as <context:component-scan base-package="core.ajn" /> 
public class AppConfig {
	
	
	// == Bean methods == 
	@Bean
	public NumberGenerator numberGenerator() {
		return new NumberGeneratorImpl();
	}

	@Bean
	public Game game() {
		return new GameImpl();
	}
	
	@Bean
	public MessageGenerator messageGenerator() {
		return new MessageGeneratorImpl(game());  //Constructor DI
	}
	
}
