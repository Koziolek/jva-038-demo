package com.luxoft.demoide.accout;

import com.luxoft.demoide.Customer;
import com.luxoft.demoide.CustomerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
class AccountController {

    public final CustomerRepository repository;

    AccountController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @RequestMapping("view")
    public Customer customerView(
            @RequestParam(name = "id") long id
    ) {
        Customer one = repository.getOne(id);
        return new Customer("Adam", null);
    }
}
