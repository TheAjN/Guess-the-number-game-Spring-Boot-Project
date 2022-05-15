package com.ajn.core.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @After("execution(* com.ajn.core.MessageGeneratorImpl.getMainMessage())")
    public void callingAspect(){
        log.info("Aspect Component called");
    }
}
