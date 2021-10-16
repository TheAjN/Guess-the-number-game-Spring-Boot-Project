package core.ajn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//we are not using beans.xml anymore

// @Configuration class acts as a representative of the Spring Container

@Configuration
@ComponentScan(basePackages = "core.ajn")  //acts as <context:component-scan base-package="core.ajn" /> 
public class AppConfig {
	
	
	// == Bean methods == 
	@Bean
	public NumberGenerator numberGenerator() {
		return new NumberGeneratorImpl();
	}

	@Bean
	public Game game() {
		return new GameImpl();
	}
	
}
