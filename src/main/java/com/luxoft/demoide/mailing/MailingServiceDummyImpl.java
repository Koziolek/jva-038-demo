package com.luxoft.demoide.mailing;

import com.luxoft.demoide.Customer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Primary
@Component(MailingService.dummy)
class MailingServiceDummyImpl implements MailingService {

    @Override
    public Customer register(Customer customer) {
        return customer;
    }

    @Override
    public Customer unregister(Customer customer) {
        return customer;
    }

    @Override
    public List<Result> send(String message) {
        return Collections.emptyList();
    }
}
