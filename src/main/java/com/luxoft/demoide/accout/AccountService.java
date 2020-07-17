package com.luxoft.demoide.accout;

import com.luxoft.demoide.Customer;
import com.luxoft.demoide.CustomerRepository;
import com.luxoft.demoide.MyScope;
import com.luxoft.demoide.auth.LdapProvider;
import com.luxoft.demoide.auth.LdapProviderProvider;
import com.luxoft.demoide.mailing.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
class AccountService {

    private final CustomerRepository repository;

    private final LdapProvider ldapProvider;

    @Autowired(required = false)
    private MailingService mailingService;

    public AccountService(CustomerRepository repository,
                          LdapProviderProvider<LdapProvider> ldapProvider,
                          Map<String, LdapProvider> providers) {
        this.repository = repository;
        this.ldapProvider = ldapProvider.get();
        System.out.println(providers.getClass());
        providers.keySet().forEach(System.out::println);
    }

    public Customer addNewCustomer(String name) {
        if (ldapProvider != null && !ldapProvider.hasAccount(name))
            throw new IllegalStateException("No Account");
        Customer customer = repository.save(new Customer(name, null));
        if (mailingService != null) {
            mailingService.register(customer);
        }
        return customer;
    }

    public Customer updateCustomer(Customer changeset, long id) {
        Customer current = repository.getOne(id);
        Customer updated = current.applyChangeset(changeset);
        return repository.save(updated);
    }

    public void giveBonus(long id) {
        //...
        repository.getOne(id);
        //...
        return;
    }

    public boolean verify(long id) {
        Customer customer = repository.getOne(id);
        return ldapProvider.hasAccount(customer.getName());
    }

}
