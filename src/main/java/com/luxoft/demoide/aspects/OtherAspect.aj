package com.luxoft.demoide.aspects;

public aspect OtherAspect {
    pointcut all(): execution(* com.luxoft.demoide.auth.LdapProvider.*(..));

    before(): all() {
        System.out.println("BEFORE");
    }
}
