package com.luxoft.demoide.auth;

import com.luxoft.demoide.MyScope;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@MyScope
@Order(2)
class LdapProviderExternalImpl implements LdapProvider {

    public LdapProviderExternalImpl() {
        System.out.println("Ex LDAP");
    }

    @Override
    public boolean hasAccount(String name) {
        return true;
    }
}
