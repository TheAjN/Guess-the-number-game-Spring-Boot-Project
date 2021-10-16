package core.ajn;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class CheckLogs {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CheckLogs.class);
	
//	private static final String CONFIG_LOCATION = "beans.xml";
	
	public static void main(String[] args) {
		LOGGER.debug("Test debug");
		LOGGER.info("Test INFO");
		
		
		//create context (Container)
	ConfigurableApplicationContext context  = new AnnotationConfigApplicationContext(AppConfig.class);
//		= new ClassPathXmlApplicationContext(CONFIG_LOCATION); //This is the container where it calls "beans.xml" 
		
		//Get numberGenerator bean from context
		NumberGenerator numberGenerator 
		= context.getBean("numberGenerator", NumberGenerator.class); // returns an instance of a numberGenerator, by 
																//detecting the ID "numberGenerator", and the .class interface
																//is of the instance implemented by NumberGeneratorImpl class
		
		//call method next() to get a random number
		int number = numberGenerator.next();
		
		//log generated number
		LOGGER.info("number {}",number);  //the "{}" (message formatter) acts as a placeholder for the value "number"
											//this type of syntax comes from slf4j package
										//why "{}" and not concat "+"? because even if the logging level is off
								//concating will slow down the application. 
						//This type of logging is also called parametrised logging
		
		
		//get Game bean from context
		Game game = context.getBean(Game.class);
		
//		//call reset method
//		game.reset();   
		
		//closing the context 
		context.close();
		
		//NOTE - to get proper logging information, please change the spring.framework 
		// (spring context) version to 5.0.5.RELEASE
		
		// OR  change the level of spring.framework in logback.xml to TRACE
		
		
		
	}

}
