package com.ajn.core;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator{
	
	// == constants == 
//	private static final Logger LOGGER = LoggerFactory.getLogger(MessageGeneratorImpl.class);
	
	// == fields ==
	private final Game game;;
	
	
	
	// == constructor == 
	@Autowired
	public MessageGeneratorImpl(Game game) {  //using Constructor DI
		this.game = game;
	}


	// == init methods == 
	@PostConstruct
	public void postConstruct() {
	
	//	game.reset();	
		log.info("Game {}",game);
	}

	
	// == public methods == 
	@Override
	public String getMainMessage() {
		
		return "Number is between " + game.getSmallest() 
		+" and "+ game.getBiggest() +". Can you guess it?";
	}

	@Override
	public String getResultMessage() {
		
		if(game.isGameWon()) {
			return "You guessed it! the number was " + game.getNumber();
		}else if(game.isGameLost()) {
			return "You lost! the number was " + game.getNumber();
		}else if(!game.isValidNumberRange()) {
			return "Invalid number range!";
		}else if(game.getRemainingGuesses() == game.getGuessCount()){
			return "What is your first guess?";
		}else {
			String direction = "Lower";
			
			if(game.getGuess() < game.getNumber()) {
				direction = "Higher";
			}
			
			return direction + "! You have " + game.getRemainingGuesses() + " guesses left";
		}
	}

	
}
