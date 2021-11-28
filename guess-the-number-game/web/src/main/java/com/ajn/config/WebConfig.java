package com.ajn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ajn.util.ViewNames;


@Configuration
public class WebConfig implements WebMvcConfigurer{  // to run the homepage when running the code first time
	

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName(ViewNames.HOME);
	//	registry.addViewController("home").setViewName(ViewNames.HOME);
	}  
	
}
