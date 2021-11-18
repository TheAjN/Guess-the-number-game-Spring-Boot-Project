package com.ajn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class WebMain
{
    public static void main( String[] args )
    {
    	log.info("Web Main class started");
        SpringApplication.run(WebMain.class, args);
    }
}
