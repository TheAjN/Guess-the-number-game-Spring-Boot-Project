package com.ajn.console;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ajn.core.Game;
import com.ajn.core.MessageGenerator;

@Component //Since @Bean method is not created for this class, we need @Component for the container to scan this class
public class ConsoleNumberGuess /*implements ApplicationListener<ContextRefreshedEvent>*/  {
	
	//== constants == 
	public static final Logger LOGGER = LoggerFactory.getLogger(ConsoleNumberGuess.class);

	
	//@Override
	//public void onApplicationEvent(ContextRefreshedEvent event) {
	//	
	//	LOGGER.info("start() --> Container ready for use.");
	//	
	//}
	
	// == fields ==
	//@Autowired //to inject the Game bean into this object
	private final Game game;
	
	private final MessageGenerator messageGenerator;
	
	// == constructor == 
	
	@Autowired
	public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
		this.game = game;
		this.messageGenerator = messageGenerator;
	}
	

	// == events ==
	@EventListener(ContextRefreshedEvent.class)
	public void start() {

		LOGGER.info("start() --> Container ready for use.");
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println(messageGenerator.getMainMessage());
			System.out.println(messageGenerator.getResultMessage());
			
			int guess = scanner.nextInt();
			scanner.nextLine();
			game.setGuess(guess);
			game.check();
			
			
			if(game.isGameWon() || game.isGameLost()) {
				System.out.println(messageGenerator.getResultMessage());
				
				System.out.println("Play again? Y/N");
				String s = scanner.nextLine().trim();
				if(!s.equalsIgnoreCase("y")) {
					break;			
				}
				game.reset();
			}
			
		}
		
	}


}
