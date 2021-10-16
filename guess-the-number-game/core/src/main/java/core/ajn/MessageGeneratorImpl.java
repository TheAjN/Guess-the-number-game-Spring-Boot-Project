package core.ajn;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



public class MessageGeneratorImpl implements MessageGenerator{
	
	// == constants == 
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageGeneratorImpl.class);
	
	// == fields ==
	@Autowired
	private Game game;
	private int guessCount=10;
	
	// == init methods == 
	@PostConstruct
	public void postConstruct() {
	
	//	game.reset();	
		LOGGER.info("Game {}",game);
	}

	
	// == public methods == 
	@Override
	public String getMainMessage() {
		// TODO Auto-generated method stub
		return "getMainMessage";
	}

	@Override
	public String getResultMessage() {
		// TODO Auto-generated method stub
		return "getResultMessage";
	}

	
}
