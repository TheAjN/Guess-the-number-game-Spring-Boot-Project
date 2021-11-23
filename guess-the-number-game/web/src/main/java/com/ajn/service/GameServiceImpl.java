package com.ajn.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajn.core.Game;
import com.ajn.core.MessageGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GameServiceImpl implements GameService{

	// == fields == 
	private final Game Game;			//Always mention final in any ServiceImpl class, to prevent change/iteration of value
	private final MessageGenerator MessageGenerator;
	
	
	// == constructors == 
	@Autowired
	public GameServiceImpl(Game game, MessageGenerator messageGenerator) {
		this.Game = game;
		MessageGenerator = messageGenerator;
	}
	
	//== init method == 

	@PostConstruct
	public void Init() {
		log.info("number = {}",Game.getNumber());
		log.info("Get Main Message =  {} to be called and guess count = {}",MessageGenerator.getMainMessage(),Game.getGuessCount());
	}

	
	// == public methods == 
	@Override
	public boolean isGameOver() {
		
		if(Game.isGameLost() || Game.isGameWon()) {
			return true;
		}
		return false;
	}

	@Override
	public String getMainMaessage() {
		
		return MessageGenerator.getMainMessage();
	}

	@Override
	public String getResultMessage() {
		
		return MessageGenerator.getResultMessage();
	}

	@Override
	public void checkGuess(int guess) {
		Game.setGuess(guess);
		Game.check();
		
	}

	@Override
	public void reset() {
		Game.reset();
		
	}

	
}
