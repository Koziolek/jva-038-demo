package com.luxoft.demoide.auth;

import java.time.LocalDateTime;

class LdapProviderImpl implements LdapProvider {

    public LdapProviderImpl() {
        System.out.println(LocalDateTime.now());
    }
}
