package com.ajn.core;

import javax.annotation.PostConstruct;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class GameImpl implements Game {

	// == constants ==
	private static final Logger LOGGER = LoggerFactory.getLogger(GameImpl.class);

	// == fields ==
	@Autowired
	private NumberGenerator numberGenerator;
	private int guessCount = 10; // how many times the player can guess the number before the game is over
	private int number;
	private int guess;
	private int smallest;
	private int biggest;
	private int remainingGuesses;
	private boolean validNumberRange = true;

	
	// == constructor == 
//	public GameImpl(NumberGenerator numberGenerator) {  // for constructor dependency injection
//		this.numberGenerator = numberGenerator;
//	}

	// == init ==
	@PostConstruct    //This method will be called once the GameImpl bean is created
	@Override
	public void reset() {

		smallest = 0;
		guess = 0;
		remainingGuesses = guessCount;
		biggest = numberGenerator.getMaxNumber();
		number = numberGenerator.next();
		LOGGER.debug("The number is {}", number);
	}

	@PreDestroy
	public void preDestroy() {
		LOGGER.info("in Game preDestroy()");
	}
	
	
	// == public methods ==
//	 public void setNumberGenerator(NumberGenerator numberGenerator) {
//		this.numberGenerator = numberGenerator; //initialization is done in bean.xml (setter DI)
//	}
//	



	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return number;
	}

	@Override
	public int getGuess() {
		// TODO Auto-generated method stub
		return guess;
	}

	@Override
	public void setGuess(int guess) {
		// TODO Auto-generated method stub
		this.guess = guess;
	}

	@Override
	public int getSmallest() {
		// TODO Auto-generated method stub
		return smallest;
	}

	@Override
	public int getBiggest() {
		// TODO Auto-generated method stub
		return biggest;
	}

	@Override
	public int getRemainingGuesses() {
		// TODO Auto-generated method stub
		return remainingGuesses;
	}

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
	public boolean isValidNumberRange() {

		return validNumberRange;
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
