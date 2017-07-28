package com.luv2code.springdemo.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutDeclarations {

    @Pointcut("execution(* com.luv2code.springdemo.controllers.*.*(..))")
    public void forControllerPackage() { }

    @Pointcut("execution(* com.luv2code.springdemo.services.*.*(..))")
    public void forServicePackage() { }

    @Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
    public void forDaoPackage() { }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    public void forAppFlow() { }
}
