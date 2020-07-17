package com.luxoft.demoide.mailing;

import com.luxoft.demoide.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class MailingServiceExternalImpl implements MailingService{
    @Override
    public Customer register(Customer customer) {
        return null;
    }

    @Override
    public Customer unregister(Customer customer) {
        return null;
    }

    @Override
    public List<Result> send(String message) {
        return null;
    }
}
