package com.luv2code.springdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutDeclarations {

    @Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
    public void forDaoPackage() { }

    // @Pointcut("execution(* com.luv2code.springdemo.dao.*.get*(..))")
    // public void getter() { }

    // @Pointcut("execution(* com.luv2code.springdemo.dao.*.set*(..))")
    // public void setter() { }
}
