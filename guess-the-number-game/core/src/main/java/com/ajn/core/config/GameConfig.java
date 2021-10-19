package com.ajn.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ajn.core.GuessCount;
import com.ajn.core.MaxNumber;

@Configuration
public class GameConfig {

	private int maxNumber = 25;
	private int guessCount = 5;

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
	
}
