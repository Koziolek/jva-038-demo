package com.luxoft.demoide.auth;

import org.springframework.stereotype.Component;

@Component
class LdapDummyProviderProvider implements LdapProviderProvider<LdapProvider> {

    @Override
    public LdapProvider get() {
        return new LdapProviderImpl();
    }
}
