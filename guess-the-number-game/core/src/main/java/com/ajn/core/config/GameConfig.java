package com.ajn.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ajn.core.GuessCount;
import com.ajn.core.MaxNumber;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

	@Value("${game.maxNumber:20}")
	private int maxNumber;
	
	@Value("${game.guessCount:4}")
	private int guessCount;

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
