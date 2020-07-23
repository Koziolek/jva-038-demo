package com.luxoft.demoide.infra;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MyLifecycle implements InitializingBean, DisposableBean {


    @PostConstruct
    public void postConstruct2(){
        System.out.println("postConstruct2");

    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("PreDestroy");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }
}
