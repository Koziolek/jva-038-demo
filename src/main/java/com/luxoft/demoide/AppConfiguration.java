package com.luxoft.demoide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath*:applicationContext.xml")
class AppConfiguration {
    @Bean
    public CommandLineRunner demoData(CustomerRepository customerRepository,
                                      @Qualifier(value = "company") String company,
    @Value(value = "${info.build.version}") String version){
        return args -> {
            System.out.println("New customers");
            System.out.println(company);
            System.out.println(version);
            customerRepository.save(new Customer("Jan"));
            customerRepository.save(new Customer("Jakub"));
            customerRepository.save(new Customer("Anna"));
            customerRepository.save(new Customer("Ewelina"));
        };
    }
}
