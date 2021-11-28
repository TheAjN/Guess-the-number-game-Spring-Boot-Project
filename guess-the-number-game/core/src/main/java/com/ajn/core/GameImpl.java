package com.ajn.core;

import javax.annotation.PostConstruct;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Getter
public class GameImpl implements Game {

	// == constants ==
//	private static final Logger LOGGER = LoggerFactory.getLogger(GameImpl.class);

	// == fields ==
	@Getter(AccessLevel.NONE)
	private final NumberGenerator numberGenerator;
	
	private final int guessCount; // how many times the player can guess the number before the game is over
	private int number;

	private int smallest;
	private int biggest;
	private int remainingGuesses;
	private boolean validNumberRange = true;
	
	@Setter
	private int guess;
	
	// == constructor == 
	@Autowired
	public GameImpl(NumberGenerator numberGenerator,@GuessCount int guessCount) {  // for constructor dependency injection
		this.numberGenerator = numberGenerator;
		this.guessCount= guessCount;
	}

	// == init ==
	@PostConstruct    //This method will be called once the GameImpl bean is created (Invoking init method in logs)
	@Override
	public void reset() {

		smallest = numberGenerator.getMinNumber();
		guess =0;
		remainingGuesses = guessCount;
		biggest = numberGenerator.getMaxNumber();
		number = numberGenerator.next();
		log.debug("The number is {}", number); //this will only appear if Game is declared in main via context
	}

	@PreDestroy
	public void preDestroy() {
		log.info("in Game preDestroy()");
	}
	
	
	// == public methods ==
//	 public void setNumberGenerator(NumberGenerator numberGenerator) {
//		this.numberGenerator = numberGenerator; //initialization is done in bean.xml (setter DI)
//	}
//	


	@Override
	public void check() {
		
		checkValidNumberRange();
		
		if(validNumberRange) {
			if(guess>number) {
				biggest = guess - 1;
			}
			
			if(guess<number) {
				smallest = guess + 1;
			}
		}

		remainingGuesses--;
		
	}


	@Override
	public boolean isGameWon() {
		// TODO Auto-generated method stub
		return guess == number;
	}

	@Override
	public boolean isGameLost() {
		// TODO Auto-generated method stub
		return ((!isGameWon()) && (remainingGuesses <= 0));
	}

	
	// == private methods == 
	
	private void checkValidNumberRange() {
		validNumberRange = (guess>=smallest) && (guess<=biggest);
	}
	
	
}
