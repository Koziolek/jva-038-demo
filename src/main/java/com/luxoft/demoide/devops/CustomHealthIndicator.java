package com.luxoft.demoide.devops;

import com.luxoft.demoide.CustomerRepository;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
class CustomHealthIndicator extends AbstractHealthIndicator {

    private final CustomerRepository repository;

    CustomHealthIndicator(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // TU JEST LOGIKA!!!!
        builder.up()
                .withDetail("State", "On")
                .withDetail("Number of customers", repository.count())
                .withDetail("Params", "Ready, 100");

    }
}
