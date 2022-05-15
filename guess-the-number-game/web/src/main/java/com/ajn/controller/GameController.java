package com.ajn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ajn.service.GameService;
import com.ajn.util.AttributeNames;
import com.ajn.util.GameMappings;
import com.ajn.util.ViewNames;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GameController {

	//== fields == 
	GameService gameService;

	// == constructors ==
	@Autowired
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}
	
	//== model Attribute ==
//	@ModelAttribute  //commented the model attribute, since game-over.html already has a model attribute "resultMessage"
					// from request method displayPlayPage(..)	
//	public String resultMessage() {
//		return gameService.getResultMessage();
//	}
//	
	
	// == Request methods == 
	@GetMapping(GameMappings.PLAY)
	public String displayPlayPage(Model model) {
		model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMaessage());
		model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
		log.info("model = {}",model);
		
		if(gameService.isGameOver()) {
			return ViewNames.GAME_OVER;
		}
		
			return ViewNames.PLAY;
	}
	
	@PostMapping(GameMappings.PLAY)
	public String processMessage(@RequestParam int guess) {
		
		log.info("guess= {}",guess);
		
		gameService.checkGuess(guess);
		
		return GameMappings.REDIRECT_PLAY;
	}
	
	@GetMapping(GameMappings.RESTART)
	public String restart() {
		gameService.reset();
		return GameMappings.REDIRECT_PLAY;
	}
	
//	@GetMapping(GameMappings.HOME)
//	public String home() {
//
//		return ViewNames.HOME;
//	}
	
}
