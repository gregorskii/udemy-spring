package com.luv2code.springdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private static Logger LOG = Logger.getLogger(
        LoggingAspect.class.getName()
    );

    @Before("com.luv2code.springdemo.aspects.PointcutDeclarations.forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();

        LOG.info(String.format("----> in @Before: calling %s", method));

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            LOG.info(String.format("----> arg: %s", arg));
        }
    }

    @AfterReturning(
        pointcut = "com.luv2code.springdemo.aspects.PointcutDeclarations.forAppFlow()",
        returning = "result"
    )
    public void after(
        JoinPoint joinPoint,
        Object result
    ) {
        String method = joinPoint.getSignature().toShortString();

        LOG.info(String.format("----> in @AfterReturning: calling %s", method));
        LOG.info(String.format("----> result %s", result.toString()));
    }
}
