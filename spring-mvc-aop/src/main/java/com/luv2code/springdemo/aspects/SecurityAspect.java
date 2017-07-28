package com.luv2code.springdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class SecurityAspect {

    private static Logger LOG = Logger.getLogger(
        LoggingAspect.class.getName()
    );

    @Before("com.luv2code.springdemo.aspects.PointcutDeclarations.forDaoPackage()")
    public void securityAdvice (
        JoinPoint joinPoint
    ) {
        String method = joinPoint.getSignature().toShortString();
        LOG.info("Doing security things in advice for method (" + method + ")");
    }
}
