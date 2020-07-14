package com.luxoft.demoide;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class DemoIdeApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void helloTest() {
        String forObject = restTemplate.getForObject("/", String.class);

        System.out.println(forObject);
    }

}
