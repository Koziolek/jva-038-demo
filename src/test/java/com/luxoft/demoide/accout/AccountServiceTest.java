package com.luxoft.demoide.accout;

import com.luxoft.demoide.auth.LdapProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.NONE
)
class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @Autowired
    LdapProvider ldapProvider;

//    @MockBean
//    LdapProvider ldapProvider;

    @Test
    void addNewCustomer() {
//        given(
//                ldapProvider.hasAccount(any())
//        ).willReturn(true);

        var jan = accountService.addNewCustomer("Jan");
        Assertions.assertEquals(jan.getName(), "Jan");

//        verify(ldapProvider, atLeastOnce()).hasAccount("Jan");

    }
}

@Configuration
class TestConfig {
    @Bean
    public LdapProvider ldapProvider(){
        return new LdapProvider() {
            @Override
            public boolean hasAccount(String name) {
                return true;
            }
        };
    }
}








