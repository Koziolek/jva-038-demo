package com.luxoft.demoide.accout;

import com.luxoft.demoide.Customer;
import com.luxoft.demoide.CustomerRepository;
import com.luxoft.demoide.MyScope;
import com.luxoft.demoide.auth.LdapProvider;
import com.luxoft.demoide.auth.LdapProviderProvider;
import com.luxoft.demoide.mailing.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Supplier;

@Component
class AccountService {

    private final CustomerRepository repository;

    private final LdapProvider ldapProvider;

    private final ApplicationContext context;

    @Autowired(required = false)
    private MailingService mailingService;

    public AccountService(CustomerRepository repository,
                          LdapProviderProvider<LdapProvider> ldapProvider,
                          @MyScope List<LdapProvider> providers,
                          ApplicationContext context) {
        this.repository = repository;
        this.ldapProvider = ldapProvider.get();
        this.context = context;
        System.out.println(providers.getClass());
        providers.forEach(System.out::println);
    }

    public Customer addNewCustomer(String name) {
        if (ldapProvider != null && !ldapProvider.hasAccount(name))
            throw new IllegalStateException("No Account");
        Customer customer = repository.save(new Customer(name, null));
        if (mailingService != null) {
            new TransactionSupport().doInTransaction(()->
                 mailingService.register(customer)
            );
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
        Customer customer = repository.getOne(id);
        AccountService self = context.getBean(this.getClass());

        self.calculateBonus(customer);
        return;
    }

    private void calculateBonus(Customer customer) {
        System.out.println("Calculate");
    }

    public boolean verify(long id) {
        Customer customer = repository.getOne(id);
        return ldapProvider.hasAccount(customer.getName());
    }

}


class TransactionSupport {

    public <T> T doInTransaction(Supplier<T> f) {
        return f.get();
    }
}