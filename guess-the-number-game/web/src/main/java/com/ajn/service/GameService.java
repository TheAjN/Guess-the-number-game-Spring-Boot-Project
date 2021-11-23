package com.ajn.service;

public interface GameService {
	
	boolean isGameOver();
	String getMainMaessage();
	String getResultMessage();
	void checkGuess(int guess);
	void reset();
}
