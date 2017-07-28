package com.luv2code.springdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class SecurityAspect {

    @Before("com.luv2code.springdemo.aspects.PointcutDeclarations.forDaoPackage()")
    public void securityAdvice () {
        System.out.println("Doing security things in advice");
    }
}
