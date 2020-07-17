package com.luxoft.demoide.mailing;

import com.luxoft.demoide.Customer;

import java.util.List;

public interface MailingService {

    class Result{
        Customer customer;
        boolean ok;
    }
    Customer register(Customer customer);

    Customer unregister(Customer customer);

    List<Result> send(String message);
}
