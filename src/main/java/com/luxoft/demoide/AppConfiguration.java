package com.luxoft.demoide;

import com.luxoft.demoide.auth.LdapProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@ImportResource(locations = {"classpath*:applicationContext.xml",
        "classpath*:applicationContext2.xml"})
class AppConfiguration {

    @Bean
    public CommandLineRunner demoData(CustomerRepository customerRepository,
                                      CompanyRepository companyRepository,
                                      @Qualifier(value = "company") String company,
                                      @Value(value = "${info.build.version}") String version) {
        return args -> {
            System.out.println("New customers");
            System.out.println(company);
            Company luxoft = new Company(company);
            companyRepository.save(luxoft);
            customerRepository.save(new Customer("Jan", luxoft));
            customerRepository.save(new Customer("Jakub", luxoft));
            customerRepository.save(new Customer("Anna", luxoft));
            customerRepository.save(new Customer("Ewelina", luxoft));
        };
    }

    @Bean
    public View jsonTemplate() {
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setPrettyPrint(true);
        return view;
    }

    @Bean
    public ViewResolver viewResolver() {
        return new BeanNameViewResolver();
    }
}
