package com.luxoft.demoide.auth;

import com.luxoft.demoide.MyScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Lazy
@Configuration
class LdapConfiguration {

    @Bean(name = {"ldap", "autoryzacja-biuro"})
    @MyScope
    public LdapProvider ldapProvider() {
        System.out.println("LDAP");
        return new LdapProviderDummyImpl();
    }

    @Bean
    public List<LdapProvider> providers(List<LdapProvider> providers) {
        return (ArrayList<LdapProvider>) providers.stream()
                .limit(1)
                .collect(Collectors.toList());
    }
}
