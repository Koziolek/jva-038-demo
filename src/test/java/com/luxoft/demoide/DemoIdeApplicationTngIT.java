package com.luxoft.demoide;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.testng.annotations.Test;

class DemoIdeApplicationTngIT extends BaseIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test()
    void helloTest() {
        String html = restTemplate.getForObject("/", String.class);

        Assertions.assertThat(html).contains("customer");
    }
}
