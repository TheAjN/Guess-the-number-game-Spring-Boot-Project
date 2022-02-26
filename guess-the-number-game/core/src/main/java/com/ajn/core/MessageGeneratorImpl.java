package com.ajn.core;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator{
	
	// == constants == 
//	private static final Logger LOGGER = LoggerFactory.getLogger(MessageGeneratorImpl.class);
	private static final String MAIN_MESSAGE= "game.main.message"; // this comes from message.properties in core module
	private static final String WIN_MESSAGE= "game.win"; 
	private static final String LOSE_MESSAGE= "game.lose"; 
	private static final String INVALID_MESSAGE= "game.invalidRange"; 
	private static final String FIRST_GUESS= "game.firstGuess";
	private static final String HIGHER= "game.higher"; 
	private static final String LOWER= "game.lower"; 
	private static final String REMAINING_GUESS= "game.remainingGuess";
	
	// == fields ==
	private final Game game;
	private final MessageSource messageSource; //for resolving/retriving messages from message.properties file(i18n) 
	
	
	
	// == constructor == 
	@Autowired
	public MessageGeneratorImpl(Game game, MessageSource messageSource) {  //using Constructor DI
		this.game = game;
		this.messageSource= messageSource;
	}


	// == init methods == 
	@PostConstruct
	public void postConstruct() {
	
	//	game.reset();	
		log.info("Game {}",game);
	}

	//
	private String getMessage(String code,Object... args) { //Here, "Object... args" means that it can take up multiple objects
		return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
	}

	
	// == public methods == 
	@Override
	public String getMainMessage() {
		
//		return "Number is between " + game.getSmallest() 
//		+" and "+ game.getBiggest() +". Can you guess it?";
		
		return getMessage(MAIN_MESSAGE, game.getSmallest() , game.getBiggest());
	}

	@Override
	public String getResultMessage() {
		
		if(game.isGameWon()) {
			//return "You guessed it! the number was " + game.getNumber();
			
			return getMessage(WIN_MESSAGE, game.getNumber());
		}else if(game.isGameLost()) {
		//	return "You lost! the number was " + game.getNumber();
			return getMessage(LOSE_MESSAGE, game.getNumber());
		}else if(!game.isValidNumberRange()) {
		//	return "Invalid number range!";
			return getMessage(INVALID_MESSAGE);
		}else if(game.getRemainingGuesses() == game.getGuessCount()){
			// return "What is your first guess?";
			return getMessage(FIRST_GUESS);
		}else {
			//String direction = "Lower";
			String direction = getMessage(LOWER);
			
			if(game.getGuess() < game.getNumber()) {
				//direction = "Higher";
				direction = getMessage(HIGHER);
			}
			
			//return direction + "! You have " + game.getRemainingGuesses() + " guesses left";
			return direction + getMessage(REMAINING_GUESS, game.getRemainingGuesses());
		}
	}


}
