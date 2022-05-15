package com.ajn.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import com.ajn.core.GuessCount;
import com.ajn.core.MaxNumber;
import com.ajn.core.MinNumber;

@Configuration
@ComponentScan(basePackages = "com.ajn")
@PropertySource("classpath:config/game.properties")
@EnableAspectJAutoProxy
public class GameConfig {

	@Value("${game.maxNumber:20}")
	private int maxNumber;
	
	@Value("${game.guessCount:4}")
	private int guessCount;
	
	@Value("${game.minNumber:5}")
	private int minNumber;

	@Bean
	@MaxNumber
	public int MaxNumber() {
		return maxNumber;
	}

	@Bean
	@GuessCount
	public int GuessCount() {
		return guessCount;
	}
	
	@Bean
	@MinNumber
	public int MinNumber() {
		return minNumber;
	}
	
}
