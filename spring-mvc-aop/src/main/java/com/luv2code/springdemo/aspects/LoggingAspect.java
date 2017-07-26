package com.luv2code.springdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before(
        "target(com.luv2code.springdemo.services.AccountServiceImpl)" +
            "&& execution(void addAccount())"
    )
    public void beforeAddingAccountAdvice() {
        System.out.println("Executing @Before advice on AccountServiceImpl addAccount()");
    }
}
