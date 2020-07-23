package com.luxoft.demoide.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclarePrecedence;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
class MyAspect {

    @Around("execution(* com.luxoft.demoide.auth.LdapProvider.*(..))")
    @Order(1)
    public Object doLogging(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Logging");
        return pjp.proceed();
    }

    @Around(value = "target(com.luxoft.demoide.auth.LdapProvider)")
    @Order(2)
    public Object doCaching(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Caching");
        return pjp.proceed();
    }
}
