package com.ajn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.ajn.interseptor.RequestInterseptor;
import com.ajn.util.ViewNames;


@Configuration
public class WebConfig implements WebMvcConfigurer{ //to register
	
	
	// == bean methods == 
	@Bean
	public LocaleResolver localeResolver() { //localeResolver, NOT LocaleResolver()
		return new SessionLocaleResolver(); //This bean/method resolves locales beased on request/response/cookies etc
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {  // to run the homepage when running the code first time
		registry.addViewController("/").setViewName(ViewNames.HOME);
	//	registry.addViewController("home").setViewName(ViewNames.HOME); fffef
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestInterseptor());
		//The interceptor registry is a class that helps with configuring
		//a list of mapped interceptors. The method addinterceptors()
		//is from the interface WebMVCconfigurer that our class is implementing, 
		//we're also overriding the method as it's used to add interceptors for pre-processing
		//in simple words - it means we have to register the Interceptor that we created
		
		
	//	LocaleChangeInterceptor localeChangeInterceptor =
	//			new LocaleChangeInterceptor();	//LocaleChangeInterceptor is used to set/change locale on every request
	//	localeChangeInterceptor.setParamName("lang");	//sets the RequestParam name to "lang"
		
		
		registry.addInterceptor(new LocaleChangeInterceptor()); //registering localeChangeInterceptor inside the registry
	}  
	
	
	
}
