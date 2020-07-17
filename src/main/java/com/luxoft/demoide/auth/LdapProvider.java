package com.luxoft.demoide.auth;

public interface LdapProvider {

    default boolean hasAccount(String name){
        return "Janusz".equals(name);
    }
}
