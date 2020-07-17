package com.luxoft.demoide.auth;

import com.luxoft.demoide.MyScope;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MyScope
class LdapProviderExternalImpl implements LdapProvider {

    public LdapProviderExternalImpl() {
        System.out.println("Ex LDAP");
    }

    @Override
    public boolean hasAccount(String name) {
        return true;
    }
}
