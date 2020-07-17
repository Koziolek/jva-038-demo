package com.luxoft.demoide.auth;

import com.luxoft.demoide.MyScope;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@MyScope
class LdapProviderDummyImpl implements LdapProvider {

    public LdapProviderDummyImpl() {
        System.out.println("Dummy LDAP");
    }

    @Override
    public boolean hasAccount(String name) {
        return true;
    }
}
