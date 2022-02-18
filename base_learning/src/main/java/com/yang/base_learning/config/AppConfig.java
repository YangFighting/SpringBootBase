package com.yang.base_learning.config;

import com.yang.base_learning.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public HelloService helloService() {
        System.out.println(" helloService add...");
        return new HelloService();
    }
}
