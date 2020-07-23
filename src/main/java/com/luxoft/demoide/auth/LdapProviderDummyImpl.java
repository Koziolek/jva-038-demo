package com.luxoft.demoide.auth;

import com.luxoft.demoide.MyScope;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Primary
@Component
@MyScope
@Order(3)
class LdapProviderDummyImpl implements LdapProvider {

    public LdapProviderDummyImpl() {
        System.out.println("Dummy LDAP");
    }

    @Override
    public boolean hasAccount(String name) {
        return true;
    }
}
