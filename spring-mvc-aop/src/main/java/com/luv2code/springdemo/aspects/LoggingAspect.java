package com.luv2code.springdemo.aspects;

import com.luv2code.springdemo.entities.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Before("com.luv2code.springdemo.aspects.PointcutDeclarations.forDaoPackage()")
    public void beforeAddingMethodsInPackage(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Doing logging things in advice: " + signature);

        Object[] args = joinPoint.getArgs();

        for (Object tempArg: args) {
            if (tempArg instanceof Account) {
                Account account = (Account) tempArg;

                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            } else {
                System.out.println("ARG: " + tempArg);
            }
        }
    }

    // @Before(
    //     // "execution(public void addAccount())" // ALL methods of addAccount
    //     "execution(public void add*())" // ANY add method
    //     // "execution(public void com.luv2code.springdemo.services.AccountServiceImpl.addAccount())" // Just AccountServiceImpl
    // )
    // public void beforeAddingAccountAdvice() {
    //     System.out.println("Executing @Before advice");
    // }
    //
    // @Before(
    //     "execution(public boolean com.luv2code.springdemo.dao.AccountDaoImpl.*())"
    // )
    // public void beforeReturningBooleanAdvice() {
    //     System.out.println("Executing @Before advice on any method that returns a boolean");
    // }
    //
    // @Before(
    //     "execution(public void addAccount(com.luv2code.springdemo.entities.Account))"
    // )
    // public void beforeAddingAccountAdviceQualified() {
    //     System.out.println("Executing @Before advice on any addAccount method that accepts Account object");
    // }

    //
    // @Before("getter()")
    // public void beforeAnyGet() {
    //     System.out.println("Executing @Before advice on any get method");
    // }
    //
    //
    // @Before("setter()")
    // public void beforeAnySet() {
    //     System.out.println("Executing @Before advice on any set method");
    // }
    //
    // @Before("forDaoPackage() && !(getter() || setter())")
    // public void beforeNotGetterSetterDao() {
    //     System.out.println("Executing @Before advice on any method in DAO that is not getter or setter");
    // }
}
