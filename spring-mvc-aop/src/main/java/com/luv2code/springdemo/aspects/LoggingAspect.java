package com.luv2code.springdemo.aspects;

import com.luv2code.springdemo.entities.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    private static Logger LOG = Logger.getLogger(
        LoggingAspect.class.getName()
    );

    @Before("com.luv2code.springdemo.aspects.PointcutDeclarations.forDaoPackage()")
    public void beforeMethodsInPackage(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String method = signature.toShortString();

        LOG.info(String.format("Doing logging things in advice: %s for method (%s)", signature, method));

        Object[] args = joinPoint.getArgs();

        for (Object tempArg: args) {
            if (tempArg instanceof Account) {
                Account account = (Account) tempArg;

                LOG.info("Account name: " + account.getName());
                LOG.info("Account level: " + account.getLevel());
            } else {
                LOG.info("ARG: " + tempArg);
            }
        }
    }

    @AfterReturning(
        pointcut="execution(* com.luv2code.springdemo.dao.AccountDaoImpl.findAccounts())",
        returning="results"
    )
    public void afterReturningMethodsInPackage(
        JoinPoint joinPoint,
        List<Account> results
    ) {
        String method = joinPoint.getSignature().toShortString();

        LOG.info(String.format("Doing things after returning in advice for (%s)", method));

        for (Account account : results) {
            LOG.info("Found Account:");
            LOG.info(account.getName());
            LOG.info(account.getLevel());

            // Lets post process..
            // account.setName("Daffy Duck!");
        }
    }

    @AfterThrowing(
        pointcut="execution(* com.luv2code.springdemo.dao.AccountDaoImpl.runException())",
        throwing="ex"
    )
    public void afterThrowingException(
        JoinPoint joinPoint,
        Exception ex
    ) {
        String method = joinPoint.getSignature().toShortString();

        LOG.info(
            String.format("Doing things after throwing in advice for (%s) exception: %s", method, ex.getMessage())
        );
    }

    // After will be called before AfterReturning, AfterThrowing, but always runs regardless of method result
    @After("com.luv2code.springdemo.aspects.PointcutDeclarations.forDaoPackage()")
    public void afterFinally(
        JoinPoint joinPoint
    ) {
        String method = joinPoint.getSignature().toShortString();

        LOG.info("Doing logging things in advice after method (" + method + ")");
    }

    @Around(
        value = "execution(* com.luv2code.springdemo.dao.AccountDaoImpl.doWork())",
        argNames = "proceedingJoinPoint"
    )
    public Object around(
        ProceedingJoinPoint proceedingJoinPoint
    ) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long ending = System.currentTimeMillis();

        long duration = ending - begin;
        
        LOG.info(String.format("Duration of method (%s) is %s", method, duration / 1000.0));

        return result;
    }

    @Around(
        value = "execution(* com.luv2code.springdemo.dao.AccountDaoImpl.runException())",
        argNames = "proceedingJoinPoint"
    )
    public Object aroundThrowingException(
        ProceedingJoinPoint proceedingJoinPoint
    ) throws Throwable {
        Object result;
        String method = proceedingJoinPoint.getSignature().toShortString();

        try {
            LOG.info(
                String.format("Doing things around throwing in advice for (%s)", method)
            );

            result = proceedingJoinPoint.proceed();
        } catch (Exception ex) {
            LOG.info(
                String.format("Catching exception for (%s) exception: %s", method, ex.getMessage())
            );

            // Use with caution
            result = "Nothing exciting here move along!";

            // Rethrow instead of killing...
            // throw ex;
        }

        return result;
    }

    // @Before(
    //     // "execution(public void addAccount())" // ALL methods of addAccount
    //     "execution(public void add*())" // ANY add method
    //     // "execution(public void com.luv2code.springdemo.services.AccountServiceImpl.addAccount())" // Just AccountServiceImpl
    // )
    // public void beforeAddingAccountAdvice() {
    //     LOG.info("Executing @Before advice");
    // }
    //
    // @Before(
    //     "execution(public boolean com.luv2code.springdemo.dao.AccountDaoImpl.*())"
    // )
    // public void beforeReturningBooleanAdvice() {
    //     LOG.info("Executing @Before advice on any method that returns a boolean");
    // }
    //
    // @Before(
    //     "execution(public void addAccount(com.luv2code.springdemo.entities.Account))"
    // )
    // public void beforeAddingAccountAdviceQualified() {
    //     LOG.info("Executing @Before advice on any addAccount method that accepts Account object");
    // }

    //
    // @Before("getter()")
    // public void beforeAnyGet() {
    //     LOG.info("Executing @Before advice on any get method");
    // }
    //
    //
    // @Before("setter()")
    // public void beforeAnySet() {
    //     LOG.info("Executing @Before advice on any set method");
    // }
    //
    // @Before("forDaoPackage() && !(getter() || setter())")
    // public void beforeNotGetterSetterDao() {
    //     LOG.info("Executing @Before advice on any method in DAO that is not getter or setter");
    // }
}
